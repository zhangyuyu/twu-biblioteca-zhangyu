package com.twu.biblioteca.handler;

import com.twu.biblioteca.entity.Book;

import java.util.List;

import static com.twu.biblioteca.util.ConsoleUtil.getInputString;

public class CheckoutHandler implements Handler {
    @Override
    public void handle(List<Book> bookList) {
        System.out.println("Please enter the name of book:");
        System.out.println(checkoutBook(getInputString(), bookList));
    }

    public String checkoutBook(String name, List<Book> bookList) {
        for (Book book : bookList) {
            if (book.getTitle().equalsIgnoreCase(name) && book.isAvailable()) {
                book.setIsAvaliable(false);
                return "Thank you! Enjoy the book.";
            }
        }
        return "That book is not available.";
    }
}
