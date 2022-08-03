package com.killer.demo.bo;

public class MenuInfo {
    /**
     * 菜单编码
     */
    private String menuCode;
    /**
     * 菜单ID
     */
    private String menuId;

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    @Override
    public String toString() {
        return "MenuInfo{" +
                "menuCode='" + menuCode + '\'' +
                ", menuId='" + menuId + '\'' +
                '}';
    }
}
