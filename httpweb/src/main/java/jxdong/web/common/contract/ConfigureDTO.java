package jxdong.web.common.contract;

/**
 * @author <a href="jxdong@Ctrip.com">jeff</a>
 * @version 2015/6/26 9:12
 */
public class ConfigureDTO extends BasicDTO{

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
}
