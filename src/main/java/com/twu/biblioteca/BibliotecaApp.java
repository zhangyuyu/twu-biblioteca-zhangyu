package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        Library library = new Library("Bangalore Public Library");
        library.printlnWelcomeMessage();
        library.listBooks("src/main/resources/libraryBooks");
    }

}
