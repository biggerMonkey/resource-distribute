package com.resource.distribute.utils;

/**
 * @author huangwenjun
 * @version 2018年7月23日 下午11:21:27
 */
public class SimpleStringUtils {
    public static String getFirstNumFromStr(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        String resultStr = "";
        boolean flag = false;
        if (str != null && !"".equals(str)) {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) >= 48 && str.charAt(i) <= 57) {
                    resultStr += str.charAt(i);
                    flag = !flag;
                } else {
                    if (flag) {
                        break;
                    }
                }
            }
        }
        return resultStr;
    }
}
