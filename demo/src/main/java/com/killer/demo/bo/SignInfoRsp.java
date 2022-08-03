package com.killer.demo.bo;

public class SignInfoRsp {
    private String signMsg;
    private String signType;

    public String getSignMsg() {
        return signMsg;
    }

    public void setSignMsg(String signMsg) {
        this.signMsg = signMsg;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    @Override
    public String toString() {
        return "SignInfoReq{" +
                "signMsg='" + signMsg + '\'' +
                ", signType='" + signType + '\'' +
                '}';
    }
}
