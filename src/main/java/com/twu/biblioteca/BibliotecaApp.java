package com.twu.biblioteca;

import com.twu.biblioteca.entity.Library;

import static com.twu.biblioteca.entity.MainMenu.LIST_BOOKS;
import static com.twu.biblioteca.entity.MainMenu.QUIT;
import static com.twu.biblioteca.util.ConsoleUtil.getInputNum;
import static com.twu.biblioteca.util.ConsoleUtil.getInputString;

public class BibliotecaApp {

    public static void main(String[] args) {
        Library library = new Library("Bangalore Public Library");
        library.printlnWelcomeMessage();
        library.showMainMenu();
        chooseMenuOption(library);
        chooseCheckoutOption(library);
    }

    private static void chooseCheckoutOption(Library library) {
        String message = library.checkout(getInputString());
        System.out.println(message);
    }

    private static void chooseMenuOption(Library library) {
        String menuValue = library.getMenuValue(getInputNum());

        if (LIST_BOOKS.toString().equals(menuValue)) {
            library.listAvailableBooks();
        }
        if(QUIT.toString().equals(menuValue)){
            System.exit(0);
        }
    }

}
