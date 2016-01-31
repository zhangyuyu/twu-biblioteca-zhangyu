package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        Library library = new Library();
        printlnWelcomeMessage();
        library.listBooks("src/main/resources/libraryBooks");
    }


    private static void printlnWelcomeMessage() {
        System.out.println("Welcome to Bangalore Public Library !\n");
    }
}
