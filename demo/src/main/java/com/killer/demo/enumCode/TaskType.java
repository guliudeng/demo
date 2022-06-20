package com.killer.demo.enumCode;

public enum TaskType {
    RED("红色","red"),GREEN("绿色","green");
    private String name;
    private String value;
    //有参构造器来创建对象
    private TaskType(String name,String value) {
        this.name = name;
        this.value = value;
    }
    //提供公共的方法，通过值来获取名字
    public static String getName(String value){
        for (TaskType taskType : TaskType.values()) {
            if (taskType.getValue().equals(value)) {
                return taskType.name;
            }
        }
        return null;
    }
    //提供公共的方法，通过值来获取名字
    public static String getValud(String name) {
        for (TaskType value : TaskType.values()) {
            if (value.getName().equals(name)) {
                return value.value;
            }
        }
        return null;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
