package com.twu.biblioteca.entity;

public class Item {
    private String name;
    private boolean isAvailable = true;
    private String publish;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setIsAvaliable(boolean isAvaliable) {
        this.isAvailable = isAvaliable;
    }

    public String getPublish() {
        return publish;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }
}
