package com.twu.biblioteca.entity;

import static java.lang.String.format;

public class Book extends Item{
    private String author;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return format("[ %s ] - %s %s", getName(), author, getPublish());
    }
}
