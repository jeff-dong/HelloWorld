package jxdong.web.controller;

import jxdong.web.common.contract.Response;
import jxdong.web.common.util.AuthorityUtil;
import jxdong.web.domain.model.AuthorityTypeEnum;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="jxdong@Ctrip.com">jeff</a>
 * @version 2015/6/25 14:26
 */
public abstract class BasicController {

    protected boolean validateAuthority(AuthorityTypeEnum authorityTypeEnum){
        return authorityTypeEnum != null && AuthorityUtil.validateAuthority(authorityTypeEnum.getCode());
    }

    protected ModelAndView errorModelAndView(Response.ResultCodeEnum errorEnum){
        String resultPage = "error";
        Map<String, String> errorMap = new HashMap<>();
        if(errorEnum != null){
            errorMap.put("errorCode", errorEnum.getCode());
            errorMap.put("errorMsg", errorEnum.getDesc());
        }
        return new ModelAndView(resultPage, errorMap);
    }

    protected ModelAndView modelAndView(String page){
        if(StringUtils.isNotBlank(page)){
            return new ModelAndView(page, "CtripAccount", AuthorityUtil.getLoginedAccount());
        }
        return errorModelAndView(Response.ResultCodeEnum.UNKNOWN_ERROR);
    }

}
