package com.ryz2593.happy;

import java.util.regex.Pattern;

/**
 * @autor ryz2593
 * @date 2019/9/5 22:46
 * @desc
 */
public class NumberUtil {

    /**
     * 用JAVA自带的函数
     * @param str
     * @return
     */
    public static boolean isNumeric(String str) {
        for (int i = str.length(); --i >= 0; ) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /*方法二：推荐，速度最快
     * 判断是否为整数
     * @param str 传入的字符串
     * @return 是整数返回true,否则返回false
     */

    public static boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }

    //方法三：
    public static boolean isNumeric3(String str){
        Pattern pattern = Pattern.compile("[0-9]*");
        return pattern.matcher(str).matches();
    }

    //方法四：
    public final static boolean isNumeric4(String s) {
        if (s != null && !"".equals(s.trim()))
            return s.matches("^[0-9]*$");
        else
            return false;
    }

    //方法五：用ascii码
    public static boolean isNumeric5(String str){
        for(int i=str.length();--i>=0;){
            int chr=str.charAt(i);
            if(chr<48 || chr>57)
                return false;
        }
        return true;
    }
}
