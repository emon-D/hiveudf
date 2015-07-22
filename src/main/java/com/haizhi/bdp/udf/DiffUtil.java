package com.haizhi.bdp.udf;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DiffUtil {

    public static String dateDiff(String date1, String date2) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
        long diff;

        try {
            Date d1 = format.parse(date1);
            Date d2 = format.parse(date2);

            long timeDiff = d1.getTime() - d2.getTime();
            diff = timeDiff / (1000 * 60 * 60 * 24);
            return String.valueOf(diff);
        } catch (ParseException e) {
            return "INF";
        } catch (Exception e) {
            return "INF";
        }
    }

    public static String monthDiff(String date1, String date2) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
        long diff;

        try {
            Calendar cal1 = new GregorianCalendar();
            Calendar cal2 = new GregorianCalendar();

            cal1.setTime(format.parse(date1));
            cal2.setTime(format.parse(date2));

            diff = (cal1.get(Calendar.YEAR) - cal2.get(Calendar.YEAR)) * 12 + (cal1.get(Calendar.MONTH) - cal2.get(Calendar.MONTH));
            return String.valueOf(diff);
        } catch (ParseException e) {
            return "INF";
        } catch (Exception e) {
            return "INF";
        }
    }

    public static String yearDiff(String date1, String date2) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
        long diff;

        try {
            Calendar cal1 = new GregorianCalendar();
            Calendar cal2 = new GregorianCalendar();

            cal1.setTime(format.parse(date1));
            cal2.setTime(format.parse(date2));

            diff = cal1.get(Calendar.YEAR) - cal2.get(Calendar.YEAR);
            return String.valueOf(diff);
        } catch (ParseException e) {
            return "INF";
        } catch (Exception e) {
            return "INF";
        }
    }

    public static String hourDiff(String date1, String date2){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
        long diff;

        try {
            Date d1 = format.parse(date1);
            Date d2 = format.parse(date2);

            long timeDiff = d1.getTime() - d2.getTime();
            diff = timeDiff / (1000 * 60 * 60);
            return String.valueOf(diff);
        } catch (ParseException e) {
            return "INF";
        } catch (Exception e) {
            return "INF";
        }
    }

    public static String minuteDiff(String date1, String date2){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
        long diff;
        try {
            Date d1 = format.parse(date1);
            Date d2 = format.parse(date2);

            long timeDiff = d1.getTime() - d2.getTime();
            diff = timeDiff / (1000 * 60);
            return String.valueOf(diff);
        } catch (ParseException e) {
            return "INF";
        } catch (Exception e) {
            return "INF";
        }
    }

    public static String secondDiff(String date1, String date2){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
        long diff;
        try {
            Date d1 = format.parse(date1);
            Date d2 = format.parse(date2);

            long timeDiff = d1.getTime() - d2.getTime();
            diff = timeDiff / 1000;
            return String.valueOf(diff);
        } catch (ParseException e) {
            return "INF";
        } catch (Exception e) {
            return "INF";
        }
    }
}
