package com.killer.demo.bo;

import lombok.Data;
import org.springframework.util.StringUtils;

@Data
public class TestDuiXiangCpmparer {
    private String appUrl;
    private String appPath;
    private String domainName;
    private String contextPath;
    private String greyDomainName;
    private String greyAppPath;
    private String appGreyUrl;

    public TestDuiXiangCpmparer compareSet(AppInfo inAppInfo){
        this.appPath = this.appPath == null ? null : StringUtils.isEmpty(inAppInfo.getMenuUrl()) ||
                this.appPath.equals(inAppInfo.getMenuUrl())
                ? this.appPath : inAppInfo.getMenuUrl();
        this.contextPath = this.contextPath == null ? null : StringUtils.isEmpty(inAppInfo.getSysPath()) ||
                this.contextPath.equals(inAppInfo.getSysPath())
                ? this.contextPath : inAppInfo.getSysPath();
        this.domainName = this.domainName == null ? null :StringUtils.isEmpty(inAppInfo.getDomainName()) ||
                this.domainName.equals(inAppInfo.getDomainName())
                ? this.domainName : inAppInfo.getDomainName();
        this.greyDomainName = this.greyDomainName == null ? null :StringUtils.isEmpty(inAppInfo.getGrayDomainName()) ||
                this.greyDomainName.equals(inAppInfo.getGrayDomainName())
                ? this.greyDomainName : inAppInfo.getGrayDomainName();
        this.greyAppPath = this.greyAppPath == null ? null :StringUtils.isEmpty(inAppInfo.getMenuUrl()) ||
                this.greyAppPath.equals(inAppInfo.getMenuUrl())
                ? this.greyAppPath : inAppInfo.getMenuUrl();
        return this;
    }

    public void buildUrl(){
        if (this.getDomainName() == null || this.getContextPath() ==null || this.getAppPath() == null) {
            this.setAppUrl(null);
        }else {
            this.setAppUrl(this.getDomainName()+this.getContextPath()+this.getAppPath());
        }
       if (this.getGreyDomainName() == null || this.getContextPath() == null || this.getGreyAppPath() ==null) {
           this.setAppGreyUrl(null);
       }else {
           this.setAppGreyUrl(this.getGreyDomainName()+this.getContextPath()+this.getGreyAppPath());
       }

    }

}
