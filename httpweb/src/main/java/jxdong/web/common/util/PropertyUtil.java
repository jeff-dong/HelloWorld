package jxdong.web.common.util;

import org.apache.commons.lang3.StringUtils;
import java.util.Properties;

/**
 * @author <a href="jxdong@Ctrip.com">jeff</a>
 * @version 2015/07/01 15:45
 */
public class PropertyUtil {
    public static final String CONFIG = "config.properties";
    private static Properties prop;

    static {
        prop = new Properties();
        try {
            prop.load(PropertyUtil.class.getClassLoader().getResourceAsStream(CONFIG));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getItem(String key) {
        String result =prop.getProperty(key.toLowerCase(), "");
        if(StringUtils.isEmpty(result)){
            result =prop.getProperty(key, "");
        }
        return result;
    }

    public static String getKeyToken() {
        return getItem("KeyToken");
    }
    
    public static Integer getInteger(String key) {
        String value = PropertyUtil.getItem(key);
        Integer result = null;
        if (value != null && value.length() > 0) {
            result = Integer.parseInt(value);
        }
        return result;
    }

    public static Boolean getBoolean(String key) {
        String value = PropertyUtil.getItem(key);
        Boolean result = false;
        if (value != null && value.length() > 0) {
            if(value.trim().equals("true")){
                result = true;
            }
        }
        return result;
    }

}
