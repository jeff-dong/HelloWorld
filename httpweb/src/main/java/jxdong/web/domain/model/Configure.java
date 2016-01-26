package jxdong.web.domain.model;

/**
 * @author <a href="jxdong@Ctrip.com">jeff</a>
 * @version 2015/6/17 13:40
 */
public class Configure extends Entity{

    private int id;
    private String group;
    private String key;
    private String value;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    /**
     * TODO 去掉
     * @return boolean
     */
    public static boolean validateUpdateParam(Configure configure) {
        return true;
        /*
        boolean isValid = false;

        if (configure != null) {
            if (configure.getGroup().equals(ConfigureEnum.Group.ORDER_MODE_SWITCH.getCode())) {
                //��ֵ - int
                String key = configure.getKey();
                String value = configure.getValue();
                if (ConfigureEnum.ORDER_MODE_SWITCH_THRESHOLD.getCode().equals(key)) {
                    try {
                        int threshold = Integer.valueOf(value);
                        if (threshold >= 0) {
                            isValid = true;
                        }
                    } catch (Exception e) {

                    }
                } else if (ConfigureEnum.ORDER_MODE_SWITCH_START_TIME.getCode().equals(key)) {
                    if (DateUtil.convertStr2Date(value, DateUtil.YYYYMMDDHHMMSS) != null) {
                        isValid = true;
                    }
                }
            }
        }
        return isValid;
        */
    }
}
