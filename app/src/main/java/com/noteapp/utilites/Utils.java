package com.noteapp.utilites;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by shopclues on 30/7/16.
 */

public class Utils {

    public static String getCurrentTime(long timeInMs){
        Date date = new Date(timeInMs*1000);
        return String.valueOf(date.getTime());
    }

    public static String getDate(long milliSeconds) {

        Timestamp timestamp = new Timestamp(milliSeconds * 1000);
        Date date = new Date(timestamp.getTime());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yyyy");
        return (simpleDateFormat.format(date));
    }


    public static boolean objectValidator(Object obj) {
        if (obj == null || obj.equals(null))
            return false;
        if (obj instanceof String) {
            if (obj.toString().trim().length() <= 0 || obj.toString().trim().equalsIgnoreCase("null")) {
                return false;
            }
        } else if (obj instanceof List<?>) {
            if (((List<?>) obj).size() <= 0)
                return false;
        }
        return true;
    }


}
