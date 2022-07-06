package com.isspark.starter.event;

public class StarterEvent extends AbstractEvent{

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StarterEvent(Object source) {
        super(source);
    }
}
