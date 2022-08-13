package com.killer.demo.bo;

import org.springframework.stereotype.Component;

/**
 * 单例bean成员熟悉在容器初始化时，完成参数的创建
 * 其中部分参数从数据库配置中读取而来
 */
@Component
public class InitParameterDemo {
   private String name;
   private String nick;
   private Integer userId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "InitParameterDemo{" +
                "name='" + name + '\'' +
                ", nick='" + nick + '\'' +
                ", userId=" + userId +
                '}';
    }
}
