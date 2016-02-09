package com.twu.biblioteca.handler;

import com.twu.biblioteca.entity.Book;

import java.util.List;

public class QuitProcessHandler implements Handler{
    @Override
    public void handle(List<Book> bookList) {
        System.exit(0);
    }
}
