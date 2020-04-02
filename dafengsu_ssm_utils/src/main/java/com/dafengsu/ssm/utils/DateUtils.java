package com.dafengsu.ssm.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author su
 * @description
 * @date 2020/3/31
 */
public class DateUtils {
    //日期转换成字符串
    public static String date2String(Date date, String pattern) {
        return new SimpleDateFormat(pattern).format(date);
    }

    //字符串转换成日期
    public static Date string2Date(String date, String pattern) throws ParseException {
        return new SimpleDateFormat(pattern).parse(date);
    }
}
