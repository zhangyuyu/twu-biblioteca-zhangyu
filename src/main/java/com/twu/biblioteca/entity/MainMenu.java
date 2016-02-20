package com.twu.biblioteca.entity;

import com.twu.biblioteca.handler.*;

public enum MainMenu {
    LIST_BOOKS("List Books", new ListHandler<Book>()),
    QUIT("Quit", new QuitProcessHandler()),
    CHECKOUT_BOOK("Checkout Book", new CheckoutHandler<Book>()),
    RETURN_BOOK("Return Book", new ReturnHandler()),
    LIST_MOVIES("List Movies", new ListHandler<Movie>()),
    CHECKOUT_MOVIE("Checkout Movie", new CheckoutHandler<Movie>()),
    USER_INFORMATION ("User Information");

    private String message;
    private Handler handler;

    MainMenu(String message, Handler handler) {
        this.message = message;
        this.handler = handler;
    }

    MainMenu(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }

    public Handler getHandler() {
        return handler;
    }
}
