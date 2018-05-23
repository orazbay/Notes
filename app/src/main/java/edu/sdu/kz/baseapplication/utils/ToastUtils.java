package edu.sdu.kz.baseapplication.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by orazbay on 3/7/18.
 */

public class ToastUtils {
    public static void showToast(Context context, String message){
        Toast.makeText(context,message, Toast.LENGTH_SHORT).show();
    }
}
