package com.killer.demo.redisModel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * 可以动态配置，是否加载该配置类，加快项目启动时间
 * RedisTemplate会存在自动注入失败
 * 包扫描标红，扫描失败
 */
@Component
public class RedisHelp {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private RedisTemplate redisTemplate;

    public RedisHelp() {
    }

    /**
     * 获取key
     * @param key
     * @return
     */
    public Object get(String key) {
        return key == null ? null : this.redisTemplate.opsForValue().get(key);
    }

    /**
     * 设置key,value
     * @param key
     * @param value
     * @return
     */
    public boolean set(String key, Object value) {
        try {
            this.redisTemplate.opsForValue().set(key, value);
            return true;
        } catch (Exception var4) {
            var4.printStackTrace();
            return false;
        }
    }

    /**
     * 设置key,value,超时时间
     * @param key
     * @param value
     * @param time
     * @return
     */
    public boolean set(String key, Object value, long time) {
        try {
            if (time > 0L) {
                this.redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
            } else {
                this.set(key, value);
            }

            return true;
        } catch (Exception var6) {
            var6.printStackTrace();
            return false;
        }
    }

    /**
     * 删除key
     * @param key
     */
    public void del(String... key) {
        if (key != null && key.length > 0) {
            if (key.length == 1) {
                this.redisTemplate.delete(key[0]);
            } else {
                this.redisTemplate.delete(CollectionUtils.arrayToList(key));
            }
        }

    }

    /**
     * 设置超时时间，以秒为单位
     * @param key
     * @param time
     * @return
     */
    public boolean expire(String key, long time) {
        try {
            if (time > 0L) {
                this.redisTemplate.expire(key, time, TimeUnit.SECONDS);
            }

            return true;
        } catch (Exception var5) {
            var5.printStackTrace();
            return false;
        }
    }

    /**
     * 获取超时时间，单位秒
     * @param key
     * @return
     */
    public long getExpire(String key) {
        return this.redisTemplate.getExpire(key, TimeUnit.SECONDS);
    }

    /**
     * 获取分布式锁
     * @param redisLockEntity 锁对象
     * @param tryLockSleep 尝试获取锁休眠时间
     * @param expTime 超时时间
     * @param timeUnit 时间单位
     * @return
     */
    public boolean lock(RedisLockEntity redisLockEntity,long tryLockSleep ,long expTime,TimeUnit timeUnit) {
        boolean locked = false;
        int tryCount = 3;
        while (!locked && tryCount > 0) {
            locked = this.redisTemplate.opsForValue().setIfAbsent(redisLockEntity.getLockKey(), redisLockEntity.getRequestId(), expTime, timeUnit);
            if (!locked) {
                --tryCount;
                try {
                    TimeUnit.MILLISECONDS.sleep(tryLockSleep);
                } catch (InterruptedException e) {
                    this.logger.error("线程被中断:"+Thread.currentThread().getId(),e);
                }
            }
        }
        return locked;
    }

    public boolean lock(RedisLockEntity redisLockEntity, long tryLockSleepMill, long expSec) {
        return this.lock(redisLockEntity, tryLockSleepMill, expSec, TimeUnit.SECONDS);
    }

    public boolean lock(RedisLockEntity redisLockEntity, long tryLockSleepMill) {
        return this.lock(redisLockEntity, tryLockSleepMill, 10L, TimeUnit.SECONDS);
    }

    public boolean lock(RedisLockEntity redisLockEntity) {
        return this.lock(redisLockEntity, 300L);
    }

    /**
     * 释放锁
     * @param redisLockEntity 锁对象
     * @return
     */
    public boolean unLockLua(RedisLockEntity redisLockEntity) {
        if (null != redisLockEntity && null !=redisLockEntity.getLockKey() && null != redisLockEntity.getRequestId() ) {
            DefaultRedisScript<Long> redisScript = new DefaultRedisScript();
            redisScript.setLocation(new ClassPathResource("unlock.lua"));
            redisScript.setResultType(Long.class);
            Object execute = this.redisTemplate.execute(redisScript, Arrays.asList(redisLockEntity.getLockKey()), new Object[]{redisLockEntity.getRequestId()});
            return execute.equals(1L);
        }else {
            return false;
        }
    }

}
