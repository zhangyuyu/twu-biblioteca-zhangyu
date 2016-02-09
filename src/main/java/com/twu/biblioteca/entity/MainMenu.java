package com.twu.biblioteca.entity;

public enum MainMenu {
    LIST_BOOKS("List Books"),
    QUIT("Quit"),
    CHECKOUT_BOOK("Checkout Book"),
    RETURN_BOOK("Return Book");

    private String message;

    MainMenu(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
