package com.killer.demo.bo;

public class DdlAppInfosRsp {
    private DdlAppInfos ddlAppInfos;
    private SignInfoRsp signInfoRsp;

    public DdlAppInfos getDdlAppInfos() {
        return ddlAppInfos;
    }

    public void setDdlAppInfos(DdlAppInfos ddlAppInfos) {
        this.ddlAppInfos = ddlAppInfos;
    }

    public SignInfoRsp getSignInfoRsp() {
        return signInfoRsp;
    }

    public void setSignInfoRsp(SignInfoRsp signInfoRsp) {
        this.signInfoRsp = signInfoRsp;
    }

    @Override
    public String toString() {
        return "DdlAppInfosRsp{" +
                "ddlAppInfos=" + ddlAppInfos +
                ", signInfoRsp=" + signInfoRsp +
                '}';
    }
}
