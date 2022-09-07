package com.killer.demo.controller;


import com.alibaba.fastjson.JSONObject;
import com.killer.demo.bo.*;
import com.killer.demo.config.AnimalsInfoConfig;
import com.killer.demo.service.RedisService;
import com.killer.demo.utils.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("comm")
public class commonController {
    @Autowired
    private RedisService redisService;
    @Autowired
    private AnimalsInfoConfig animalsInfoConfig;

    @RequestMapping("hello")
    public String hello() {
        System.out.println("hello"+Thread.currentThread().getName());
        return "hello:"+Thread.currentThread().getName();
    }

    /**
     * redis分布式锁
     * @return
     */
    @RequestMapping("lockDemo")
    public String lockDemo(String phone) {
       return redisService.lockDemo(phone);
    }

    /**
     * 测试读取配置属性
     */
    @RequestMapping("testP")
    public void test() {
        //获取动物
        String name = animalsInfoConfig.getAnimalsType().getAnimalsProperties().getName();
        String sex = animalsInfoConfig.getAnimalsType().getAnimalsProperties().getSex();
        Integer age = animalsInfoConfig.getAnimalsType().getAnimalsProperties().getAge();
        System.out.println(name+"--"+sex+"--"+age);
        //获取人
        String name1 = animalsInfoConfig.getAnimalsType().getPeopleProperties().getName();
        String sex1 = animalsInfoConfig.getAnimalsType().getPeopleProperties().getSex();
        Integer age1 = animalsInfoConfig.getAnimalsType().getPeopleProperties().getAge();
        System.out.println(name1+"--"+sex1+"--"+age1);
    }
    /**
     * redis string转json
     * @return
     */
    @RequestMapping("change")
    public String change(@RequestBody String str) {
        System.out.println("入参="+str);
        DdlAppInfosReq ddlAppInfosReq= JSONObject.parseObject(str,DdlAppInfosReq.class);
        System.out.println("转换后参数对象="+ddlAppInfosReq);
        return JSONObject.toJSONString(ddlAppInfosReq);
    }
    /**
     * redis 发送一个HTTP post请求调用服务
     * @return
     */
    @RequestMapping("sendHttp")
    public String sendHttp(@RequestBody String str) {
        String url = "http://10.125.143.218:8081/baseController/appInfosUpdate";
        /*System.out.println("入参="+str);
        DdlAppInfosReq ddlAppInfosReq= JSONObject.parseObject(str,DdlAppInfosReq.class);
        System.out.println("转换后参数对象="+ddlAppInfosReq);
        return JSONObject.toJSONString(ddlAppInfosReq);*/
        String result = HttpUtils.post01(url, str);
        DdlAppInfos ddlAppInfos = JSONObject.parseObject(result, DdlAppInfos.class);
        System.out.println("是否转换为内部对象="+ddlAppInfos);
        DdlAppInfosRsp ddlAppInfosRsp = JSONObject.parseObject(result, DdlAppInfosRsp.class);
        System.out.println("是否转换为外部对象="+ddlAppInfosRsp);
        String post = ddlAppInfosRsp.toString();
        //String post = HttpUtils.sendPostRequest(str);
        return post;
    }

    /**
     * 验证入参对象有多个参数，实际请求的入参少于对象的参数是否可以正常接收参数是否可以正常转换，
     * 预期：springmvc可以正常接收参数映射对象bean，有就赋值，没有传对应的参数的值就为null
     * @param appInfosReq
     * @return
     */
    @RequestMapping("parameterChangeTest")
    public String parameterChange(@RequestBody AppInfosReq appInfosReq) {

        System.out.println(appInfosReq.getAppInfo().getMenuUrl());
        return null;
    }

}
