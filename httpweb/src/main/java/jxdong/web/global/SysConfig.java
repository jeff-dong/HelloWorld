package jxdong.web.global;

import org.apache.commons.lang3.StringUtils;

import java.util.Properties;

/**
 * @author <a href="jxdong@Ctrip.com">jeff</a>
 * @version 2015/07/01 15:45
 */
public class SysConfig {
    public static final String CONFIG = "config.properties";
    private static Properties prop;

    static {
        prop = new Properties();
        try {
            prop.load(SysConfig.class.getClassLoader().getResourceAsStream(CONFIG));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getString(String key) {
        String result =prop.getProperty(key.toLowerCase(), "");
        if(StringUtils.isEmpty(result)){
            result =prop.getProperty(key, "");
        }
        return result;
    }

    public static Integer getInteger(String key) {
        String value = SysConfig.getString(key);
        Integer result = null;
        if (value != null && value.length() > 0) {
            result = Integer.parseInt(value);
        }
        return result;
    }

    public static Boolean getBoolean(String key) {
        String value = SysConfig.getString(key);
        Boolean result = false;
        if (value != null && value.length() > 0) {
            if(value.trim().equals("true")){
                result = true;
            }
        }
        return result;
    }

}
