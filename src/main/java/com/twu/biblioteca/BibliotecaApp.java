package com.twu.biblioteca;

import static com.twu.biblioteca.ConsoleUtil.getInputNum;
import static com.twu.biblioteca.MainMenu.LIST_BOOKS;

public class BibliotecaApp {

    public static void main(String[] args) {
        Library library = new Library("Bangalore Public Library");
        library.printlnWelcomeMessage();
        library.showMainMenu();
        if (LIST_BOOKS.toString().equals(library.getMenuValue(getInputNum()))) {
            library.listBooks("src/main/resources/libraryBooks");
        }
    }

}
