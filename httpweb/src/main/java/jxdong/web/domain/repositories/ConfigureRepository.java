package jxdong.web.domain.repositories;


import jxdong.web.domain.model.Configure;

/**
 * @author <a href="jxdong@Ctrip.com">jeff</a>
 * @version 2015/8/17 20:04
 */
public interface ConfigureRepository extends Repository{

    Configure queryByPrimaryKey(long primaryKey);

}
