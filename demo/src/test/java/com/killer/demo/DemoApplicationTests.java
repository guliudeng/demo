package com.killer.demo;

import com.alibaba.fastjson.JSONObject;

import com.killer.demo.enumCode.EnumDemo;
import com.killer.demo.enumCode.TaskType;
import io.lettuce.core.dynamic.annotation.Value;
import org.jasypt.util.text.BasicTextEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@SpringBootTest
class DemoApplicationTests {
 /*   @Autowired
    private AnimalsInfoConfig animalsInfoConfig;*/

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
  /*  @Test
    void test6() {
        String name = animalsInfoConfig.getAnimalsType().getAnimalsProperties().getName();
        int age = animalsInfoConfig.getAnimalsType().getAnimalsProperties().getAge();
        String sex = animalsInfoConfig.getAnimalsType().getAnimalsProperties().getSex();
        System.out.println(name+age+sex);
    }*/

    /**
     * int 和string 比较是否相等
     */
    @Test
    void test7() {
        int a = 0;
        String b = "1";
        boolean equals = b.equals(String.valueOf(a));
        System.out.println(equals);
    }

    /**
     * string转json
     */
    @Test
    void test8() {

        String b = "{}";

    }

}
