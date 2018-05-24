package edu.sdu.kz.baseapplication.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static String getReadableDate(long dateInMillis){
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy HH:mm");
        Date resultdate = new Date(dateInMillis);
        return sdf.format(resultdate);
    }
}
