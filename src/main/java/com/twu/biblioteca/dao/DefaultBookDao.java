package com.twu.biblioteca.dao;

import com.twu.biblioteca.entity.Book;
import com.twu.biblioteca.exception.ReadFileException;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class DefaultBookDao implements BookDao{
    public List<Book> getBooksFromFile() {
        try {
            return FileUtils.readLines(new File("src/main/resources/libraryBooks"))
                    .stream()
                    .map(this::getBook)
                    .collect(toList());
        } catch (IOException e) {
            throw new ReadFileException(e.getMessage());
        }
    }

    private Book getBook(String line) {
        Book book = new Book();
        String[] columns = line.split(",");
        book.setName(columns[0].trim());
        book.setAuthor(columns[1].trim());
        book.setPublish(columns[2].trim());
        return book;
    }
}
