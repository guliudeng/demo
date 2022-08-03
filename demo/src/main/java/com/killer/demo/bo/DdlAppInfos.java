package com.killer.demo.bo;

public class DdlAppInfos {
    /**
     * 应答/错误类型
     */
    private String respCode;
    /**
     * 应答/错误代码
     */
    private String respDesc;
    /**
     * 操作类型：0 新增单个菜单
     * 1 更新单个菜单  2 删除单个菜单
     */
    private String operType;
    /**
     * 菜单信息
     * OPER_TYPE=0时有值
     */
    private MenuInfo menuInfo;
    /**
     * 扩展业务参数实体
     */
    private String rspBusinessParams;

    public String getRespCode() {
        return respCode;
    }

    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }

    public String getRespDesc() {
        return respDesc;
    }

    public void setRespDesc(String respDesc) {
        this.respDesc = respDesc;
    }

    public String getOperType() {
        return operType;
    }

    public void setOperType(String operType) {
        this.operType = operType;
    }

    public MenuInfo getMenuInfo() {
        return menuInfo;
    }

    public void setMenuInfo(MenuInfo menuInfo) {
        this.menuInfo = menuInfo;
    }

    public String getRspBusinessParams() {
        return rspBusinessParams;
    }

    public void setRspBusinessParams(String rspBusinessParams) {
        this.rspBusinessParams = rspBusinessParams;
    }

    @Override
    public String toString() {
        return "DdlAppInfos{" +
                "respCode='" + respCode + '\'' +
                ", respDesc='" + respDesc + '\'' +
                ", operType='" + operType + '\'' +
                ", menuInfo=" + menuInfo +
                ", rspBusinessParams='" + rspBusinessParams + '\'' +
                '}';
    }
}
