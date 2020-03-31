package com.ryz2593.happy.util;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 日期常用工具类
 *
 * @author ryz2593
 */
public class DateUtil {
    private static Logger logger = Logger.getLogger(DateUtil.class);
    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    public static final String YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";

    public static final String DATE_FORMAT = "yyyy-MM-dd";

    public static final String DATE_MONTH_FORMAT = "yyyy-MM";

    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static final String DATE_DAY_FORMAT = "yyyyMMdd";

    public static final String DATE_DAY_TIME_FORMAT = "yyyyMMddHHmmss";


    public static final String DATE_TIME_ZONE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";

    public static final String HOUR_MINUTE = "HH:mm";

    public static final String HH_MM_SS = "HH:mm:ss";

    private String dateFormat = "yyyy-MM-dd";


    public static long getCurrentTimeSeconds() {
        return System.currentTimeMillis() / 1000;
    }

    /**
     * 如果解析错误则返回null
     *
     * @param text
     * @return
     */
    public static Date parse(String text) {
        if (StringUtils.isBlank(text)) {
            return null;
        }
        String t = text.trim();
        SimpleDateFormat frm = new SimpleDateFormat(DATE_FORMAT);
        try {
            return frm.parse(t);
        } catch (ParseException e) {
            return null;
        }
    }

    public static Date parse(String text, String format) {
        if (StringUtils.isBlank(text)) {
            return null;
        }
        SimpleDateFormat frm = new SimpleDateFormat(format);
        try {
            return frm.parse(text);
        } catch (ParseException e) {
            return null;
        }
    }

