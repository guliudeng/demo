package com.killer.demo.bo;

/**
 * 继承父类
 * 是否继承父类方法
 * 是否继承父类成员属性
 * 是否继承父类构造器
 */
public class ChildExtend extends ParentExtend{

    public ChildExtend() {
        super();
    }

    @Override
    public void eat() {
        System.out.println("child...eat...");
    }
}
