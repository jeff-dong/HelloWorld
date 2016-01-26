package jxdong.web.domain.repositories;


import jxdong.web.domain.model.Entity;

/**
 * @author <a href="jxdong@Ctrip.com">jeff</a>
 * @version 2015/8/17 20:04
 */
public interface Repository {

    Entity queryByPrimaryKey(long primaryKey);
}