    public static String parse(Date date) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT);
        return format.format(date);
    }

    public static String parse(Date date, String format) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat fmat = new SimpleDateFormat(format);
        return fmat.format(date);
    }

    /**
     * 把时间的时分秒设置为 23:59:59 999
     *
     * @param date
     * @return
     */
    public static Date endTimeOfDay(Date date) {
        if (date == null) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);
        return cal.getTime();
    }

    /**
     * 把时间的时分秒设置为 0:0:0 0
     *
     * @param date
     * @return
     */
    public static Date beginTimeOfDay(Date date) {
        if (date == null) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 在当前日期的基础上加减天数
     *
     * @param date
     * @param day
     * @return
     */
    public static Date addDay(Date date, int day) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH) + day);
        return cal.getTime();
    }

    /**
     * 在当前日期的基础上减去多少天
     *
     * @param date
     * @param day
     * @return
     */
    public static Date detractDay(Date date, int day) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH) - day);
        return cal.getTime();
    }

    /**
     * 是否只包含日期部分，不包含时分秒部分
     *
     * @param input
     * @return
     */
    public static boolean isDate(String input) {
        if (StringUtils.isBlank(input)) {
            return false;
        }
        Matcher matcher = Pattern.compile("^(\\d{4})-(0\\d{1}|[1-9]|1[0-2])-([1-9]|0\\d{1}|[12]\\d{1}|3[01])$")
                .matcher(input);
        return matcher.matches();
    }

    public static boolean isDateTime(String input, String formt) {
        SimpleDateFormat df = new SimpleDateFormat(formt);
        try {
            df.parse(input);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public static int getHour(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    public static long getHourOfDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTimeInMillis();
    }

    public static long parseTimeInMillis(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.getTimeInMillis();
    }

    public static Date getDate(String date) {
        return getDate(date, YYYY_MM_DD_HH_MM_SS);
    }

    public static Date getDate(String date, String format) {
        SimpleDateFormat df = new SimpleDateFormat(format);
        try {
            return df.parse(date);
        } catch (ParseException e) {

            logger.error(e);
        }

        return null;
    }

    public static int getDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    public static String getDate(Date date, String format) {
        SimpleDateFormat df = new SimpleDateFormat(format);
        return df.format(date);
    }

    public static Date addMonth(Date date, int i) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) + i);
        return cal.getTime();
    }

    public static int getDay(Date date) {
        return Integer.valueOf(getDate(date, DATE_DAY_FORMAT));
    }

    /**
     * 每周从星期一开始、星期天结束
     *
     * @param date
     * @return
     */
    public static int getDayOfWeek(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int day = cal.get(Calendar.DAY_OF_WEEK);
        if (day == 1) {
            day = 7;
        } else {
            day--;
        }
        return day;
    }

    public static int getWeekOfYear(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.WEEK_OF_YEAR);
    }

    public static int getWeekOfYearBeginOfMonday(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int weekOfYear = cal.get(Calendar.WEEK_OF_YEAR);
        int day = cal.get(Calendar.DAY_OF_WEEK);
        if (day == 1) { // 星期天
            weekOfYear--;
        }
        return weekOfYear;
    }

    public static int getYear(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.YEAR);
    }

    public static int getMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.MONTH);
    }

    public static int getMinute(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.MINUTE);
    }

    /**
     * 月初第一天
     *
     * @param date
     * @return
     */
    public static Date beginOfMonth(Date date) {
        if (date == null)
            return date;
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * n为推迟的周数，0本周，-1向前推迟一周，1下周，依次类推
     *
     * @param n
     * @param weekDay
     * @return
     */
    public static String getWeekDay(int n, int weekDay) {
        Calendar cal = Calendar.getInstance();

        cal.add(Calendar.DATE, n * 7);
        // 想周几，这里就传几Calendar.MONDAY（TUESDAY...）
        cal.set(Calendar.DAY_OF_WEEK, weekDay);
        return new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime()) + " 00:00:00";
    }

    public static Date valueOf(long timestamp) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timestamp);
        return calendar.getTime();
    }

    public static long betweenDays(Date begin, Date end) {

        long dtl = beginTimeOfDay(end).getTime() - beginTimeOfDay(begin).getTime();

        return dtl / (1000 * 3600 * 24);
    }

    public static void recursionDay(Date begin, Date end, List<String> allDays) {
        if (begin.after(end)) {
            return;
        }

        Date b = DateUtil.beginTimeOfDay(begin);
        Date e = DateUtil.endTimeOfDay(begin);
        if (e.after(end)) {
            e = end;
        }

        allDays.add(DateUtil.parse(b));

        recursionDay(DateUtil.beginTimeOfDay(DateUtil.addDay(begin, 1)), end, allDays);

    }

    public static void recursionMonth(Date begin, Date end) {
        if (begin.after(end)) {
            return;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(begin);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));

        Date e = cal.getTime();
        e = DateUtil.endTimeOfDay(e);
        if (e.after(end)) {
            e = end;
        }

        recursionMonth(DateUtil.beginTimeOfDay(DateUtil.addDay(e, 1)), end);
    }

    public static void recursionWeek(Date begin, Date end, List<Date> lastDayOfWeek) {
        if (begin.after(end)) {
            return;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(begin);
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        dayOfWeek = dayOfWeek == 1 ? 7 : dayOfWeek - 1;
        Date b = DateUtil.beginTimeOfDay(begin);

        Date e;
        if (dayOfWeek == 7) {
            e = DateUtil.endTimeOfDay(begin);
        } else {
            e = DateUtil.addDay(b, 7 - dayOfWeek);
            e = DateUtil.endTimeOfDay(e);
        }

        if (e.after(end)) {
            e = end;
        }

        lastDayOfWeek.add(e);

        recursionWeek(DateUtil.beginTimeOfDay(DateUtil.addDay(e, 1)), end, lastDayOfWeek);

    }

    public static void recursionWeek(Date begin, Date end, Map<Date, Date> weekDates) {
        if (begin.after(end)) {
            return;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(begin);
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        dayOfWeek = dayOfWeek == 1 ? 7 : dayOfWeek - 1;
        Date b = DateUtil.beginTimeOfDay(begin);

        Date e;
        if (dayOfWeek == 7) {
            e = begin;
        } else {
            e = DateUtil.addDay(b, 7 - dayOfWeek);
        }

        if (e.equals(end) || e.after(end)) {
            e = end;
        } else {
            e = DateUtil.addDay(e, 1);
        }

        weekDates.put(b, e);

        if (!e.equals(end)) {
            recursionWeek(e, end, weekDates);
        }

    }

    /**
     * 判断日期是否昨天 或者前天.....
     *
     * @param paramDate 要判断的时间
     * @param day       昨天传1 前天传2以此类推
     * @return
     * @throws ParseException
     */
    public static boolean judgeDay(Date paramDate, Integer day) throws ParseException {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String todayStr = format.format(date);
        // 得到今天零时零分零秒这一时刻
        Date today = format.parse(todayStr);
        // 与今日零时零分零秒比较
        if ((today.getTime() - paramDate.getTime()) > (day - 1) * 86400000
                && (today.getTime() - paramDate.getTime()) < day * 86400000) {
            return true;
        }
        return false;
    }

    /**
     * 判断日期是否今天.....
     *
     * @param paramDate 要判断的时间
     * @return
     * @throws ParseException
     */
    public static boolean judgeToday(Date paramDate) throws ParseException {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String todayStr = format.format(date);
        // 得到今天零时零分零秒这一时刻
        Date today = format.parse(todayStr);
        // 与今日零时零分零秒比较
        if ((paramDate.getTime() - today.getTime()) > 0 && (paramDate.getTime() - today.getTime()) < 86400000) {
            return true;
        }
        return false;
    }

    public static Date addMinute(Date date, int minutes) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.MINUTE, cal.get(Calendar.MINUTE) + minutes);
        return cal.getTime();
    }

    public static Date addSecond(Date date, int seconds) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.SECOND, cal.get(Calendar.SECOND) + seconds);
        return cal.getTime();
    }

    public static Date addHour(Date date, int hours) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR, cal.get(Calendar.HOUR) + hours);
        return cal.getTime();
    }

    /**
     * 开始时间和结束时间间的间隔.
     *
     * @param start 开始时间
     * @param end   结束时间
     * @return 时间间隔 毫秒粒度
     */
    public static long timeIntervalInDay(Date start, Date end) {
        Date now = beginTimeOfDay(end);
        return Math.abs(now.getTime() - start.getTime());
    }

    /**
     * 将日期时间转换成字符格式
     *
     * @param date
     * @param newformat
     * @return
     */
    public static String format(Date date, String newformat) {
        if (date == null) {
            return null;
        }
        String format = newformat;
        if (StringUtils.isBlank(format)) {
            format = YYYY_MM_DD_HH_MM_SS;
        }
        SimpleDateFormat formatt = new SimpleDateFormat(format);
        return formatt.format(date);
    }

    /**
     * 得到某个指定时区字符串对应的unix时间戳
     *
     * @param dateTimeStr 时间字符串
     * @param patten      时间格式字符串
     * @param timeZoneStr 时区字符串
     * @return unix时间戳
     */
    public static Long dateTimeOfTomeZone(String dateTimeStr, String patten, String timeZoneStr) {

        TimeZone timeZone = TimeZone.getTimeZone(timeZoneStr);
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(patten);
            simpleDateFormat.setTimeZone(timeZone);
            Date date = simpleDateFormat.parse(dateTimeStr);
            return date.getTime() / 1000;
        } catch (ParseException e) {
            logger.error("", e);
        }
        return null;
    }


    /**
     * 获取某个时区对应的时间
     *
     * @param dateTimeStr 时间字符串
     * @param patten      时间格式
     * @param offset      时差，单位：毫秒
     * @return
     */
    public static Date dateTimeOfTomeZone(String dateTimeStr, String patten, long offset) {


        Calendar cal = Calendar.getInstance();

        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(patten);
            Date date = simpleDateFormat.parse(dateTimeStr);
            return new Date(date.getTime() - cal.getTimeZone().getOffset(System.currentTimeMillis()) - offset);
        } catch (ParseException e) {
            logger.error("", e);
        }
        return null;
    }

    /**
     * 得到指定时区的date字符串
     *
     * @param unixTimeStamp 时间戳，单位:秒
     * @param patten        时间格式字符串
     * @param timeZoneStr   时区字符串
     * @return 格式化时间字符串
     */
    public static String format(Long unixTimeStamp, String patten, String timeZoneStr) {

        TimeZone timeZone = TimeZone.getTimeZone(timeZoneStr);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(patten);
        simpleDateFormat.setTimeZone(timeZone);
        return simpleDateFormat.format(unixTimeStamp * 1000);

    }

    /**
     * @param unixTimeStamp 时间戳，单位：秒
     * @param patten        时间格式
     * @param offset        偏移量，单位：秒
     * @return
     */
    public static String format(Long unixTimeStamp, String patten, Integer offset) {
//        TimeZone timeZone = TimeZone.getDefault();
//        String[] times = TimeZone.getAvailableIDs(rawOffset * 1000);
//        if (ArrayUtils.isNotEmpty(times)) {
//           String  timeZoneStr = times[0];
//            timeZone =TimeZone.getTimeZone(timeZoneStr);
//        }
        int localOffset = Calendar.getInstance().getTimeZone().getOffset(System.currentTimeMillis());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(patten);
//        simpleDateFormat.setTimeZone(timeZone);
        return simpleDateFormat.format(unixTimeStamp * 1000 - localOffset + offset * 1000);

    }

    /**
     * 得到指定时区的date字符串
     *
     * @param unixTimeStamp 时间戳，单位:秒
     * @param patten        时间格式字符串
     * @param timeZone      时区
     * @return 格式化时间字符串
     */
    public static String format(Long unixTimeStamp, String patten, TimeZone timeZone, Locale locale) {


        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(patten, locale);
        simpleDateFormat.setTimeZone(timeZone);
        return simpleDateFormat.format(unixTimeStamp * 1000);

    }

    public static String dateToStamp(String s) {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_TIME_FORMAT);
        Date date = null;
        try {
            date = simpleDateFormat.parse(s);
            long ts = date.getTime();
            res = String.valueOf(ts);
            return res;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 获取某个时间戳对应的 格式化字符串，使用美国太平洋时区
     *
     * @param unixTimeStamp 时间戳，单位:秒
     * @return 举例：12/26/2017 at 12:14 AM
     */
    public static String getYyyyMmDdHhMm(Long unixTimeStamp) {
        TimeZone timeZone = TimeZone.getTimeZone("US/Pacific");
        String d = format(unixTimeStamp, "MM/dd/yyyy", timeZone, Locale.US);
        String t = format(unixTimeStamp, "hh:mm a", timeZone, Locale.US);
        return d + " at " + t;

    }

    /**
     * 获取某个时间戳对应的 格式化字符串
     *
     * @param unixTimeStamp 时间戳，单位:秒
     * @param displayName   时区显示名称
     * @param offset        时区偏移量，单位：秒
     * @return 举例：US/Pacific 12/26/2017 at 12:14 AM
     */

    public static String getYyyyMmDdHhMm(Long unixTimeStamp, String displayName, Integer offset) {
        String timeZoneStr = "US/Pacific";
        String[] times = TimeZone.getAvailableIDs(offset * 1000);
        if (ArrayUtils.isNotEmpty(times)) {
            timeZoneStr = times[0];
        }

        TimeZone timeZone = TimeZone.getTimeZone(timeZoneStr);
        String d = format(unixTimeStamp, "MM/dd/yyyy", timeZone, Locale.US);
        String t = format(unixTimeStamp, "hh:mm a", timeZone, Locale.US);
        return displayName + " " + d + " at " + t;

    }

    /**
     * 获取当前时间距离今天最后一毫秒秒的差值
     *
     * @return
     */
    public static long getDvalueNowToEnd() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(DateUtil.addDay(new Date(), 1));
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        Date d = cal.getTime();
        return d.getTime() - (new Date()).getTime();
    }

    /**
     * 判断当前时间是否符合条件
     *
     * @param offset      时差偏移量，单位：秒
     * @param weekdays    周几，0周日，1周一....6周六，多个以逗号分开
     * @param startHour   开始小时
     * @param startMinute 开始分钟
     * @param startAmPm   开始上下午
     * @param endHour     结束小时
     * @param endMinute   结束分钟
     * @param endAmPm     结束上下午
     * @return
     */
    public static boolean isNowInRange(Integer offset, String weekdays, Integer startHour, Integer startMinute, String startAmPm, Integer endHour, Integer endMinute, String endAmPm) {

        offset = offset == null ? 0 : offset;
        weekdays = Strings.nullToEmpty(weekdays);
        startHour = startHour == null ? 0 : startHour;
        startMinute = startMinute == null ? 0 : startMinute;
        startAmPm = startAmPm == null ? "AM" : startAmPm;
        endHour = endHour == null ? 11 : endHour;
        endMinute = endMinute == null ? 59 : endMinute;
        endAmPm = endAmPm == null ? "PM" : endAmPm;

        String timeZoneStr = "US/Pacific";

        String[] times = TimeZone.getAvailableIDs(offset * 1000);
        if (ArrayUtils.isNotEmpty(times)) {
            timeZoneStr = times[0];
        }

        TimeZone timeZone = TimeZone.getTimeZone(timeZoneStr);
        Calendar cal = Calendar.getInstance(timeZone);
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);


        String[] weekdayAray = weekdays.split(",");
        List<Integer> weekdayList = Lists.newArrayList();
        if (weekdayAray != null) {
            for (String w : weekdayAray) {
                weekdayList.add(Integer.valueOf(w) + 1);
            }
        }
        if (!weekdayList.contains(dayOfWeek)) {
            return false;
        }

        Calendar calBegin = (Calendar) cal.clone();
        Calendar calEnd = (Calendar) cal.clone();


        calBegin.set(Calendar.HOUR, startHour);
        calBegin.set(Calendar.MINUTE, startMinute);
        calBegin.set(Calendar.AM_PM, "AM".equalsIgnoreCase(startAmPm) ? Calendar.AM : Calendar.PM);

        calEnd.set(Calendar.HOUR, endHour);
        calEnd.set(Calendar.MINUTE, endMinute);
        calEnd.set(Calendar.AM_PM, "AM".equalsIgnoreCase(endAmPm) ? Calendar.AM : Calendar.PM);


        return cal.compareTo(calEnd) <= 0 && cal.compareTo(calBegin) >= 0;
    }

    public static boolean isOnWork(List<WorkTime> workTimeList) {
        for (WorkTime workTime : workTimeList) {
            Integer offset = workTime.getTimeZoneOffset() == null ? 0 : workTime.getTimeZoneOffset();
            String weekdays = Strings.nullToEmpty(workTime.getWeekDays());
            Integer startHour = workTime.getStartHour() == null ? 0 : workTime.getStartHour();
            Integer startMinute = workTime.startMinute == null ? 0 : workTime.startMinute;
            String startAmPm = workTime.startAmPm == null ? "AM" : workTime.startAmPm;
            Integer endHour = workTime.endHour == null ? 11 : workTime.endHour;
            Integer endMinute = workTime.endMinute == null ? 59 : workTime.endMinute;
            String endAmPm = workTime.endAmPm == null ? "PM" : workTime.endAmPm;

            TimeZone timeZone = TimeZone.getTimeZone("US/Pacific");

            String[] times = TimeZone.getAvailableIDs();
            for (String timeId : times) {
                if (TimeZone.getTimeZone(timeId).getOffset(System.currentTimeMillis()) == offset * 1000) {
                    timeZone = TimeZone.getTimeZone(timeId);
                    break;
                }
            }


            Calendar cal = Calendar.getInstance(timeZone);
            int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK) - 1;


            if (!Integer.valueOf(weekdays).equals(dayOfWeek)) {
                continue;
            }

            Calendar calBegin = (Calendar) cal.clone();
            Calendar calEnd = (Calendar) cal.clone();


            calBegin.set(Calendar.HOUR, startHour);
            calBegin.set(Calendar.MINUTE, startMinute);
            calBegin.set(Calendar.AM_PM, "AM".equalsIgnoreCase(startAmPm) ? Calendar.AM : Calendar.PM);

            calEnd.set(Calendar.HOUR, endHour);
            calEnd.set(Calendar.MINUTE, endMinute);
            calEnd.set(Calendar.AM_PM, "AM".equalsIgnoreCase(endAmPm) ? Calendar.AM : Calendar.PM);
            if (cal.compareTo(calEnd) <= 0 && cal.compareTo(calBegin) >= 0) {
                return true;
            }
        }
        return false;
    }


    public static void heapSort(int s[]) {
        heapCreate(s);
        for (int i = s.length - 1; i > 0; i--) {
            int temp = s[0];
            s[0] = s[i];
            s[i] = temp;
            heapMin(s, 0, i);
        }


    }

    public static void heapCreate(int s[]) {
        for (int i = s.length / 2 - 1; i >= 0; i--) {
            heapMin(s, i, s.length);
        }
    }

    public static void heapMin(int s[], int root, int length) {
        int left = root * 2 + 1;
        int right = left + 1;
        if (left < length) {
            if (right < length) {
                if (s[left] < s[right]) {
                    left = right;
                }
            }
            if (s[left] > s[root]) {
                int temp = s[root];
                s[root] = s[left];
                s[left] = temp;
                heapMin(s, left, length);
            }


        }

    }


    public static void quikSort(int a[], int l, int r) {
        if (l < r) {
            if (isSOrt(a)) {
                return;
            }
            int x = a[l];
            int i = l;
            int j = r;
            while (i < j) {

                while (i < j) {
                    if (a[j] >= x) {
                        j--;
                    } else {
                        break;
                    }
                }
                if (i < j) {
                    a[i] = a[j];
                    i++;
                }

                while (i < j) {
                    if (a[i] < x) {
                        i++;
                    } else {
                        break;
                    }
                }
                if (i < j) {
                    a[j] = a[i];
                    j--;
                }

            }
            a[i] = x;
            quikSort(a, l, i - 1);
            quikSort(a, i + 1, r);
        }
    }

    private static boolean isSOrt(int[] a) {
        for (int i = 0; i < a.length - 2; i++) {
            if (a[i] > a[i + 1]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        WorkTime workTime = new WorkTime();
        workTime.setWeekDays("1");
        workTime.setTimeZoneOffset(-3600 * 7);
        workTime.setEndAmPm("aM");
        workTime.setEndHour(10);
        workTime.setEndMinute(8);
        List list = Lists.newArrayList();
        list.add(workTime);
        System.out.println(isOnWork(list));

//        for (String s : TimeZone.getAvailableIDs()) {
//            TimeZone t = TimeZone.getTimeZone(s);
//            if(t.getOffset(System.currentTimeMillis())==-25200000)
//            System.out.println(t.getID()+t.useDaylightTime()+","+t.inDaylightTime(new Date()) );
//        }
//        Calendar calendar=Calendar.getInstance(TimeZone.getTimeZone("Asia/Shanghai"));
//        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));


//        Long t=DateUtil.parse("2018-11-4 17:00:0",DateUtil.DATE_TIME_FORMAT).getTime();
//        System.out.println(t/1000);
//        String dt=DateUtil.format(1541322000L,DateUtil.DATE_TIME_FORMAT,"US/Pacific");
//        Long tt=DateUtil.dateTimeOfTomeZone("2018-11-4 1:00:0",DateUtil.DATE_TIME_FORMAT,"US/Pacific");
//        String dd=DateUtil.format(t/1000-3600,DateUtil.DATE_TIME_FORMAT,"US/Pacific");
//        Long t1 = System.currentTimeMillis();
//        Integer timeStamp = t1.intValue();
//
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateUtil.DATE_TIME_FORMAT);
////        simpleDateFormat.setTimeZone(timeZone);
//        System.out.println(simpleDateFormat.format(timeStamp));
//
//
//        System.out.println(DateUtil.format((System.currentTimeMillis() / 1000), DateUtil.DATE_TIME_FORMAT, "US/Pacific"));
//        simpleDateFormat.setTimeZone(timeZone);


        System.out.println(format(DateUtil.getCurrentTimeSeconds(), DATE_TIME_FORMAT, -7 * 3600));


    }

    public static class WorkTime {

        private Integer timeZoneOffset;

        private String weekDays;

        private Integer startHour;

        private Integer startMinute;

        private String startAmPm;

        private Integer endHour;

        private Integer endMinute;

        private String endAmPm;

        public Integer getTimeZoneOffset() {
            return timeZoneOffset;
        }

        public void setTimeZoneOffset(Integer timeZoneOffset) {
            this.timeZoneOffset = timeZoneOffset;
        }

        public String getWeekDays() {
            return weekDays;
        }

        public void setWeekDays(String weekDays) {
            this.weekDays = weekDays;
        }

        public Integer getStartHour() {
            return startHour;
        }

        public void setStartHour(Integer startHour) {
            this.startHour = startHour;
        }

        public Integer getStartMinute() {
            return startMinute;
        }

        public void setStartMinute(Integer startMinute) {
            this.startMinute = startMinute;
        }

        public String getStartAmPm() {
            return startAmPm;
        }

        public void setStartAmPm(String startAmPm) {
            this.startAmPm = startAmPm;
        }

        public Integer getEndHour() {
            return endHour;
        }

        public void setEndHour(Integer endHour) {
            this.endHour = endHour;
        }

        public Integer getEndMinute() {
            return endMinute;
        }

        public void setEndMinute(Integer endMinute) {
            this.endMinute = endMinute;
        }

        public String getEndAmPm() {
            return endAmPm;
        }

        public void setEndAmPm(String endAmPm) {
            this.endAmPm = endAmPm;
        }
    }

}





