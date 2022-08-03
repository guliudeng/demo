package com.killer.demo.bo;

public class AppInfosReq {
    /**
     * 接入系统（由权限中心定义）
     */
    private String sysCode;
    /**
     * 操作类型：0 新增单个菜单
     * 1 更新单个菜单  2 删除单个菜单
     */
    private String operType;
    /**
     * 员工工号，不带省份下划线
     */
    private String staffNo;
    /**
     * 菜单详细信息 OPER_TYPE=0，1此节点存在
     */
    private AppInfo appInfo;
    /**
     * 删除菜单 OPER_TYPE=2时此节点存在
     */
    private AppDelete appDelete;

    public String getSysCode() {
        return sysCode;
    }

    public void setSysCode(String sysCode) {
        this.sysCode = sysCode;
    }

    public String getOperType() {
        return operType;
    }

    public void setOperType(String operType) {
        this.operType = operType;
    }

    public String getStaffNo() {
        return staffNo;
    }

    public void setStaffNo(String staffNo) {
        this.staffNo = staffNo;
    }

    public AppInfo getAppInfo() {
        return appInfo;
    }

    public void setAppInfo(AppInfo appInfo) {
        this.appInfo = appInfo;
    }

    public AppDelete getAppDelete() {
        return appDelete;
    }

    public void setAppDelete(AppDelete appDelete) {
        this.appDelete = appDelete;
    }

    @Override
    public String toString() {
        return "AppInfosReq{" +
                "sysCode='" + sysCode + '\'' +
                ", operType='" + operType + '\'' +
                ", staffNo='" + staffNo + '\'' +
                ", appInfo=" + appInfo +
                ", appDelete=" + appDelete +
                '}';
    }
}
