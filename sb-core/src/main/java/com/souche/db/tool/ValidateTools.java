package com.souche.db.tool;


import com.souche.db.annotation.Validate;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateTools {

    public static void validate(Object object, Validate validate) {
        validateRequire(object, validate);
        if (object == null) {
            return;
        }
        /**
         * 校验Collection
         */
        if (object instanceof Collection<?>) {
            Collection<?> temp = (Collection<?>) object;
            for (Object ob : temp) {
                validate(ob, validate);
            }
        }
        if (isBasicType(object)) {
            validateRange(object, validate);
            validateLength(object, validate);
            validateReg(object, validate);
            validateUserDefinedMethod(object, validate);
        } else {
            Field[] fields = object.getClass().getDeclaredFields();
            if (fields == null || fields.length == 0) {
                return;
            }
            for (Field field : fields) {
                Validate fieldValidate = field.getAnnotation(Validate.class);
                if (fieldValidate != null) {
                    field.setAccessible(true);
                    Object value = null;
                    try {
                        value = field.get(object);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    validate(value, fieldValidate);
                }
            }
        }
    }

    public static void validateRequire(Object object, Validate validate) {
        if (validate.require()) {
            if (object == null) {
                throw new RuntimeException(validate.failMessage());
            }
            if (object instanceof String) {
                String temp = (String) object;
                if (temp.trim().length() == 0) {
                    throw new RuntimeException(validate.failMessage());
                }
            }
            if (object instanceof Collection<?>) {
                Collection<?> temp = (Collection<?>) object;
                if (temp.isEmpty()) {
                    throw new RuntimeException(validate.failMessage());
                }
            }
        }
    }

    public static void validateRange(Object object, Validate validate) {
        if (object == null || validate.range().trim().length() == 0) {
            return;
        }
        if (!(object instanceof Number)) {
            throw new RuntimeException("不是Number类型的数据也想校验？？？");
        }
        if (!(validate.range().startsWith("[") || validate.range().startsWith("("))) {
            throw new RuntimeException("range格式错误(正确写法→_→range=[1,20)");
        }
        if (!(validate.range().endsWith("]") || validate.range().endsWith(")"))) {
            throw new RuntimeException("range格式错误(正确写法→_→range=[1,20)");
        }
        Number temp = (Number) object;
        String[] ranges = validate.range().split(",");
        Float realValue = temp.floatValue();
        if (ranges[0].startsWith("[")) {
            if (ranges[1].endsWith("]")) {
                ranges[0] = ranges[0].replace("[", "");
                ranges[1] = ranges[1].replace("]", "");
                if (!isStringEmpty(ranges[0]) && !(realValue >= Integer.parseInt(ranges[0]))) {
                    throw new RuntimeException(realValue + "必须大于等于" + ranges[0]);
                } else if (!isStringEmpty(ranges[1]) && !(realValue <= Integer.parseInt(ranges[1]))) {
                    throw new RuntimeException(realValue + "必须小于等于" + ranges[1]);
                }
            } else if (ranges[1].endsWith(")")) {
                ranges[0] = ranges[0].replace("[", "");
                ranges[1] = ranges[1].replace(")", "");
                if (!isStringEmpty(ranges[0]) && realValue < Integer.parseInt(ranges[0])) {
                    throw new RuntimeException(realValue + "必须大于等于" + ranges[0]);
                } else if (!isStringEmpty(ranges[1]) && realValue >= Integer.parseInt(ranges[1])) {
                    throw new RuntimeException(realValue + "必须小于" + ranges[1]);
                }
            }
        } else if (ranges[0].startsWith("(")) {
            if (ranges[1].endsWith("]")) {
                ranges[0] = ranges[0].replace("(", "");
                ranges[1] = ranges[1].replace("]", "");
                if (!isStringEmpty(ranges[0]) && !(realValue > Integer.parseInt(ranges[0]))) {
                    throw new RuntimeException(realValue + "必须大于" + ranges[0]);
                } else if (!isStringEmpty(ranges[1]) && !(realValue <= Integer.parseInt(ranges[1]))) {
                    throw new RuntimeException(realValue + "必须小于等于" + ranges[1]);
                }
            } else if (ranges[1].endsWith(")")) {
                ranges[0] = ranges[0].replace("(", "");
                ranges[1] = ranges[1].replace(")", "");
                if (!isStringEmpty(ranges[0]) && !(realValue > Integer.parseInt(ranges[0]))) {
                    throw new RuntimeException(realValue + "必须大于" + ranges[0] + "且小于" + ranges[1]);
                } else if (!isStringEmpty(ranges[1]) && !(realValue < Integer.parseInt(ranges[1]))) {
                    throw new RuntimeException(realValue + "必须小于" + ranges[1]);
                }
            }
        }

    }

    /**
     * 校验字符串的长度
     *
     * @param object
     * @param validate
     */
    public static void validateLength(Object object, Validate validate) {
        if (object == null || validate.length().trim().length() == 0) {
            return;
        }
        if (!(object instanceof String)) {
            throw new RuntimeException("只能校验String类型的参数");
        }
        String str = object.toString();
        if (str.trim().length() == 0) {
            return;
        }
        String[] lengths = validate.length().replace(" ", "").split(",");
        if (!(validate.length().startsWith("[") || validate.length().startsWith("("))) {
            throw new RuntimeException("length格式错误(正确写法→_→length=[1,20)");
        }
        if (!(validate.length().endsWith("]") || validate.length().endsWith(")"))) {
            throw new RuntimeException("length格式错误(正确写法→_→length=[1,20)");
        }
        if (lengths[0].contains("[")) {
            lengths[0] = lengths[0].replace("[", "");
            if (isNumber(lengths[0])) {
                int min = Integer.parseInt(lengths[0]);
                if (str.length() < min) {
                    throw new RuntimeException("参数长度应该大于或等于" + min + "个字符");
                }
            }

        } else if (lengths[0].contains("(")) {
            lengths[0] = lengths[0].replace("(", "");
            if (isNumber(lengths[0])) {
                int min = Integer.parseInt(lengths[0]);
                if (str.length() <= min) {
                    throw new RuntimeException("参数长度应该小于" + min + "个字符");
                }
            }
        }
        if (lengths[1].contains("]")) {
            lengths[1] = lengths[1].replace("]", "");
            if (isNumber(lengths[1])) {
                int max = Integer.parseInt(lengths[1]);
                if (str.length() > max) {
                    throw new RuntimeException("参数长度应该小于或等于" + max + "个字符");
                }
            }

        } else if (lengths[1].contains(")")) {
            lengths[1] = lengths[1].replace(")", "");
            if (isNumber(lengths[1])) {
                int max = Integer.parseInt(lengths[1]);
                if (str.length() >= max) {
                    throw new RuntimeException("参数长度应该小于" + max + "个字符");
                }
            }
        }
    }

    /**
     * 验证正则表达式的方法
     *
     * @param object
     * @param validate
     */
    public static void validateReg(Object object, Validate validate) {
        if (object == null || validate.reg().trim().length() == 0) {
            return;
        }
        if (!(object instanceof String)) {
            throw new RuntimeException("只能校验String类型的参数");
        }
        String str = object.toString();
        Pattern p = Pattern.compile(validate.reg());
        Matcher matcher = p.matcher(str);
        if (!matcher.matches()) {
            throw new RuntimeException(validate.failMessage());
        }

    }


    public static void validateUserDefinedMethod(Object object, Validate validate) {
        if (object == null) {
            return;
        }
        if (object instanceof String && object.toString().trim().length() == 0) {
            return;
        }
        if (validate.userDefinedMethod().trim().length() != 0) {
            int flag = validate.userDefinedMethod().lastIndexOf(".");
            String className = validate.userDefinedMethod().substring(0, flag);
            boolean result = true;
            try {
                Class<?> clazz = Class.forName(className);
                String methodName = validate.userDefinedMethod().substring(flag + 1,
                        validate.userDefinedMethod().length());
                Method method = clazz.getDeclaredMethod(methodName, new Class[]{object.getClass()});
                result = (boolean) method.invoke(clazz.newInstance(), object);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (!result) {
                throw new RuntimeException(validate.failMessage());
            }
        }
    }

    /**
     * 是否是基本类型
     *
     * @param object
     * @return
     */
    public static boolean isBasicType(Object object) {
        if (object instanceof Number || object instanceof String || object instanceof Character
                || object instanceof Boolean) {
            return true;
        }
        return false;
    }

    public static boolean isStringEmpty(String value) {
        if (value == null || value.trim().length() == 0) {
            return true;
        }
        return false;
    }

    public static boolean isNumber(String str) {
        String numberReg = "[0-9]+";
        Pattern numPattern = Pattern.compile(numberReg);
        Matcher m = numPattern.matcher(str);
        if (m.matches()) {
            return true;
        }
        return false;
    }

}
