package com.killer.demo.bo;

import java.util.List;

public class AppDelete {
    private List<String> munuIds;

    public List<String> getMunuIds() {
        return munuIds;
    }

    public void setMunuIds(List<String> munuIds) {
        this.munuIds = munuIds;
    }

    @Override
    public String toString() {
        return "appDelete{" +
                "munuIds=" + munuIds +
                '}';
    }
}
