package com.souche.db.tool;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;

@Service("oot")
@Slf4j
public class ObjectOutputTool {

    public String outObjPropertyString(Object obj) {
        StringBuffer sb = new StringBuffer();
        if (null != obj) {
            try {
                this.getPropertyString(obj, sb);
            } catch (Exception e) {
                log.info("outObjPropertyString is error " + e.getMessage().toString());
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    public String getPropertyString(Object entityName, StringBuffer sb) throws Exception {
        Class<? extends Object> c = entityName.getClass();
        Field field[] = c.getDeclaredFields();
        Object obj = null;
        String classname = "";
        Object tempObj = null;
        sb.append("------ " + " begin ------\n");
        for (Field f : field) {

            sb.append(f.getName());
            sb.append(" : ");
            obj = invokeMethod(entityName, f.getName(), f.getType(), null);
            if (null != obj) {
                if (obj.getClass().isArray()) {
                    for (int i = 0; i < Array.getLength(obj); i++) {
                        tempObj = Array.get(obj, i);
                        if (tempObj.getClass().isPrimitive()) {
                            sb.append(tempObj.toString());
                        } else if (tempObj instanceof String) {
                            sb.append(tempObj.toString());
                        } else if (tempObj instanceof Date) {
                            sb.append(tempObj.toString());
                        } else if (tempObj instanceof Number) {
                            sb.append(tempObj.toString());
                        } else {
                            this.getPropertyString(tempObj, sb);
                        }
                    }
                }

                classname = obj.getClass().getName();
                if (classname.indexOf("com.db.model.") > -1) {
                    this.getPropertyString(obj, sb);
                }

            }

			/*
             * if (f.getType() == Address.class) { this.getPropertyString(obj ,
			 * sb); }
			 */

            sb.append(obj);
            sb.append("\n");
        }
        sb.append("------ " + " end ------\n");
        return sb.toString();
    }

    public Object invokeMethod(Object owner, String methodName, Class<?> fieldType, Object[] args) throws Exception {
        Class<? extends Object> ownerClass = owner.getClass();

        methodName = methodName.substring(0, 1).toUpperCase() + methodName.substring(1);
        Method method = null;
        try {
            if (fieldType == boolean.class) {
                method = ownerClass.getMethod("is" + methodName);
            } else {
                method = ownerClass.getMethod("get" + methodName);
            }
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            // e.printStackTrace();

            return " can't find 'get" + methodName + "' method";
        }

        return method.invoke(owner);

    }

}
