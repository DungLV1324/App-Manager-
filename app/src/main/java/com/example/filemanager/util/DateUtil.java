package com.example.filemanager.util;

import android.annotation.SuppressLint;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtil {
    public static String getFormatTime() {
        return Calendar.getInstance().get(Calendar.AM_PM) == Calendar.AM ? "AM" : "PM";
    }

    public static String formatTime(long time, String textFormat) {
        @SuppressLint("SimpleDateFormat") SimpleDateFormat simpleDateFormat = new SimpleDateFormat(textFormat, Locale.ENGLISH);
        return simpleDateFormat.format(time);
    }

    // Returns the format of the first day of the month
    public static long getFirstDayOfMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return calendar.getTime().getTime();
    }

    // Check if current year is leap year or not
    public static boolean isLeapYear(int year) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        return cal.getActualMaximum(Calendar.DAY_OF_YEAR) > 365 || (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0));
    }


    // Calculate the distance between 2 days
    public static int calculateDistanceDate(int day, int month, int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        int currentYear = calendar.get(Calendar.YEAR);
        int currentMonth = calendar.get(Calendar.MONTH) + 1;
        int currentDay = calendar.get(Calendar.DAY_OF_MONTH);

        //Countdown days, If the countdown date has arrived, it will automatically move to this date next year
//        if (currentYear > year) {
//            year = currentYear + 1;
//        } else if (currentYear == year) {
//            if (currentMonth > month) {
//                year = currentYear + 1;
//            } else if (currentMonth == month) {
//                if (currentDay > day) {
//                    year = currentYear + 1;
//                }
//            }
//        }
        String currentDate = currentYear + "/" + currentMonth + "/" + currentDay;
        String countDownDate = year + "/" + month + "/" + day;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        Date dateCurrent = null;
        Date dateCountDown = null;
        try {
            dateCurrent = formatter.parse(currentDate);
            dateCountDown = formatter.parse(countDownDate);
            if (dateCurrent == null || dateCountDown == null)
                return 0;
            return (int) ((dateCountDown.getTime() - dateCurrent.getTime()) / (1000 * 60 * 60 * 24));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return 0;
    }

}
