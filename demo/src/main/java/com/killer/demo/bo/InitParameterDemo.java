package com.killer.demo.bo;

import com.killer.demo.mapper.BsUserPOMapper;
import org.springframework.stereotype.Component;

/**
 * 单例bean成员熟悉在容器初始化时，完成参数的创建
 * 其中部分参数从数据库配置中读取而来
 * 通过构造器初始化对象推断规则
 * 1，没有任何构造器。默认给类创建无参构造器，并使用无参构造器创建对象
 * 2，只存在无参构造器，使用无参构造器创建对象
 * 3，只存在有参构造器，使用有参构造器创建对象，
 *      但是，有参构造器的参数必须是spring管理的bean，否则报错,
 *      如果有参构造参数不是spring管理的bean，需要配置指定该类使用有参构造器初始化
 * 4，一个类中存在多个构造器时，优先使用无参构造器创建对象，
 */
@Component
public class InitParameterDemo {
   private String name;
   private String nick;
   private Integer userId;

    private BsUserPOMapper bsUserPOMapper;
    //使用有参构造器，参数必须是spring所管理的bean
    public InitParameterDemo(BsUserPOMapper bsUserPOMapper) {

        this.userId = bsUserPOMapper.selectByUserName("李狗蛋1").getUserId();
        System.out.println("init parameter success ID="+userId);
    }

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
