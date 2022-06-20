package com.killer.demo;

import com.killer.demo.enumCode.TaskType;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.Arrays;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {

    }

    /**
     * 枚举测试
     */
    @Test
    void test1() {
        //获取枚举中所有的值
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
        System.out.println(green1);
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
}
