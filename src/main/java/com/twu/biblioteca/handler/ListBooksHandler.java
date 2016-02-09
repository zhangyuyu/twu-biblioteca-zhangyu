package com.twu.biblioteca.handler;

import com.twu.biblioteca.entity.Book;

import java.util.List;

public class ListBooksHandler implements Handler {

    public void handle(List<Book> bookList) {
        bookList.stream()
                .filter(Book::isAvailable)
                .forEach(System.out::println);
    }
}
