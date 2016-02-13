package com.twu.biblioteca.entity;

import static java.lang.String.format;

public class Movie extends Item{
    private String director;
    private String rate;

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return format("[ %s ] - %s %s Rating:%s", getName(), director, getPublish(), rate);
    }
}
