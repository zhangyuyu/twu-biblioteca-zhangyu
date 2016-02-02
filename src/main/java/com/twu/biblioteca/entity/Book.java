package com.twu.biblioteca.entity;

import static java.lang.String.format;

public class Book {
    private String title;
    private String author;
    private String publish;
    private boolean isAvailable = true;
    private String owner;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublish() {
        return publish;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setIsAvaliable(boolean isAvaliable) {
        this.isAvailable = isAvaliable;
    }

    @Override
    public String toString() {
        return format("[ %s ] - %s %s", title, author, publish);
    }
}
