package com.killer.demo;

import com.killer.demo.enumCode.TaskType;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

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
        String pp = "P";
        System.out.println(TaskType.P);
        boolean b = TaskType.P.equals(TaskType.P);
        System.out.println(b);

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
