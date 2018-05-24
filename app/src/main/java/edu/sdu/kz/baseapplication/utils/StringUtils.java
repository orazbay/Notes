package edu.sdu.kz.baseapplication.utils;

/**
 * Created by orazbay on 4/7/18.
 */

public class StringUtils {
    public static boolean isNotEmpty(String text){
        return text!=null&&text.trim().length()>0;
    }
}
