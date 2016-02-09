package com.twu.biblioteca.handler;

import com.twu.biblioteca.entity.Book;

import java.util.List;

import static com.twu.biblioteca.util.ConsoleUtil.getInputString;

public class ReturnHandler implements Handler{
    @Override
    public void handle(List<Book> bookList) {
        System.out.println("Please enter the name of book:");
        System.out.println(returnBook(getInputString(), bookList));
    }

    public String returnBook(String name,List<Book> bookList) {
        for (Book book : bookList) {
            if (book.getTitle().equalsIgnoreCase(name) && !book.isAvailable()) {
                book.setIsAvaliable(true);
                return "Thank you for returning the book.";
            }
        }
        return "That is not a valid book to return.";
    }
}
