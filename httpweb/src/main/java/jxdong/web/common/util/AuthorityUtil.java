package jxdong.web.common.util;

import jxdong.web.domain.model.AuthorityTypeEnum;
import jxdong.web.domain.model.LoginAccount;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author <a href="jxdong@Ctrip.com">jeff</a>
 * @version 2015/7/2 14:49
 */
public class AuthorityUtil {
    private static Logger logger = LoggerFactory.getLogger(AuthorityUtil.class);

    public static LoginAccount getLoginedAccount(){
        LoginAccount account = new LoginAccount();
        account.setName("Test");
        return account;
    }

    /**
     * 校验userName是否有authorityCode权限
     * @param authorityCode 权限类型
     * @return boolean 默认false
     */
    public static boolean validateAuthority(String authorityCode){
        LoginAccount account = getLoginedAccount();
        if(account == null || StringUtils.isBlank(account.getEmployee()) || !AuthorityTypeEnum.containItem(authorityCode)){
            logger.warn("Validate failed. The param is invalid. employee:{}, AuthorityCode:{}", account, authorityCode);
            return false;
        }
        String employeeID = account.getEmployee();
        Map<String, List<String>> configMap = getAuthorityMap();
        if(configMap != null){
            List<String> authorityList = configMap.get(employeeID);
            if(authorityList != null && authorityList.contains(authorityCode)){
                return true;
            }
        }
        logger.warn("There is no [{}] permission for the account[{}]", authorityCode, account);
        return false;
    }

    /**
     * 获取配置文件中的所有权限配置，并转化为map
     * @return map
     */
    private static Map<String, List<String>> getAuthorityMap(){
        Map<String, List<String>> authorityMap = null;
        String authorityConfigStr = PropertyUtil.getItem("AuthorityConfig");
        if(StringUtils.isNotBlank(authorityConfigStr)){
            String[] configArray = authorityConfigStr.split(",");
            if(configArray.length >0){
                authorityMap = new HashMap<>();
                for(String configStr : configArray){
                    if(StringUtils.isNotBlank(configStr) && configStr.contains(":")){
                        String[] configItemArray  = configStr.split(":");
                        if(configItemArray.length == 2){
                            String employeeID = configItemArray[0];
                            String authorityConfStr = configItemArray[1];
                            if(StringUtils.isNotBlank(authorityConfStr)){
                                String[] authorityArray = authorityConfStr.split("\\|");
                                if(AuthorityTypeEnum.containItemArray(authorityArray)){
                                    authorityMap.put(employeeID.toLowerCase(),Arrays.asList(authorityArray));
                                }else {
                                    logger.warn("Illegal authority configure! ", authorityArray);
                                }
                            }
                        }
                    }
                }
            }
        }
        return authorityMap;
    }

//    /**
//     * 得到当前登录用户的权限列表
//     * @return list
//     */
//    public static List<String> getAuthorities(){
//        LoginAccount account = getLoginedAccount();
//        if(account != null && account.getEmployee() != null){
//            Map<String, List<String>> authorityMap = getAuthorityMap();
//            if(authorityMap != null){
//                return authorityMap.get(account.getEmployee());
//            }
//        }
//        return null;
//    }

    //TODO remove
    public static void main(String args[]){
    }
}
