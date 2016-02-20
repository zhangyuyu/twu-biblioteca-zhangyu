package com.twu.biblioteca.entity;

import static java.lang.String.format;

public class Customer {
    private String name;
    private String email;
    private String phoneNum;
    private String libraryNum;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getLibraryNum() {
        return libraryNum;
    }

    public void setLibraryNum(String libraryNum) {
        this.libraryNum = libraryNum;
    }

    @Override
    public String toString() {
        return format("[ %s ] - %s %s", getName(), getEmail(), getPhoneNum());
    }
}
