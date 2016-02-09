package com.twu.biblioteca;

import com.twu.biblioteca.entity.Library;

import static com.twu.biblioteca.entity.MainMenu.LIST_BOOKS;
import static com.twu.biblioteca.entity.MainMenu.QUIT;
import static com.twu.biblioteca.entity.MainMenu.CHECKOUT_BOOK;
import static com.twu.biblioteca.entity.MainMenu.RETURN_BOOK;
import static com.twu.biblioteca.util.ConsoleUtil.getInputNum;
import static com.twu.biblioteca.util.ConsoleUtil.getInputString;

public class BibliotecaApp {

    public static void main(String[] args) {
        Library library = new Library("Bangalore Public Library");
        library.printlnWelcomeMessage();
        while (true) {
            library.showMainMenu();
            chooseMenuOption(library);
        }
    }

    private static void chooseMenuOption(Library library) {
        String menuValue = library.getMenuValue(getInputNum());

        if (LIST_BOOKS.toString().equals(menuValue)) {
            library.listAvailableBooks();
        }
        if (CHECKOUT_BOOK.toString().equals(menuValue)) {
            chooseCheckoutOption(library);
        }
        if (RETURN_BOOK.toString().equals(menuValue)) {
            chooseReturnOption(library);
        }
        if (QUIT.toString().equals(menuValue)) {
            System.exit(0);
        }
    }

    private static void chooseCheckoutOption(Library library) {
        System.out.println("Please enter the name of book:");
        String message = library.checkout(getInputString());
        System.out.println(message);
    }

    private static void chooseReturnOption(Library library) {
        System.out.println("Please enter the name of book:");
        String message = library.returnBook(getInputString());
        System.out.println(message);
    }

}
