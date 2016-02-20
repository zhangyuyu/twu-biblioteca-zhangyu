package com.twu.biblioteca;

import com.twu.biblioteca.entity.Library;

public class BibliotecaApp {

    public static void main(String[] args) {
        Library library = new Library("Bangalore Public Library");
        library.printlnWelcomeMessage();
        String accountNum = library.validateAccount();
        while (true) {
            library.showMenuOption();
            library.handleMenuOption(accountNum);
        }
    }
}
