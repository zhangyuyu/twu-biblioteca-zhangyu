package com.twu.biblioteca.entity;

import com.twu.biblioteca.exception.ReadFileException;
import com.twu.biblioteca.handler.Handler;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static com.twu.biblioteca.handler.Handlers.findMenuHandler;
import static com.twu.biblioteca.util.ConsoleUtil.getInputNum;
import static java.lang.Integer.parseInt;
import static java.lang.String.format;
import static java.util.stream.Collectors.toList;

public class Library {

    private String name;
    public List<Book> bookList = getBooksFromFile();
    public List<Movie> movieList = getMoviesFromFile();

    public Library(String name) {
        this.name = name;
    }

    public void printlnWelcomeMessage() {
        System.out.println(format("Welcome to %s !", this.name));
    }

    public void handleMenuOption() {
        String inputNum = getInputNum();
        Handler menuHandler = findMenuHandler(inputNum);
        if (parseInt(inputNum) < 5) {
            menuHandler.handle(bookList);
        } else {
            menuHandler.handle(movieList);
        }
    }

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

    public List<Movie> getMoviesFromFile() {
        try {
            return FileUtils.readLines(new File("src/main/resources/movies"))
                    .stream()
                    .map(this::getMovie)
                    .collect(toList());
        } catch (IOException e) {
            throw new ReadFileException(e.getMessage());
        }
    }

    private Movie getMovie(String line) {
        Movie movie = new Movie();
        String[] columns = line.split(",");
        movie.setName(columns[0].trim());
        movie.setDirector(columns[1].trim());
        movie.setPublish(columns[2].trim());
        movie.setRate(columns[3].trim());
        return movie;
    }
}
