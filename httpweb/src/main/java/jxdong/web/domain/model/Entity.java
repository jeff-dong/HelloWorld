package jxdong.web.domain.model;

import java.util.Date;

/**
 * @author <a href="jxdong@Ctrip.com">jeff</a>
 * @version 2015/6/25 14:03
 */
public class Entity {

    private Date createTime;
    private Date updateTime;
    private Date version;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getVersion() {
        return version;
    }

    public void setVersion(Date version) {
        this.version = version;
    }
}
