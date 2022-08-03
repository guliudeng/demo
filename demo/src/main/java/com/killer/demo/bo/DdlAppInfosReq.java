package com.killer.demo.bo;

public class DdlAppInfosReq {
    /**
     * 请求体
     */
    private AppInfosReq appInfosReq;
    /**
     * 签名信息
     */
    private SignInfoReq signInfoReq;

    public AppInfosReq getAppInfosReq() {
        return appInfosReq;
    }

    public void setAppInfosReq(AppInfosReq appInfosReq) {
        this.appInfosReq = appInfosReq;
    }

    public SignInfoReq getSignInfoReq() {
        return signInfoReq;
    }

    public void setSignInfoReq(SignInfoReq signInfoReq) {
        this.signInfoReq = signInfoReq;
    }

    @Override
    public String toString() {
        return "DdlAppInfosReq{" +
                "appInfosReq=" + appInfosReq +
                ", signInfoReq=" + signInfoReq +
                '}';
    }
}
