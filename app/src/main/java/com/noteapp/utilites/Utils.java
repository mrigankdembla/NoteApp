package com.noteapp.utilites;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

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
}
