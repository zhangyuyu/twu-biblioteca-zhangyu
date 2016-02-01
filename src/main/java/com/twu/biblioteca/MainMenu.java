package com.twu.biblioteca;

public enum MainMenu {
    LIST_BOOKS;

    private String message;

    MainMenu() {
        this.message = "List Books";
    }

    @Override
    public String toString() {
        return message;
    }
}
