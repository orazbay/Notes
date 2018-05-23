package edu.sdu.kz.baseapplication.utils;

import android.util.Log;

public class WhereQueryGenerator {
    public static String generate(String ownerId){
        Log.e( "generate: ","ownerId%3D".concat(ownerId) );
        return "ownerId%3D".concat("'".concat(ownerId).concat("'"));
    }
}
