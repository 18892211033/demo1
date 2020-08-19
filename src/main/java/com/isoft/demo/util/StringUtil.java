package com.isoft.demo.util;

public class StringUtil {
    public static boolean isEmpty(String s) {
        if(s == null || s.trim().length() == 0) {
            return true ;
        }
        return false ;
    }
}
