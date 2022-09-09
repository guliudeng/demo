package com.killer.demo.controller;

import com.killer.demo.redisModel.RedisHelp;
import com.killer.demo.redisModel.RedisLockEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
@RequestMapping("redis/")
@EnableScheduling
public class RedisController {
    @Autowired
    private RedisHelp redisHelp;

    @RequestMapping("luck")
    @Scheduled(cron = "0 0/2 * * * ?")
    public String redisLockTestMethod() {
        String key = "redis_key";
        String value = "18726341590";
        String result = "获取分布式锁成功";
        RedisLockEntity lockEntity = new RedisLockEntity(key, value);
        boolean lock = redisHelp.lock(lockEntity,100,120, TimeUnit.SECONDS);
        if (lock) {
            log.info("begin thread name={}",Thread.currentThread().getName());
            log.info("get luck success");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
              redisHelp.unLockLua(lockEntity);
            }
            log.info("end thread name={}",Thread.currentThread().getName());
            redisHelp.unLockLua(lockEntity);
        }else {
            log.info("get luck failed");
          result = "获取分布式锁失败"+Thread.currentThread().getName();
        }
        return result;

    }
}
