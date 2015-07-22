package com.haizhi.bdp.udf;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateUtil {
    public static final int ONLY_WEEK = 1;

    public static String getWeekOfYear(String date, int fmt) {
        if(date == null) return "";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
        Calendar cal = new GregorianCalendar();
        try {
            cal.setTime(format.parse(date));
        } catch (ParseException e) {
            format = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
            try{
                cal.setTime(format.parse(date));
            } catch (ParseException e1) {
                e.printStackTrace();
                return "";
            }
        }
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        cal.setMinimalDaysInFirstWeek(7);
        int year = cal.get(Calendar.YEAR);
        if (isFirstWeek(cal)){
            year -= 1;
        }
        if (fmt == ONLY_WEEK){
            return "" + cal.get(Calendar.WEEK_OF_YEAR);
        }
        else{
            return year + " " + cal.get(Calendar.WEEK_OF_YEAR);
        }
    }

    public static String getWeekOfYear(String date) {
        return getWeekOfYear(date, 0);
    }

    public static int getQuarterOfYear(String date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
        Calendar cal = new GregorianCalendar();
        try {
            cal.setTime(format.parse(date));
        } catch (ParseException e) {
            format = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
            try{
                cal.setTime(format.parse(date));
            } catch (ParseException e1) {
                e.printStackTrace();
                return 0;
            }
        }
        return cal.get(Calendar.MONTH) / 3 + 1;
    }

    public static String unifyDate(String date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
        try {
            if (date.matches("^\\d{4} \\d{1,2} \\d{1,2} \\d{1,2} \\d{1,2}$")) {
                SimpleDateFormat minute = new SimpleDateFormat("yyyy MM dd HH mm");
                minute.setLenient(true);
                return format.format(minute.parse(date));
            }
            if (date.matches("^\\d{4} \\d{1,2} \\d{1,2} \\d{1,2}$")) {
                SimpleDateFormat hour = new SimpleDateFormat("yyyy MM dd HH");
                hour.setLenient(true);
                return format.format(hour.parse(date));
            }
            if (date.matches("^\\d{4} \\d{1,2} \\d{1,2}$")) {
                SimpleDateFormat day = new SimpleDateFormat("yyyy MM dd");
                day.setLenient(true);
                return format.format(day.parse(date));
            }
            if (date.matches("^\\d{4} \\d{1,2}$")) {
                SimpleDateFormat month = new SimpleDateFormat("yyyy MM");
                month.setLenient(true);
                return format.format(month.parse(date));
            }
            if (date.matches("^\\d{4}$")) {
                SimpleDateFormat year = new SimpleDateFormat("yyyy");
                year.setLenient(true);
                return format.format(year.parse(date));
            }
        } catch (ParseException e){
            return date;
        }
        return date;
    }

    protected static boolean isFirstWeek(Calendar cal){
        if (cal.get(Calendar.MONTH) == 0){
            return cal.get(Calendar.WEEK_OF_YEAR) == 52 || cal.get(Calendar.WEEK_OF_YEAR) == 53;
        }
        return false;
    }

    public static String getFirstDayOfMonth(int year, int month){
        Calendar cal = new GregorianCalendar();
        year = (year != 0) ? year : cal.get(Calendar.YEAR);
        month = (month != 0) ? month : cal.get(Calendar.MONTH) + 1;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
        String date = year+"-"+month+"-1 00:00:00";

        try {
            cal.setTime(format.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal.set(Calendar.DAY_OF_MONTH, 1);
        Date dt=cal.getTime();
        return format.format(dt);
    }

    public static String getLastDayOfMonth(int year, int month){
        Calendar cal = new GregorianCalendar();
        year = (year != 0) ? year : cal.get(Calendar.YEAR);
        month = (month != 0) ? month : cal.get(Calendar.MONTH) + 1;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
        String date = year+"-"+month+"-1 00:00:00";

        try {
            cal.setTime(format.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal.add(Calendar.MONTH, 1);
        cal.set(Calendar.DAY_OF_MONTH, 0);
        Date dt=cal.getTime();
        return format.format(dt);
    }

    public static int getWorkDayOfMonth(int year, int month){
        int work_day_count = 0;
        Calendar cal = new GregorianCalendar();
        year = (year != 0) ? year : cal.get(Calendar.YEAR);
        month = (month != 0) ? month : cal.get(Calendar.MONTH) + 1;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
        String date = year+"-"+month+"-1 00:00:00";

        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH,  month - 1);
        cal.set(Calendar.DATE, 1);


        while(cal.get(Calendar.YEAR) == year &&
                cal.get(Calendar.MONTH) < month){
            int day = cal.get(Calendar.DAY_OF_WEEK);

            if(!(day == Calendar.SUNDAY || day == Calendar.SATURDAY)){
                ++work_day_count;
            }
            cal.add(Calendar.DATE, 1);
        }
        return work_day_count;
    }

    public static String getDayOfWeek(String date) {
        Calendar cal = new GregorianCalendar();
        Date fmt_date = DateUtil.parse(date);
        if(fmt_date == null){
            return "0";
        }
        cal.setTime(fmt_date);
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        int day_of_week = (cal.get(Calendar.DAY_OF_WEEK) == 1) ? 7 : cal.get(Calendar.DAY_OF_WEEK) - 1;
        return "" + day_of_week;
    }

    public static Date parse(String value){
        List<SimpleDateFormat> formats = new ArrayList<SimpleDateFormat>();
        formats.add(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA));
        formats.add(new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA));
        for(SimpleDateFormat fmt: formats){
            try{
                return fmt.parse(value);
            } catch(ParseException e){

            }
        }
        return null;
    }


}
