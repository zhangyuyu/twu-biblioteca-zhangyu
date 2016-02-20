package com.twu.biblioteca.entity;

import com.twu.biblioteca.exception.ReadFileException;
import com.twu.biblioteca.handler.Handler;
import com.twu.biblioteca.handler.InformationHandler;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.twu.biblioteca.handler.Handlers.findMenuHandler;
import static com.twu.biblioteca.util.ConsoleUtil.getInputNum;
import static com.twu.biblioteca.util.ConsoleUtil.getInputString;
import static java.lang.Integer.parseInt;
import static java.lang.String.format;
import static java.util.stream.Collectors.toList;

public class Library {

    private String name;
    private List<Book> bookList = getBooksFromFile();
    private List<Movie> movieList = getMoviesFromFile();
    private List<String> checkoutLibraryNum = new ArrayList<>();

    public Library(String name) {
        this.name = name;
    }

    public void printlnWelcomeMessage() {
        System.out.println(format("Welcome to %s !", this.name));
    }

    public void handleMenuOption(String libraryNum) {
        String inputNum = getInputNum();
        Handler menuHandler = findMenuHandler(inputNum);
        if (parseInt(inputNum) < 5) {
            menuHandler.handle(bookList);
        } else if (parseInt(inputNum) == 7) {
            InformationHandler informationHandler = new InformationHandler();
            informationHandler.handle(libraryNum);
        } else {
            menuHandler.handle(movieList);
        }
        checkoutLibraryNum.add(libraryNum);
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

    private List<Account> getAccountsFromFile() {
        try {
            return FileUtils.readLines(new File("src/main/resources/accounts"))
                    .stream()
                    .map(this::getAccount)
                    .collect(toList());
        } catch (IOException e) {
            throw new ReadFileException(e.getMessage());
        }
    }

    private Account getAccount(String line) {
        Account account = new Account();
        String[] columns = line.split(",");
        account.setLibraryNum(columns[0].trim());
        account.setPassword(columns[1].trim());
        return account;
    }

    private boolean isValidAccount(String libraryNumber, String password) {
        return getAccountsFromFile().stream()
                .anyMatch(account -> (account.getLibraryNum().equals(libraryNumber))
                        && (account.getPassword().equals(password)));
    }

    public String checkAccount() {
        System.out.println("please enter your library number:");
        String libraryNumber = getInputString();

        System.out.println("please enter your password:");
        String password = getInputString();

        if (!isValidAccount(libraryNumber, password)) {
            System.out.println("The library number or password is incorrect!");
            return checkAccount();
        }
        return libraryNumber;
    }

    public List<String> getCheckoutLibraryNum() {
        return checkoutLibraryNum;
    }

}
