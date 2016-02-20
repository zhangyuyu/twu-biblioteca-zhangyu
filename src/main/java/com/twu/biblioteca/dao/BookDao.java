package com.twu.biblioteca.dao;

import com.twu.biblioteca.entity.Book;

import java.util.List;

public interface BookDao {
    List<Book> getBooksFromFile();
}
