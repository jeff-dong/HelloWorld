package jxdong.web.common.util;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author <a href="jxdong@Ctrip.com">jeff</a>
 * @version 2015/7/02 11:13
 */
public class DateUtil {

    public static final int YEAR_RETURN = 0;

    public static final int MONTH_RETURN = 1;

    public static final int DAY_RETURN = 2;

    public static final int HOUR_RETURN = 3;

    public static final int MINUTE_RETURN = 4;

    public static final int SECOND_RETURN = 5;

    public static final String YYYY = "yyyy";

    public static final String YYYYMM = "yyyy-MM";

    public static final String YYYYMMDD = "yyyy-MM-dd";

    public static final String YYYYMMDDHH = "yyyy-MM-dd HH";

    public static final String YYYYMMDDHHMM = "yyyy-MM-dd HH:mm";

    public static final String YYYYMMDDHHMMSS = "yyyy-MM-dd HH:mm:ss";

    public static long getBetween(String beginTime, String endTime, String formatPattern, int returnPattern) {
        if(beginTime == null || endTime == null || formatPattern == null){
            return -1;
        }
        try{
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatPattern);
            Date beginDate = simpleDateFormat.parse(beginTime);
            Date endDate = simpleDateFormat.parse(endTime);

            Calendar beginCalendar = Calendar.getInstance();
            Calendar endCalendar = Calendar.getInstance();
            beginCalendar.setTime(beginDate);
            endCalendar.setTime(endDate);
            switch (returnPattern) {
                case YEAR_RETURN:
                    return DateUtil.getByField(beginCalendar, endCalendar, Calendar.YEAR);
                case MONTH_RETURN:
                    return DateUtil.getByField(beginCalendar, endCalendar, Calendar.YEAR) * 12 + DateUtil.getByField(beginCalendar, endCalendar, Calendar.MONTH);
                case DAY_RETURN:
                    return DateUtil.getTime(beginDate, endDate) / (24 * 60 * 60 * 1000);
                case HOUR_RETURN:
                    return DateUtil.getTime(beginDate, endDate) / (60 * 60 * 1000);
                case MINUTE_RETURN:
                    return DateUtil.getTime(beginDate, endDate) / (60 * 1000);
                case SECOND_RETURN:
                    return DateUtil.getTime(beginDate, endDate) / 1000;
                default:
                    return 0;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return  -1;
    }

    public static long getBetween(Date beginTime, Date endTime, String formatPattern, int returnPattern) {
        if(beginTime == null || endTime == null || formatPattern == null){
            return -1;
        }
        try{
            Calendar beginCalendar = Calendar.getInstance();
            Calendar endCalendar = Calendar.getInstance();
            beginCalendar.setTime(beginTime);
            endCalendar.setTime(endTime);
            switch (returnPattern) {
                case YEAR_RETURN:
                    return DateUtil.getByField(beginCalendar, endCalendar, Calendar.YEAR);
                case MONTH_RETURN:
                    return DateUtil.getByField(beginCalendar, endCalendar, Calendar.YEAR) * 12 + DateUtil.getByField(beginCalendar, endCalendar, Calendar.MONTH);
                case DAY_RETURN:
                    return DateUtil.getTime(beginTime, endTime) / (24 * 60 * 60 * 1000);
                case HOUR_RETURN:
                    return DateUtil.getTime(beginTime, endTime) / (60 * 60 * 1000);
                case MINUTE_RETURN:
                    return DateUtil.getTime(beginTime, endTime) / (60 * 1000);
                case SECOND_RETURN:
                    return DateUtil.getTime(beginTime, endTime) / 1000;
                default:
                    return 0;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return  -1;
    }

    private static long getByField(Calendar beginCalendar, Calendar endCalendar, int calendarField) {
        return endCalendar.get(calendarField) - beginCalendar.get(calendarField);
    }

    private static long getTime(Date beginDate, Date endDate) {
        return endDate.getTime() - beginDate.getTime();
    }

    public static String getGMTDate(Date date, String formate) {
        if(date == null || StringUtils.isBlank(formate)){
            return null;
        }
        String cstDate = null;
        try{
            SimpleDateFormat matter = new SimpleDateFormat(formate);
            matter.setTimeZone(TimeZone.getTimeZone("GMT+8"));
            cstDate = matter.format(date);
        }catch (Exception e){
            e.printStackTrace();
        }
        return cstDate;
    }

    public static Date convertStr2Date(String strDate, String formate){
        Date result = null;
        if(strDate != null && strDate.trim().length()>0 && formate != null && formate.length() >0){
            try{
                SimpleDateFormat sf = new SimpleDateFormat(formate);
                result = sf.parse(strDate);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return result;
    }

    public static String formateDate(Date date){
        if(date != null){
            SimpleDateFormat sf = new SimpleDateFormat(YYYYMMDDHHMMSS);
            return sf.format(date);
        }
        return "";
    }

    public static void main(String args[]){
        Date a = new Date();
        String str1 = DateUtil.getGMTDate(a, DateUtil.YYYYMMDDHHMMSS);
        System.out.println(str1);
        SimpleDateFormat sf = new SimpleDateFormat(DateUtil.YYYYMMDDHHMMSS);
        try {
            a = sf.parse(str1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String str2 = DateUtil.getGMTDate(a, DateUtil.YYYYMMDDHHMMSS);
        System.out.println(str2);
    }

}
