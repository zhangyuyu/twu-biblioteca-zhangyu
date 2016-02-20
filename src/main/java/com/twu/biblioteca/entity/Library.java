package com.twu.biblioteca.entity;

import com.twu.biblioteca.dao.DefaultAccountDao;
import com.twu.biblioteca.dao.DefaultBookDao;
import com.twu.biblioteca.dao.DefaultMovieDao;
import com.twu.biblioteca.handler.Handler;

import java.util.List;

import static com.twu.biblioteca.handler.Handlers.*;
import static com.twu.biblioteca.util.ConsoleUtil.getInputNum;
import static com.twu.biblioteca.util.ConsoleUtil.getInputString;
import static java.lang.Integer.parseInt;
import static java.lang.String.format;

public class Library {

    private String name;
    private DefaultAccountDao accountDao = new DefaultAccountDao();
    private DefaultBookDao bookDao=new DefaultBookDao();
    private DefaultMovieDao movieDao = new DefaultMovieDao();

    List<Book> bookList = bookDao.getBooksFromFile();
    List<Movie> movieList = movieDao.getMoviesFromFile();

    public void printlnWelcomeMessage() {
        System.out.println(format("Welcome to %s !", this.name));
    }

    public String validateAccount() {
        System.out.println("please enter your library number:");
        String libraryNumber = getInputString();

        System.out.println("please enter your password:");
        String password = getInputString();

        if (!accountDao.isValidAccount(libraryNumber, password)) {
            System.out.println("The library number or password is incorrect!");
            return validateAccount();
        }
        return libraryNumber;
    }

    public void showMenuOption() {
        System.out.println("------------------------------------\n");
        for (String key : getMenuMap().keySet()) {
            System.out.println(format("- %s. %s ", key, findMenuMessage(key)));
        }
        System.out.println("\n------------------------------------");
    }

    public void handleMenuOption(String libraryNum) {
        System.out.println("Please enter your option:");
        String inputNum = getInputNum();

        Handler menuHandler = findMenuHandler(inputNum);

        if (parseInt(inputNum) < 5) {
            menuHandler.handle(bookList, libraryNum);
        } else {
            menuHandler.handle(movieList, libraryNum);
        }

    }

    public Library(String name) {
        this.name = name;
    }
}
