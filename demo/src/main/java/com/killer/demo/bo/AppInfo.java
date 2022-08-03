package com.killer.demo.bo;

public class AppInfo {
    /**
     * 主键（OPER_TYPE=1时有值）
     */
    private String autoId;
    /**
     * 菜单名称
     */
    private String menuName;
    /**
     * 菜单编码
     */
    private String menuCode;
    /**
     * 父级id
     */
    private String parentId;
    /**
     * 根节点
     */
    private String rootId;
    /**
     * 权限编码
     */
    private String permission;
    /**
     * 排序
     */
    private String orderId;
    /**
     * 层级
     */
    private String deep;
    /**
     * 菜单图标
     */
    private String menuIcon;
    /**
     * 菜单路径
     */
    private String menuUrl;
    /**
     * 菜单样式
     */
    private String menuCss;
    /**
     * 域名
     */
    private String domainName;
    /**
     * 灰度域名
     */
    private String grayDomainName;
    /**
     * 系统路径
     */
    private String sysPath;
    /**
     * 菜单归属
     */
    private String menuAssignment;

    public String getAutoId() {
        return autoId;
    }

    public void setAutoId(String autoId) {
        this.autoId = autoId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getRootId() {
        return rootId;
    }

    public void setRootId(String rootId) {
        this.rootId = rootId;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getDeep() {
        return deep;
    }

    public void setDeep(String deep) {
        this.deep = deep;
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public String getMenuCss() {
        return menuCss;
    }

    public void setMenuCss(String menuCss) {
        this.menuCss = menuCss;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public String getGrayDomainName() {
        return grayDomainName;
    }

    public void setGrayDomainName(String grayDomainName) {
        this.grayDomainName = grayDomainName;
    }

    public String getSysPath() {
        return sysPath;
    }

    public void setSysPath(String sysPath) {
        this.sysPath = sysPath;
    }

    public String getMenuAssignment() {
        return menuAssignment;
    }

    public void setMenuAssignment(String menuAssignment) {
        this.menuAssignment = menuAssignment;
    }

    @Override
    public String toString() {
        return "AppInfo{" +
                "autoId='" + autoId + '\'' +
                ", menuName='" + menuName + '\'' +
                ", menuCode='" + menuCode + '\'' +
                ", parentId='" + parentId + '\'' +
                ", rootId='" + rootId + '\'' +
                ", permission='" + permission + '\'' +
                ", orderId='" + orderId + '\'' +
                ", deep='" + deep + '\'' +
                ", menuIcon='" + menuIcon + '\'' +
                ", menuUrl='" + menuUrl + '\'' +
                ", menuCss='" + menuCss + '\'' +
                ", domainName='" + domainName + '\'' +
                ", grayDomainName='" + grayDomainName + '\'' +
                ", sysPath='" + sysPath + '\'' +
                ", menuAssignment='" + menuAssignment + '\'' +
                '}';
    }
}
