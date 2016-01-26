package jxdong.web.domain.model;

import java.util.List;
import java.util.Map;

/**
 * @author <a href="jxdong@Ctrip.com">jeff</a>
 * @version 2015/7/2 14:55
 */
public class LoginAccount extends Entity{

    private String mail;
    private String department;
    private String company;
    private String name;
    private String displayName;
    private List<Map<String, String>> memberOf;
    private String employee;
    private String distinguishedName;
    private String city;
    //权限
    private List<String> authorities;

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }


    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public List<Map<String, String>> getMemberOf() {
        return memberOf;
    }

    public void setMemberOf(List<Map<String, String>> memberOf) {
        this.memberOf = memberOf;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public String getDistinguishedName() {
        return distinguishedName;
    }

    public void setDistinguishedName(String distinguishedName) {
        this.distinguishedName = distinguishedName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<String> authorities) {
        this.authorities = authorities;
    }

    @Override
    public String toString() {
        return String.format("name: %s, company:%s, department: %s, employee: %s, authorities:%s",
                this.getName(),
                this.getCompany(),
                this.getDepartment(),
                this.getEmployee(),
                this.getAuthorities());
    }
}
