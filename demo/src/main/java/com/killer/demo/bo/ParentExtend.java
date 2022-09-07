package com.killer.demo.bo;

import lombok.Data;

/**
 * 继承测试
 */
@Data
public class ParentExtend {
    private String name;
    private Integer age;

    public void eat() {
        System.out.println("parent ...eat...");
    }

    public ParentExtend() {
        this.name = "parent";
        this.age = 33;
    }
}
