package com.twu.biblioteca;

import com.twu.biblioteca.entity.Library;

import static com.twu.biblioteca.handler.Handlers.showMenuOption;

public class BibliotecaApp {

    public static void main(String[] args) {
        Library library = new Library("Bangalore Public Library");
        library.printlnWelcomeMessage();
        while (true) {
            showMenuOption();
            library.handleMenuOption();
        }
    }
}
