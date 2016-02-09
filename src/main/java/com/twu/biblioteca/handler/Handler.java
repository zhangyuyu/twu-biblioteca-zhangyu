package com.twu.biblioteca.handler;

import com.twu.biblioteca.entity.Book;

import java.util.List;

public interface Handler {
    void handle(List<Book> bookList);
}
