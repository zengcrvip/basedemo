package demo.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DateUtil {

    /**
     * 时间格式化字符串
     */
    public static final String TIME24FORMATTER = "yyyy-MM-dd HH:mm:ss";

    public static final String Y_M_D           = "yyyy-MM-dd";
    
    public static final String YMD           = "yyyyMMdd";

    static SimpleDateFormat    dateFormat      = new SimpleDateFormat(TIME24FORMATTER);

    /**
     * 获取当前时间（标准格式）
     */
    public static String getNowTime() {
        Date now = new Date();
        return dateFormat.format(now);
    }

    /**
     * 获取当前日期（格式YYYYMMDD）
     */
    public static String getNowDay() {
        Date now = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMDD");
        return formatter.format(now).substring(0, 7);
    }

    /**
     * 获取当前日期（格式YYYYMMDD）
     */
    public static String getNowDay(String dateFormat) {
        Date now = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
        return formatter.format(now);
    }

    /**
     * 获取当前月份（格式YYYYMM）
     */
    public static String getNowMonth() {
        Date now = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMM");
        return formatter.format(now);
    }
    
    /**
     * 获取上个月月份（格式YYYYMM）
     */
    public static String getLastMonth() {
        String str = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");

        Calendar lastDate = Calendar.getInstance();
        lastDate.add(Calendar.MONTH, -1);// 减一个月
        str = sdf.format(lastDate.getTime());
        return str;
    }

    /**
     * 获取当前月份（格式MM）
     */
    public static String getAcctMonth() {
        Date now = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("MM");
        return formatter.format(now);
    }

    /**
     * 获得N个月最后一天的日期
     */
    public static String getDurationMonthEnd(Integer duration) {
        String str = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Calendar lastDate = Calendar.getInstance();
        lastDate.add(Calendar.MONTH, duration);// 加N个月
        lastDate.set(Calendar.DATE, 1);// 把日期设置为当月第一天
        lastDate.roll(Calendar.DATE, -1);// 日期回滚一天，也就是本月最后一天
        lastDate.set(Calendar.HOUR, 23);
        lastDate.set(Calendar.MINUTE, 59);
        lastDate.set(Calendar.SECOND, 59);
        str = sdf.format(lastDate.getTime());
        return str;
    }

    /**
     * 根据传入的日期，欲转换成的日期样式，返回转换后的日期字符串
     * 
     * @param date - 日期
     * @param pattern - 具体的值范围见java.text.SimpleDateFormat的说明
     * @see SimpleDateFormat
     * @return String 转换后的日期字符串
     */
    public static String date2Str(Date date, String pattern) {
        DateFormat dateFormat = new SimpleDateFormat(pattern);
        return dateFormat.format(date);
    }

    /**
     * 将短时间格式字符串转换为时间yyyy-MM-dd
     * 
     * @param strDate
     * @return
     * @throws ParseException
     */
    public static Date strToDate(String strDate, String pattern) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        Date strtodate = formatter.parse(strDate);
        return strtodate;
    }

    // 获得下个月第一天的日期String
    public static String getNextMonthFirstStr() {
        String str = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Calendar lastDate = Calendar.getInstance();
        lastDate.add(Calendar.MONTH, 1);// 减一个月
        lastDate.set(Calendar.DATE, 1);// 把日期设置为当月第一天
        str = sdf.format(lastDate.getTime());
        return str;
    }
    
    /**
     * 按日推算日期
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param now
     * @param offset
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static String getOffsetDate(Date now, int offset){
        Calendar cal = Calendar.getInstance();
        cal.setTime(now);
        cal.add(Calendar.DAY_OF_MONTH, offset);
        return new SimpleDateFormat("yyyyMMdd").format(cal.getTime());
    }
    
    /**
     * 获取当月最后一天
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param now
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static String getFirstDayOfMonth(Date now, int monthOffset){
        Calendar cal = Calendar.getInstance();
        cal.setTime(now);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.add(Calendar.MONTH, monthOffset);
        return new SimpleDateFormat("yyyyMMdd").format(cal.getTime());
    }
    
    /**
     * 获取当月最后一天
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param now
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static String getLastDayOfMonth(Date now, int monthOffset){
        Calendar cal = Calendar.getInstance();
        cal.setTime(now);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.add(Calendar.MONTH, monthOffset);
        cal.add(Calendar.MONTH, 1);
        cal.add(Calendar.DAY_OF_MONTH, -1);
        return new SimpleDateFormat("yyyyMMdd").format(cal.getTime());
    }
    
    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param now
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static String getFirstDayOfWeek(Date now){
        Calendar cal = Calendar.getInstance();
        cal.setTime(now);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return new SimpleDateFormat("yyyyMMdd").format(cal.getTime());
    }
    
    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param now
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static String getLastDayOfWeek(Date now){
        Calendar cal = Calendar.getInstance();
        cal.setTime(now);
        cal.add(Calendar.WEEK_OF_YEAR, 1);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        return new SimpleDateFormat("yyyyMMdd").format(cal.getTime());
    }
    
    /**
     * 获取天数间隔
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param begin
     * @param end
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static int getOffsetDays(Date begin, Date end){
        return (int)((end.getTime() - begin.getTime())/86400000);
    }

    /**
     * 
     * 功能描述：计算相对于dateStr的日期，如果转换日期为上个月同期日期 dateStr<BR>
     * theFormat="yyyyMMdd"，feildnum=Calendar.WEEK_OF_YEAR，thenum=-4。
     * 输入参数：<按照参数定义顺序>
     * @param dateStr设置参照的日期，theFormat设置参照日期格式，feildnum处理方式，thenum计算值 返回值: 类型
     *            <说明>
     * @return 指定格式的相对于dateStr的日期，返回值类型是String
     * @throw 异常描述
     */
    public static String convertDate(String dateStr, String theFormat, int feildnum, int thenum) {
        SimpleDateFormat formatter = null;
        Calendar cldr = null;
        Date date_pre = null;
        Date date1 = null;
        try {
            formatter = new SimpleDateFormat(theFormat, Locale.CHINESE);
            cldr = new GregorianCalendar();
            date1 = formatter.parse(dateStr);
            cldr.setTime(date1);
            cldr.add(feildnum, thenum);
            date_pre = cldr.getTime();
        } catch (Exception e) {

        }
        if (date_pre == null)
            return formatter.format(date1);
        else
            return formatter.format(date_pre);
    }
}
