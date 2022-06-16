package com.killer.demo.redisModel;

/**
 * Redis Lock Entity
 * 需要工具化，使用原始的get,set方法而不使用@Data
 * 使用建造者模式来创建对象
 * 为什么需要用final来修饰有参构造？
 * 为什么要重写equals和hashcode方法？
 */
public class RedisLockEntity {
    private String lockKey;//key
    private String requestId;//value

    public RedisLockEntity(final String lockKey, final String requestId) {
        this.lockKey = lockKey;
        this.requestId = requestId;
    }
    public static RedisLockEntity.RedisLockEntityBuilder builder() {
        return new RedisLockEntity.RedisLockEntityBuilder();
    }

    public String getLockKey() {
        return lockKey;
    }

    public void setLockKey(final String lockKey) {
        this.lockKey = lockKey;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(final String requestId) {
        this.requestId = requestId;
    }
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof RedisLockEntity)) {
            return false;
        } else {
            RedisLockEntity other = (RedisLockEntity)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$requestId = this.getRequestId();
                Object other$requestId = other.getRequestId();
                if (this$requestId == null) {
                    if (other$requestId != null) {
                        return false;
                    }
                } else if (!this$requestId.equals(other$requestId)) {
                    return false;
                }

                Object this$lockKey = this.getLockKey();
                Object other$lockKey = other.getLockKey();
                if (this$lockKey == null) {
                    if (other$lockKey != null) {
                        return false;
                    }
                } else if (!this$lockKey.equals(other$lockKey)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof RedisLockEntity;
    }

    /**
     * 重写hashCode有问题，待优化
     * @return
     */
    public int hashCode() {
        //int PRIME = true;
        int result = 1;
        Object $requestId = this.getRequestId();
         result = result * 59 + ($requestId == null ? 43 : $requestId.hashCode());
        Object $lockKey = this.getLockKey();
        result = result * 59 + ($lockKey == null ? 43 : $lockKey.hashCode());
        return result;
    }

    public String toString() {
        return "RedisLockEntity(requestId=" + this.getRequestId() + ", lockKey=" + this.getLockKey() + ")";
    }
    /**
     * 建造者模式
     * 必须是静态类
     */
    public static class RedisLockEntityBuilder{
        private String requestId;
        private String lockKey;

        public RedisLockEntityBuilder() {
        }
        public RedisLockEntity.RedisLockEntityBuilder requestId(final String requestId) {
            this.requestId = requestId;
            return this;
        }
        public RedisLockEntity.RedisLockEntityBuilder lockKey (final String lockKey) {
            this.lockKey = lockKey;
            return this;
        }
        public RedisLockEntity build() {
            return new RedisLockEntity(this.requestId,this.lockKey);
        }
        public String toString() {
            return "RedisLockEntity.RedisLockEntityBuilder(requestId=" + this.requestId + ", lockKey=" + this.lockKey + ")";
        }
    }
}
