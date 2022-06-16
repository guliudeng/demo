package com.killer.demo.controller;

import com.killer.demo.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("comm")
public class commonController {
    @Autowired
    private RedisService redisService;

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
}
