package com.killer.demo.enumCode;

public enum EnumDemo {
    MONDAY("星期一",1),
    TUESDAY("星期二",2),
    WEDNESDAY("星期三",3),
    THURSDAY("星期四",4),
    FRIDAY("星期五",5),
    SATURDAY("星期六",6),
    SUNDAY("星期日",7);
    private String name;
    private Integer index;

    EnumDemo(String name, Integer index) {
        this.name = name;
        this.index = index;
    }
    //根据下标获取中文名
    public static String getName(Integer index) {
        for (EnumDemo enumDemo : EnumDemo.values()) {
            if (enumDemo.getIndex() == index) {
                return enumDemo.name;
            }
        }
        return null;
    }
    //根据中文名获取下标
    public static Integer getIndex(String name) {
        for (EnumDemo enumDemo : EnumDemo.values()) {
            if (enumDemo.getName().equals(name)) {
                return enumDemo.index;
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

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
}
