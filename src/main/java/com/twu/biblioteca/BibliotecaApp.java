package com.twu.biblioteca;

import com.twu.biblioteca.entity.Library;

import static com.twu.biblioteca.util.ConsoleUtil.getInputNum;
import static com.twu.biblioteca.entity.MainMenu.LIST_BOOKS;
import static com.twu.biblioteca.entity.MainMenu.QUIT;

public class BibliotecaApp {

    public static void main(String[] args) {
        Library library = new Library("Bangalore Public Library");
        library.printlnWelcomeMessage();
        library.showMainMenu();
        chooseMenuOption(library);
    }

    private static void chooseMenuOption(Library library) {
        String menuValue = library.getMenuValue(getInputNum());

        if (LIST_BOOKS.toString().equals(menuValue)) {
            library.listBooks("src/main/resources/libraryBooks");
        }
        if(QUIT.toString().equals(menuValue)){
            System.exit(0);
        }
    }

}
