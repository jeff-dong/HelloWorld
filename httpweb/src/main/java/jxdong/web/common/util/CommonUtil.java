package jxdong.web.common.util;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author <a href="jxdong@Ctrip.com">jeff</a>
 * @version 2015/6/11 14:52
 */
public class CommonUtil {

    /**
     * 判断list是否为空
     * @param list list
     * @return boolean
     */
    public static boolean listIsNotBlank(List list){
        if(list != null && list.size() >0){
            return true;
        }
        return false;
    }

    public static boolean dateEqual(Date date1, Date date2){
        boolean isEqual = false;
        if(date1 == null && date2 == null){
            return true;
        }
        if(date1 == null || date2 == null){
            return false;
        }else{
            return (date1.compareTo(date2) == 0);
        }
    }

    public static String object2Str(Object obj){
        if(obj == null){
            return null;
        }else{
            return String.valueOf(obj);
        }
    }
    /**
     * 得到混淆的安全字符串，比如要混淆2/3位的字符，传参2,3
     * 举例：
     *  传参： origStr = "12345"; numerator = 1; denominator =3; (混淆12345的三分之一个字符)
     *  预期结果：1*****5
     * @param numerator   分子
     * @param denominator 分母
     * @return
     */
    public static String confuseString(String origStr, int numerator, int denominator) {
        StringBuffer safeStr = new StringBuffer("*****");
        if (StringUtils.isNotBlank(origStr) && denominator > numerator && numerator>0) {
            //转化为BigDicemal便于精确计算
            int strLength = origStr.length();
            if (true) {//strLength > denominator
                int startLength = (int) Math.floor(new BigDecimal(String.valueOf(strLength * (denominator - numerator))).divide(new BigDecimal(String.valueOf(denominator * 2)), 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                int endLength = (int) Math.ceil(
                        new BigDecimal(String.valueOf(strLength * numerator)).divide(new BigDecimal(String.valueOf(denominator)),2,BigDecimal.ROUND_HALF_UP).doubleValue()
                );
                safeStr.insert(0, origStr.substring(0, startLength));
                safeStr.append(origStr.substring((startLength + endLength), strLength));
            }
        }
        return safeStr.toString();
    }
}
