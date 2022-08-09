package com.killer.demo.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 配置用户信息
 */

@Component
@ConfigurationProperties(prefix = "animals")
@Data
public class AnimalsInfoConfig {
    private AnimalsType animalsType;

    @Data
    public static  class AnimalsType {
        private AnimalsProperties animalsProperties;
        private AnimalsProperties peopleProperties;

        @Data
        public static class AnimalsProperties {
            private String name;
            private int age;
            private String sex;
        }
    }
}
