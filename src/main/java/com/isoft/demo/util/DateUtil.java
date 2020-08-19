package com.isoft.demo.util;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    /**
     * java.util.Date 转换为字符串
     * @param date
     * @return 转换结果字符串格式为 yyyy-MM-dd
     */
    public static String date2Str(Date date){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
       // DataFormat df = new SimpleFormatter("yyyy-MM-dd HH:mm:ss");
        return df.format(date);
    }
    /**
     * 字符串转Date
     * @param dateStr  格式必须是 yyyy-MM-dd
     * @return
     */
    public static Date Str2Date(String dateStr){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return df.parse(dateStr);
        }catch (ParseException e){
            e.printStackTrace();
            return null;
        }
    }
    public static Date Str2Date2(String dateStr){
        DateFormat df = new SimpleDateFormat("yyyy年MM月dd日");
        try {
            return df.parse(dateStr);
        }catch (ParseException e){
            e.printStackTrace();
            return null;
        }
    }
}
