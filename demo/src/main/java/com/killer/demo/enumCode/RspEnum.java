package com.killer.demo.enumCode;

public enum RspEnum {
    SUCCESS("响应成功",1000),
    FAILED("响应失败",8888);
    private String desc;
    private int code;

    RspEnum(String desc, int code) {
        this.desc = desc;
        this.code = code;
    }
    //根据响应码获取响应描述
    public static String getName(int code) {
        for (RspEnum value : RspEnum.values()) {
            if (value.getCode()  == code) {
                return value.getDesc();
            }
        }
        return null;
    }
    //根据响应描述来返回响应码
    public static Integer getCode(String desc) {
        for (RspEnum value : RspEnum.values()) {
            if (value.getDesc().equals(desc)) {
                return value.getCode();
            }
        }
        return null;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
