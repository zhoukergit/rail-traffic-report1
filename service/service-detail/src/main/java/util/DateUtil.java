package util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Date;

public class DateUtil {
    /**
     * 输入起始时间,截止时间(精确到时),返回yyyy-MM-dd HH:mm:ss
     *
     * @param beginDate yyyy-MM-dd HH
     * @param endDate   yyyy-MM-dd HH
     * @return
     */
    public static String randomDateTimeByHour(String beginDate, String endDate) {

        try {

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH");

            Date start = format.parse(beginDate);// 构造开始日期

            Date end = format.parse(endDate);// 构造结束日期

// getTime()表示返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象表示的毫秒数。

            if (start.getTime() >= end.getTime()) {

                return null;

            }

            long date = random(start.getTime(), end.getTime());
            format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return format.format(date);

        } catch (Exception e) {

            e.printStackTrace();

        }

        return null;

    }

    public static Date randomDate(String beginDate, String endDate) {

        try {

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

            Date start = format.parse(beginDate);// 构造开始日期

            Date end = format.parse(endDate);// 构造结束日期

// getTime()表示返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象表示的毫秒数。

            if (start.getTime() >= end.getTime()) {

                return null;

            }

            long date = random(start.getTime(), end.getTime());

            return new Date(date);

        } catch (Exception e) {

            e.printStackTrace();

        }

        return null;

    }

    public static String randomDateString(String beginDate, String endDate) {
        Date date = randomDate(beginDate, endDate);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }

    public static long random(long begin, long end) {

        long rtn = begin + (long) (Math.random() * (end - begin));

// 如果返回的是开始时间和结束时间，则递归调用本函数查找随机值

        if (rtn == begin || rtn == end) {

            return random(begin, end);

        }
        return rtn;
    }
}
