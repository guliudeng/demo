package com.killer.demo.bo;

import lombok.Data;

@Data
public class TestMax {
    private String name;
    private Long age;

    public TestMax(String name, Long age) {
        this.name = name;
        this.age = age;
    }
}
