package com.killer.demo.utils;

import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.SimpleFormatter;

public class DateTimeUtils {

    public static String YYYY_MM = "_yyyy_MM";

    public static Date stringChangeDateType(String date) {
        if (StringUtils.isEmpty(date)) {
            return null;
        }
        Date dt = new Date();
        try {
            dt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dt;
    }

    public static String getYyyy_Mm(Date date) {
        if (ObjectUtils.isEmpty(date)) {
            date = new Date();
        }
        return new SimpleDateFormat(YYYY_MM).format(date);
    }

    /**
     * 获取当天开始时间
     * @param date
     * @return
     */
    public static Date getStartTime(Date date) {
        Calendar dateStart = Calendar.getInstance();
        dateStart.setTime(date);
        dateStart.set(Calendar.HOUR_OF_DAY, 0);
        dateStart.set(Calendar.MINUTE, 0);
        dateStart.set(Calendar.SECOND, 0);
        return dateStart.getTime();
    }

    /**
     * 获取当天结束3时间
     * @param date
     * @return
     */
    public static Date getEndTime(Date date) {
        Calendar dateEnd = Calendar.getInstance();
        dateEnd.setTime(date);
        dateEnd.set(Calendar.HOUR_OF_DAY, 23);
        dateEnd.set(Calendar.MINUTE, 59);
        dateEnd.set(Calendar.SECOND, 59);
        return dateEnd.getTime();
    }

    public static Date getAfterMinuteForDate(Date date, Integer num) {
        if (null == date) {
            date = new Date();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, +num);
       return calendar.getTime();
    }
}
