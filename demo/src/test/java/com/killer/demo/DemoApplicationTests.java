package com.killer.demo;

import com.alibaba.fastjson.JSONObject;

import com.killer.demo.bo.DdlAppInfos;
import com.killer.demo.bo.DdlAppInfosRsp;
import com.killer.demo.config.AnimalsInfoConfig;
import com.killer.demo.enumCode.EnumDemo;
import com.killer.demo.enumCode.TaskType;
import io.lettuce.core.dynamic.annotation.Value;
import org.jasypt.util.text.BasicTextEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    private AnimalsInfoConfig animalsInfoConfig;

    @Test
    void contextLoads() {

    }

    /**
     * 枚举测试
     */
    @Test
    void test1() {
       /* //获取枚举中所有的值
        TaskType[] values = TaskType.values();
        System.out.println(Arrays.asList(values));
        //可以直接获取枚举本身
        TaskType green = TaskType.GREEN;
        System.out.println(green);
        //也可以给枚举设置参数，然后提供公共构造方法来获取枚举对象身上的参数，
        String red = TaskType.getName("red");
        System.out.println(red);
        boolean red1 = "红色".equals(red);
        System.out.println(red1);

        String gg = TaskType.getValud("绿色");
        System.out.println(gg);
        boolean green1 = gg.equals("green");
        System.out.println(green1);*/
        //获取枚举对象
        EnumDemo monday = EnumDemo.MONDAY;
        System.out.println(monday);
        //获取星期一的中文名称
        String name = EnumDemo.MONDAY.getName();
        System.out.println(name);
        //获取星期一的下标
        Integer index = EnumDemo.MONDAY.getIndex();
        System.out.println(index);
        //根据中文名称获取对应下标
        String name1 = EnumDemo.getName(2);
        System.out.println(name1);
        //根据下标获取对应中文名称
        Integer tu = EnumDemo.getIndex("星期二");
        System.out.println(tu);
    }

    /**
     * Java 断言
     */
    @Test
    void test2() {
        String name = "";
        Integer age = 19;
        Assert.notNull(name,"用户名不能为空");
        Assert.isTrue(18>age,"年龄不可以大于18");
    }

    /**
     *java 8 optional使用
     */
    @Test
    void test3() {
        String name = "";
        //empty方法创建一个空的对象
        Optional<Object> empty = Optional.empty();
        //of创建一个对象，value不能为空,为空会报错
        Optional<Object> o = Optional.of(name);
        //ofNullable,创建一个对象，value可以为空，为空时调用empty方法创建一个空对象，value不为空时，调用of方法创建对象
        Optional<Object> o1 = Optional.ofNullable(null);
        //
    }

    /**
     * decrypt加密
     */
    @Test
    void test4() {
        String name = "guliudeng";
        String password = "123456";
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        textEncryptor.setPassword("123456");
        String s = textEncryptor.encrypt(name);
        String p = textEncryptor.encrypt(password);
        System.out.println("加密后--name="+s);
        System.out.println("加密后--password="+p);
        String decrypt = textEncryptor.decrypt(s);
        String decrypt1 = textEncryptor.decrypt(p);
        System.out.println(decrypt);
        System.out.println(decrypt1);
    }
    @Test
    void test5() {
        String str = "{aa:bb}";
        JSONObject mes = JSONObject.parseObject(str);

        Set<Map.Entry<String, Object>> entries = mes.entrySet();
        String collect = entries.stream().map(e -> " ` " + e.getKey() + " ` ")
                .collect(Collectors.joining(","));
        System.out.println(collect);

    }

    /**
     * 读取配置文件中配置，嵌套组装
     */
    @Test
    void test6() {
        //获取动物
        String name = animalsInfoConfig.getAnimalsType().getAnimalsProperties().getName();
        int age = animalsInfoConfig.getAnimalsType().getAnimalsProperties().getAge();
        String sex = animalsInfoConfig.getAnimalsType().getAnimalsProperties().getSex();
        //获取人
        String name1 = animalsInfoConfig.getAnimalsType().getPeopleProperties().getName();
        String sex1 = animalsInfoConfig.getAnimalsType().getPeopleProperties().getSex();
        Integer age1 = animalsInfoConfig.getAnimalsType().getPeopleProperties().getAge();
        System.out.println(name+age+sex);
        System.out.println(name1+age1+sex1);

    }

    /**
     * int 和string 比较是否相等
     */
    @Test
    void test7() {
       /* int a = 0;
        String b = "1";
        boolean equals = b.equals(String.valueOf(a));
        System.out.println(equals);*/
        /**
         * 创建对象，其他对象创建空指针
         */
       /* DdlAppInfosRsp rsp = new DdlAppInfosRsp();
        DdlAppInfos ddlAppInfos = rsp.getDdlAppInfos();
        System.out.println(ddlAppInfos);//null
        rsp.setDdlAppInfos(new DdlAppInfos());
        rsp.getDdlAppInfos().setOperType("2");
        System.out.println(rsp);*/
      String str = "84238742401849813711111";
      String str2 = "84238742401849813711";
      //  Long aLong = Long.valueOf(str2);
        Double aDouble = Double.valueOf(str);
        BigDecimal bigDecimal = BigDecimal.valueOf(aDouble);
        System.out.println(bigDecimal);
        //System.out.println(aLong);

    }

    /**
     * string包含
     */
    @Test
    void test8() {
        List<String> list = new ArrayList<>();
        String[] ss = {"0","1","2","3"};
        List<String> asList = Arrays.asList(ss);
       /* list.add("0");
        list.add("1");
        list.add("2");
        list.add("3");
        boolean contains = list.contains("4");*/
        boolean contains = asList.contains(null);
        System.out.println(contains);

    }
    /**
     * 注解
     *  @Component:将Java类被spring容器管理，你可以在注解后面指定bean的名称，如果不指定spring会根据类名的第二个字母是否大写来设置和获取bean的名称，如果第二个字母是大写，首字母保持不变作为bean名称，如果第二个字母是小写，首字母转小写作为bean名称
     *     @Bean:作用于方法之上，将该方法作为一个bean交由spring管理，在需要用的地方使用@Autowired注入该方法即可使用
     *     @Value:原理是spring的DI注入，对于基本数据类型和Spring类型的数据，使用  @Value("${paramKey}")形式来从配置文件中读取值，针对于集合类型数据，如list，set，map类型，使用  @Value("#{@paramKey}")来获取值，对于引用类型使用@Autowired来注入
     *     @Autowired: 自动装配，首先会根据类型进行匹配，找到唯一进行注入，找不到抛出异常，找到多个根据注入类的id进行匹配，找到唯一id进行注入，找不到抛异常，不可能找到多个，思考题：如果注入的是有很多子类的父类，spring是如何寻找bean的？
     *     @Qualifier:该注解必须于@Autowired注解一起使用，当两者一起使用时，@Autowired将不再根据类型进行匹配，而是根据id进行匹配
     *     @Scope:在类上使用该注解，表示该类是多例，每次创建对象都是获取新的实例
     *     @Lazy:在类上使用该注解表示该类在spring容器初始化的时候不加载，而是带第一次使用时加载，减少容器初始化时间
     *     @PostConstruct:该注解常常用在类的方法上，表示该类创建的时候每次都成初始化执行该方法的内容，常用于对象的初始化
     *     @PreDestroy:该注解常常用在类的方法上，表示该对象销毁的时候每次都执行该方法的内容，常用于对象的销毁
     *     @Controller:用于web层
     *     @Service:用户service层
     *     @Repository:用于dao层
     *     @Component:其他地方使用，上述四个注解都是为了将类被spring识别，交由spring管理，只不过作用的位置不同
     */


}
