package com.twu.biblioteca.entity;

import com.twu.biblioteca.handler.*;

public enum MainMenu {
    LIST_BOOKS("List Books", new ListBooksHandler()),
    QUIT("Quit", new QuitProcessHandler()),
    CHECKOUT_BOOK("Checkout Book", new CheckoutHandler()),
    RETURN_BOOK("Return Book", new ReturnHandler());

    private String message;
    private Handler handler;

    MainMenu(String message, Handler handler) {
        this.message = message;
        this.handler = handler;
    }

    @Override
    public String toString() {
        return message;
    }

    public Handler getHandler() {
        return handler;
    }
}
