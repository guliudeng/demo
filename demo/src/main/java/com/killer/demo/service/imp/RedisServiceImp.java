package com.killer.demo.service.imp;

import com.killer.demo.redisModel.RedisHelp;
import com.killer.demo.redisModel.RedisLockEntity;
import com.killer.demo.service.RedisService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RedisServiceImp implements RedisService {
    @Resource
    private RedisHelp redisHelp;
    /**
     * 添加redis配置和客户端jedis配置,添加RedisTemplate依赖
     *设置key的同时设置超时时间，两者保持原子性
     *释放锁时将获取key的value和删除key的操作合并为原子性
     */
    @Override
    public String lockDemo(String phone) {
        //获取锁对象，设置锁的Key和value
        try {
            RedisLockEntity.RedisLockEntityBuilder builder = RedisLockEntity.builder();
            builder.lockKey("Redis:Lock");
            builder.requestId(phone);
            boolean lock = redisHelp.lock(builder.build(), 60, 60 );
            if (lock) {
                String key = "killer:" +phone;
                Object o = redisHelp.get(key);
                if (null != o ) {
                    return "已存在key,"+ key;
                }
               redisHelp.set(key, 1, 60 * 60);
                redisHelp.unLockLua(builder.build());
            }else {
                return "no lock!";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "成功";
    }
}
