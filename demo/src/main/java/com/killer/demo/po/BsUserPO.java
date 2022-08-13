package com.killer.demo.po;

import lombok.Data;

@Data
public class BsUserPO {
    /**
    * 主键id
    */
    private Integer userId;

    /**
    * 用户名称
    */
    private String userName;

    /**
    * 密码
    */
    private String password;

    /**
    * 电话
    */
    private String phone;

    /**
    * 性别
    */
    private String sex;

    /**
    * 地址
    */
    private String address;

    /**
    * 店铺编码，只有商家才有值
    */
    private String shopCode;

    /**
    * 创建时间
    */
    private String createTime;

    /**
    * 删除标识
    */
    private String deleteFlag;

    /**
    * 角色
    */
    private String role;
}