package com.killer.demo;

import com.killer.demo.bo.TestMax;
import com.killer.demo.enumCode.EnumDemo;
import com.killer.demo.enumCode.RspEnum;
import com.killer.demo.enumCode.TaskType;
import com.killer.demo.service.UserService;
import com.killer.demo.utils.DateTimeUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.*;
import java.util.concurrent.*;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {

    }

    /**
     * 枚举测试
     */
    @Test
    void test1() {
//        String pp = "P";
//        System.out.println(TaskType.P);
//        boolean b = TaskType.P.equals(TaskType.P);
//        System.out.println(b);
        /*Date ten = DateTimeUtils.getTen();
        System.out.println(ten);*/
       /* Integer xing = EnumDemo.getIndex("星期一");
        String name = EnumDemo.getName(1);
        EnumDemo monday = EnumDemo.MONDAY;
        String name1 = monday.getName();
        System.out.println(name1);
        System.out.println(name);
        System.out.println(xing);*/
       /* String a = "5";
        List<String> list = Arrays.asList("0", "1", "2");
        boolean contains = list.contains("0");
        System.out.println(contains);*/
        int code = RspEnum.FAILED.getCode();
        String desc = RspEnum.FAILED.getDesc();
        System.out.println(desc);
        System.out.println(code);
        String name = RspEnum.getName(1000);
        System.out.println(name);
        Integer co = RspEnum.getCode("响应成功");

        System.out.println(co);
    }

    /**
     * Java 断言
     */
    @Test
    void test2() {
       /* String name = "";
        Integer age = 19;
        Assert.notNull(name,"用户名不能为空");
        Assert.isTrue(18>age,"年龄不可以大于18");*/
        String aa = "刘";
        String format = String.format("谷%s邓", aa);
        System.out.println(format);
        String bb = aa.concat("bb");
        System.out.println(bb);
        Date date = DateTimeUtils.stringChangeDateType("2022-06-03 00:25:00");
        Date beforeStartTime = DateTimeUtils.getBeforeStartTime(date,10);
        Date beforeEndTime = DateTimeUtils.getBeforeEndTime(date,10);
        System.out.println(beforeStartTime);
        System.out.println(beforeEndTime);
        Double aaa = 0.55;
        String s = aaa.toString();
        System.out.println(s);
    }

    /**
     * 创建线程的三种方式
     */
    @Test
    void test3() {
        //继承thread类
        /*class th extends Thread{
            @Override
            public void run() {
                System.out.println("创建线程方法一：继承thread类");

            }
        }
        th th = new th();
        th.start();*/
        //实现runnable接口
        /*class th1 implements Runnable{

            @Override
            public void run() {
                System.out.println("创建线程方法二：实现runnable接口");
            }
        }

        th1 th1 = new th1();
        Thread thread = new Thread(th1);
        thread.start();*/
        //实现Callable接口
      /*  class th2 implements Callable{

            @Override
            public Object call() throws Exception {
                System.out.println("创建线程方法二：实现Callable接口");
                return "成功";
            }
        }
        th2 th2 = new th2();
        FutureTask futureTask = new FutureTask<>(th2);
        Thread thread = new Thread(futureTask);
        thread.start();*/
        class A implements Runnable{

            @Override
            public void run() {
                for (int i = 1; i <=100; i++) {
                    if (i%2==0){
                        System.out.println(Thread.currentThread().getName()+":"+i);
                    }
                }

            }
        }
        class B implements Callable{

            @Override
            public Object call() throws Exception {
                for (int i = 1; i <=100; i++) {
                    if (i%2!=0){
                        System.out.println(Thread.currentThread().getName()+":"+i);
                    }
                }
                return null;
            }
        }
        ExecutorService service = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor poolExecutor = (ThreadPoolExecutor) service;
        poolExecutor.setCorePoolSize(8);
        service.execute(new A());//适用于实现runnable
        service.submit(new B());//适用于实现callable接口
        service.shutdown();
    }

    /**
     * 获取集合中对象某个属性最大值
     */
    @Test
    void test4() {
        List<Long> longList = new ArrayList<>();
        longList.add(111L);
        List<TestMax> list = new ArrayList<>();
        list.add(new TestMax("gg",111L));
        list.add(new TestMax("ll",222L));
        list.add(new TestMax("dd",333L));
        TestMax testMax = list.stream().max(Comparator.comparing(TestMax::getAge)).get();
        System.out.println(testMax);
        Long age = list.stream().max(Comparator.comparing(TestMax::getAge)).get().getAge();
        System.out.println(age);
        /*list.clear();
        System.out.println("list"+list.size());*/
        list.removeAll(longList);
        System.out.println(list);

    }

    /**
     * 切面测试
     */
    @Test
    void test5(){
        userService.delectUser(1);
    }

    /**
     * 九九乘法表
     * 两个循环体，
     */
    @Test
    void test6(){
        for (int i =1;i<10;i++) {
            for (int j=1;j<=i;j++){
                System.out.print(i+"*"+j+"="+i*j+" ");

            }
            System.out.println();
        }
    }
}
