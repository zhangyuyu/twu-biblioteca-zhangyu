package com.twu.biblioteca.entity;

import static java.lang.String.format;

public class Book extends Item{
    private String author;
    private String owner;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return format("[ %s ] - %s %s", getName(), author, getPublish());
    }
}
