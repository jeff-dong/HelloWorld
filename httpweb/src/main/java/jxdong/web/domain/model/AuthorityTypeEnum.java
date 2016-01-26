package jxdong.web.domain.model;

/**
 * 权限分类enum, 不规定权限的层级关系
 * @author <a href="jxdong@Ctrip.com">jeff</a>
 * @version 2015/7/2 14:49
 */
public enum AuthorityTypeEnum {
    VIEW("VIEW", "查看"),
    UPDATE("UPDATE", "更新"),
    INSERT("INSERT", "插入"),
    DELETE("DELETE", "删除");

    private String code;
    private String desc;

    AuthorityTypeEnum(String code, String desc){
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static boolean containItem(String typeCode){
        for(AuthorityTypeEnum authorityTypeEnum : AuthorityTypeEnum.values()){
            if(authorityTypeEnum.getCode().equalsIgnoreCase(typeCode)){
                return true;
            }
        }
        return false;
    }

    /**
     * 有不包含的就认为不包含
     * @param itemCodeArray array
     * @return boolean
     */
    public static boolean containItemArray(String[] itemCodeArray){
        for(String itemCode : itemCodeArray){
            if(!containItem(itemCode)){
                return false;
            }
        }
        return true;
    }
}
