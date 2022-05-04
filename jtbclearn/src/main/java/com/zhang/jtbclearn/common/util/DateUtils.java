package com.zhang.jtbclearn.common.util;

import java.lang.management.ManagementFactory;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.joda.time.DateTime;

/**
 * 时间工具类
 *
 * @author ruoyi
 */
public class DateUtils extends org.apache.commons.lang3.time.DateUtils
{
    public static String YYYY = "yyyy";

    public static String YYYY_MM = "yyyy-MM";

    public static String YYYY_MM_DD = "yyyy-MM-dd";

    public static String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

    public static String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    private static String[] parsePatterns = {
            "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM",
            "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM",
            "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM"};

    /**
     * 获取当前Date型日期
     *
     * @return Date() 当前日期
     */
    public static Date getNowDate()
    {
        return new Date();
    }

    /**
     * 获取当前日期, 默认格式为yyyy-MM-dd
     *
     * @return String
     */
    public static String getDate()
    {
        return dateTimeNow(YYYY_MM_DD);
    }

    public static final String getTime()
    {
        return dateTimeNow(YYYY_MM_DD_HH_MM_SS);
    }

    public static final String dateTimeNow()
    {
        return dateTimeNow(YYYYMMDDHHMMSS);
    }

    public static final String dateTimeNow(final String format)
    {
        return parseDateToStr(format, new Date());
    }

    public static final String dateTime(final Date date)
    {
        return parseDateToStr(YYYY_MM_DD, date);
    }

    public static final String parseDateToStr(final String format, final Date date)
    {
        return new SimpleDateFormat(format).format(date);
    }

    public static final Date dateTime(final String format, final String ts)
    {
        try
        {
            return new SimpleDateFormat(format).parse(ts);
        }
        catch (ParseException e)
        {
            throw new RuntimeException(e);
        }
    }

    /**
     * 日期路径 即年/月/日 如2018/08/08
     */
    public static final String datePath()
    {
        Date now = new Date();
        return DateFormatUtils.format(now, "yyyy/MM/dd");
    }

    /**
     * 日期路径 即年/月/日 如20180808
     */
    public static final String dateTime()
    {
        Date now = new Date();
        return DateFormatUtils.format(now, "yyyyMMdd");
    }

    /**
     * 日期型字符串转化为日期 格式
     */
    public static Date parseDate(Object str)
    {
        if (str == null)
        {
            return null;
        }
        try
        {
            return parseDate(str.toString(), parsePatterns);
        }
        catch (ParseException e)
        {
            return null;
        }
    }

    /**
     * 获取服务器启动时间
     */
    public static Date getServerStartDate()
    {
        long time = ManagementFactory.getRuntimeMXBean().getStartTime();
        return new Date(time);
    }

    public static boolean isDate(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(YYYY_MM_DD);
        try {
            simpleDateFormat.parse(str);
            return true;
        } catch (Exception e) {
        }
        return false;
    }

    /**
     * 计算两个时间差
     */
    public static String getDatePoor(Date endDate, Date nowDate)
    {
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        // long ns = 1000;
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - nowDate.getTime();
        // 计算差多少天
        long day = diff / nd;
        // 计算差多少小时
        long hour = diff % nd / nh;
        // 计算差多少分钟
        long min = diff % nd % nh / nm;
        // 计算差多少秒//输出结果
        // long sec = diff % nd % nh % nm / ns;
        return day + "天" + hour + "小时" + min + "分钟";
    }

    public static String getDateYear(Date date){
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        /*switch (format.toLowerCase()){
            case "yyyy":
                i = Calendar.YEAR;
                break;
            case "yyyy-mm":
                i = Calendar.MONTH;
                break;
            case "yyyy-mm-dd":
                i = Calendar.DAY_OF_MONTH;
                break;
            default:
                i = Calendar.YEAR;
        }*/
        int val = ca.get(Calendar.YEAR);
        return String.valueOf(val);
    }

    /**
     * 获取所给时间上加上多少分钟后的时间
     * @param d
     * @param min
     * @return
     */
    public static Date addMinutes(Date d, int min) {
        DateTime dateTime = new DateTime(d);
        dateTime = dateTime.plusMinutes(min);
        return dateTime.toDate();
    }
    /**两日期相差多少秒
     * @param startDate
     * @param endDate
     * @return
     */
    public static long getSecondPoor(Date startDate, Date endDate) {
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        long ns = 1000;
        long diff = endDate.getTime() - startDate.getTime();	// 获得两个时间的毫秒时间差异
        long hour = diff % nd / nh;
        long min = diff % nd % nh / nm;
        return (hour  * 60 * 60) + (min  * 60) + (diff % nd % nh % nm / ns);// 计算差多少秒//输出结果
    }


    /**
     * @Description：更加输入日期，获取输入日期的前一天
     * @Date：
     * @strData：参数格式：yyyy-MM-dd
     * @return：返回格式：yyyy-MM-dd
     */
    public static String getPreDateByDate(String strData) {
        String preDate = "";
        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = sdf.parse(strData);
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }

        c.setTime(date);
        int day1 = c.get(Calendar.DATE);
        c.set(Calendar.DATE, day1 - 1);
        preDate = sdf.format(c.getTime());
        return preDate;
    }


    /**
     * @Description：更加输入日期，获取输入日期的前一天
     * @Date：
     * @strData：参数格式：yyyy-MM-dd
     * @return：返回格式：yyyy-MM-dd
     */
    public static Date getPreDate(String strData) {
        String preDate = getPreDateByDate(strData);
        Date date = parseDate(preDate);
        return date;
    }

}
