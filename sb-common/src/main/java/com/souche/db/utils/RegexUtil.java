package com.souche.db.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtil {

    /**
     * 验证手机号码（支持国际格式，+86135xxxx...（中国内地），+00852137xxxx...（中国香港））
     * @param mobile 移动、联通、电信运营商的号码段
     * 中国移动：134（不含1349）、135、136、137、138、139、147、150、151、152、157、158、 159、182、183、184、187、188、178
     * 中国联通：130、131、132、145（上网卡）、155、156、185、186、176
      * 中国电信：133、1349（卫星通信）、153、180、181、189、177、173
      * 4G号段：176(联通)、173/177(电信)、178(移动)
      * 虚拟运营商：170[1700/1701/1702(电信)、1703/1705/1706(移动)、1704/1707/1708/1709(联通)]、171（联通）
      * 未知号段：140、141、142、143、144、146、148、149、154
      */
    public static final String REGEX_MOBILE = "(\\+\\d+)?1[34578]\\d{9}$";
    
    /**
     * 验证固定电话号码
     * @param phone 电话号码，格式：国家（地区）电话代码 + 区号（城市代码） + 电话号码，如：+8602085588447
     * <p><b>国家（地区） 代码 ：</b>标识电话号码的国家（地区）的标准国家（地区）代码。它包含从 0 到 9 的一位或多位数字，
     *  数字之后是空格分隔的国家（地区）代码。</p>
     * <p><b>区号（城市代码）：</b>这可能包含一个或多个从 0 到 9 的数字，地区或城市代码放在圆括号——
     * 对不使用地区或城市代码的国家（地区），则省略该组件。</p>
     * <p><b>电话号码：</b>这包含从 0 到 9 的一个或多个数字 </p>
     */
    public static final String REGEX_PHONE = "(\\+\\d+)?(\\d{3,4}\\-?)?\\d{7,8}$";
    
    /**
     * 验证整数（正整数和负整数）
     * @param digit 一位或多位0-9之间的整数
     */
    public static final String REGEX_DIGIT = "[\\-\\+]?\\d+";
    
    /**
     * 验证整数和浮点数（正负整数和正负浮点数）
     * @param decimals 一位或多位0-9之间的浮点数，如：1.23，233.30
    
     */
    public static final String REGEX_DECIMALS = "^[+-]?(\\d*\\.)?\\d+$";
    
    /**
     * 验证空白字符
     * @param blankSpace 空白字符，包括：空格、\t、\n、\r、\f、\x0B
    
     */
    public static final String REGEX_BLANK = "\\s+"; 
    
    /**
     * 匹配中国邮政编码
     * @param postcode 邮政编码
    
     */
    public static final String REGEX_POSTCODE = "[1-9]\\d{5}";
    
    /**
     * 校验银行卡卡号
     * @param card
     */
    public static final String REGEX_BANK_CARD = "\\d{16,19}";

    /**
     * 正则表达式：验证邮箱
     */
    public static final String REGEX_EMAIL = "[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?";

    /**
     * 正则表达式：验证汉字
     */
    public static final String REGEX_CHINESE = "^[\\u4E00-\\u9FFF]+$";

    /**
     * 正则表达式：验证身份证
     */
    public static final String REGEX_ID_CARD = "^((\\d{15}$)|(^\\d{18})|([1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}[\\d|x]))$";

    /**
     * 正则表达式：验证URL
     */
    public static final String REGEX_URL = "^(https?://)?([\\w-_]+\\.)+[a-zA-Z]{1,4}(/.*)*$";

    /** 验证是否是ipv4 */
    public static final String REGEX_IP_V4 = "^((\\d|\\d{2}|1\\d{2}|2[0-4]\\d|25[0-5])\\.){3}(\\d|\\d{2}|1\\d{2}|2[0-4]\\d|25[0-5])$";

    /***
     * 验证是否是ipv6
     */
    public static final String REGEX_IP_V6 = "^([\\da-fA-F]{1,4}:){7}[\\da-fA-F]{1,4}$";
    
    /**
     * 正则表达式：验证IP地址<br>
     * 请用 REGEX_IP_V4 或者 REGEX_IP_V6
     */
    @Deprecated
    public static final String REGEX_IP_ADDR = REGEX_IP_V4;
    
    /**
     * 验证手机号码（支持国际格式，+86135xxxx...（中国内地），+00852137xxxx...（中国香港））
     * @param mobile 移动、联通、电信运营商的号码段
     * 中国移动：134（不含1349）、135、136、137、138、139、147、150、151、152、157、158、 159、182、183、184、187、188、178
     * 中国联通：130、131、132、145（上网卡）、155、156、185、186、176
      * 中国电信：133、1349（卫星通信）、153、180、181、189、177、173
      * 4G号段：176(联通)、173/177(电信)、178(移动)
      * 虚拟运营商：170[1700/1701/1702(电信)、1703/1705/1706(移动)、1704/1707/1708/1709(联通)]、171（联通）
      * 未知号段：140、141、142、143、144、146、148、149、154
      */
    public static boolean isMobile(String mobile) {
        return isMatch(mobile, REGEX_MOBILE);
    }

    public static boolean isEmail(String email) {
        return isMatch(email, REGEX_EMAIL);
    }

    public static boolean isChinese(String str) {
        return isMatch(str, REGEX_CHINESE);
    }

    public static boolean isIDCard(String idNumber) {
        return isMatch(idNumber, REGEX_ID_CARD);
    }

    public static boolean isUrl(String url) {
        return isMatch(url, REGEX_URL);
    }

    /***
     * 校验是否是ipv4
     *
     * @param ip
     *
     * @return
     */
    public static boolean isIP4(String ip) {
        return isMatch(ip, REGEX_IP_V4);
    }

    /**
     * 校验是否是ipv6
     *
     * @param ip
     *
     * @return
     */
    public static boolean isIP6(String ip) {
        return isMatch(ip, REGEX_IP_V6);
    }

    /**
     * 校验是否是ip,包括ipv4和ipv6
     *
     * @param ip
     *
     * @return
     */
    public static boolean isIp(String ip) {
        return isIP4(ip) || isIP6(ip);
    }

    /**
     * 用正则表达式比较是否匹配
     *
     * @param input
     * @param reg
     *
     * @return 如果两个参数中都不为null 则进行正则匹配并返回匹配结果,否则直接返回false
     */
    public static boolean isMatch(String input, String reg) {
        if (input == null || reg == null) {
            return false;
        }

        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
    
    /**
     * 用正则表达式比较是否匹配, 不考虑大小写
     *
     * @param input
     * @param reg
     *
     * @return 如果两个参数中都不为null 则进行正则匹配并返回匹配结果,否则直接返回false
     */
    public static boolean isMatchIgnoreCase(String input, String reg) {
        if (input == null || reg == null) {
            return false;
        }
        Pattern pattern = Pattern.compile(reg,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
    
    /**
     * 验证固定电话号码
     * @param phone 电话号码，格式：国家（地区）电话代码 + 区号（城市代码） + 电话号码，如：+8602085588447
     * <p><b>国家（地区） 代码 ：</b>标识电话号码的国家（地区）的标准国家（地区）代码。它包含从 0 到 9 的一位或多位数字，
     *  数字之后是空格分隔的国家（地区）代码。</p>
     * <p><b>区号（城市代码）：</b>这可能包含一个或多个从 0 到 9 的数字，地区或城市代码放在圆括号——
     * 对不使用地区或城市代码的国家（地区），则省略该组件。</p>
     * <p><b>电话号码：</b>这包含从 0 到 9 的一个或多个数字 </p>
     */
    public static boolean isPhone(String phone){
        return isMatch(phone, REGEX_PHONE);
    }
    
    /**
     * 验证整数（正整数和负整数）
     * @param digit 一位或多位0-9之间的整数
     */
    public static boolean isDigit(String digit){
        return isMatch(digit, REGEX_DIGIT);
    }
    
    /**
     * 验证整数和浮点数（正负整数和正负浮点数）
     * @param decimals      要验证的数
     * @param decimal       小数部分的最大长度
     */
    public static boolean decimals(String decimals,int decimal) {
        if(StringUtils.isEmpty(decimals) || ".".equals(decimals)){
            return false;
        } 
        final String regex = "^[+-]?(\\d*)?(\\.)?\\d{0,"+decimal+"}$";
        return Pattern.matches(regex,decimals);
    }
    
    public static boolean decimals(String decimals){
        return isMatch(decimals, REGEX_DECIMALS);
    }
    
    /**
     * 验证空白字符
     * @param blankSpace 空白字符，包括：空格、\t、\n、\r、\f、\x0B
     */
    public static boolean isBlank(String blankSpace){
        return isMatch(blankSpace, REGEX_BLANK);
    }
    
    /**
     * 匹配中国邮政编码
     * @param postcode 邮政编码
     */
    public static boolean isPostcode(String postcode){
        return isMatch(postcode, REGEX_POSTCODE);
    }
    
    public static boolean isBankCard(String card) {
        String regex = "\\d{16,19}";
        if(!Pattern.matches(regex,card)){
            return false;
        } 
        char bit = getBankCardCheckCode(card.substring(0, card.length()-1));
        if(bit == 'N' || card.charAt(card.length()-1) !=bit){
            return false;
        } 
        return true;
    }
    
    /**
     * 从不含校验位的银行卡卡号采用 Luhm 校验算法获得校验位
     * @param nonCheckCodeCardId
     * @return
     */
    private static char getBankCardCheckCode(String nonCheckCodeCardId){
        if(nonCheckCodeCardId == null || nonCheckCodeCardId.trim().length() == 0
                || !nonCheckCodeCardId.matches("\\d+")) {
            //如果传的不是数据返回N
            return 'N';
        }
        char[] chs = nonCheckCodeCardId.trim().toCharArray();
        int luhmSum = 0;
        for(int i = chs.length - 1, j = 0; i >= 0; i--, j++) {
            int k = chs[i] - '0';
            if(j % 2 == 0) {
                k *= 2;
                k = k / 10 + k % 10;
            }
            luhmSum += k;           
        }
        return (luhmSum % 10 == 0) ? '0' : (char)((10 - luhmSum % 10) + '0');
    }
}
