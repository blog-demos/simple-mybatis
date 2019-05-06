package git.simple.mybatis.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * @Description 日期工具类
 * @Author Q-WHai
 * @Date 2019/4/15 21:54
 */
public class DatetimeUtils {

    public static String format(int datetime) {
        return format(datetime, "yyyy-MM-dd HH:mm:ss");
    }

    public static String format(int datetime, String format) {
        return new SimpleDateFormat(format).format(new Date(((long) datetime) * 1000));
    }

    /**
     * 计算date的后一天
     *
     * @param date  date
     * @return      Date
     */
    public static Date nextDate(Date date) {
        if (null == date) return null;

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DATE, c.get(Calendar.DATE) + 1);

        return c.getTime();
    }

    /**
     * 格式化日期
     *
     * @param string    eg: 2019-01-01
     * @param format    eg: yyyy-MM-dd
     * @return      Date
     */
    public static Date format(String string, String format) {
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            date = sdf.parse(string);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        return date;
    }

    public static Date format(String string) {
        return format(string, "yyyy-MM-dd");
    }

    public static String format(Date date) {
        return format(date, "yyyy-MM-dd");
    }

    public static String format(Date date, String format) {
        return new SimpleDateFormat(format).format(date);
    }

    /**
     * 是否是同一天
     *
     * @param d1    d1
     * @param d2    d2
     * @return      true:是同一天 / false:不是同一天
     */
    public static boolean isSameDay(Date d1, Date d2) {
        if(d1 != null && d2 != null) {
            Calendar cal1 = Calendar.getInstance();
            cal1.setTime(d1);
            Calendar cal2 = Calendar.getInstance();
            cal2.setTime(d2);
            return isSameDay(cal1, cal2);
        } else {
            throw new IllegalArgumentException("The date must not be null");
        }
    }

    /**
     * 是否是同一天
     *
     * @param c1    c1
     * @param c2    c2
     * @return      true:是同一天 / false:不是同一天
     */
    public static boolean isSameDay(Calendar c1, Calendar c2) {
        if(c1 != null && c2 != null) {
            return c1.get(0) == c2.get(0) && c1.get(1) == c2.get(1) && c1.get(6) == c2.get(6);
        } else {
            throw new IllegalArgumentException("The date must not be null");
        }
    }

    /**
     * d1 是否早于 d2（仅计算日期，不计算时间）
     * @param d1    d1
     * @param d2    d2
     * @return      true:d1早于d2 / false:d1不早于d2
     */
    public static boolean isBeforDay(Date d1, Date d2) {
        Date dt1 = format(format(d1));
        Date dt2 = format(format(d2));

        return dt1.before(dt2);
    }

    public static Date random(Date d1, Date d2) {
        Calendar c1 = Calendar.getInstance();
        c1.setTime(d1);

        Calendar c2 = Calendar.getInstance();
        c2.setTime(d2);

        int x = nextInt((int) (c1.getTimeInMillis() / 1000), (int) (c2.getTimeInMillis() / 1000));
        String date = format(x);

        return format(date);
    }

    public static String random(String d1, String d2) {
        Calendar c1 = Calendar.getInstance();
        c1.setTime(format(d1));

        Calendar c2 = Calendar.getInstance();
        c2.setTime(format(d2));

        int x = nextInt((int) (c1.getTimeInMillis() / 1000), (int) (c2.getTimeInMillis() / 1000));
        return format(x);
    }

    private static int nextInt(int start, int end) {
        return new Random().nextInt(Math.abs(start - end) + 1) + Math.min(start, end);
    }
}
