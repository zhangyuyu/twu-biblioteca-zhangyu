package com.twu.biblioteca.entity;

public enum MainMenu {
    LIST_BOOKS("List Books"), QUIT("Quit");

    private String message;

    MainMenu() {
    }

    MainMenu(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
