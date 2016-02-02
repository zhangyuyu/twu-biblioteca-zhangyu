package com.twu.biblioteca.entity;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.twu.biblioteca.entity.MainMenu.LIST_BOOKS;
import static com.twu.biblioteca.entity.MainMenu.QUIT;
import static java.lang.String.format;
import static java.util.stream.Collectors.toList;

public class Library {

    private String name;
    private Map<String, Enum> menuMap = new HashMap<>();
    public List<Book> bookList = new ArrayList<Book>();

    public Library(String name) {
        this.name = name;
    }

    public void printlnWelcomeMessage() {
        System.out.println(format("Welcome to %s !", this.name));
    }

    public void showMainMenu() {
        prepareMenuMap();
        System.out.println("------------------------------------");
        for (String key :menuMap.keySet()) {
            System.out.println(format("- %s. %s ", key, getMenuValue(key)));
        }
        System.out.println("------------------------------------");
        System.out.println("Please enter your option:");
    }

    private void prepareMenuMap() {
        menuMap.put("1", LIST_BOOKS);
        menuMap.put("2", QUIT);
    }

    public String getMenuValue(String number) {
        return menuMap.get(number).toString();
    }

    public void listBooks(String filePath) {
        try {
            bookList = FileUtils.readLines(new File(filePath))
                    .stream()
                    .map(this::getBook)
                    .collect(toList());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Book getBook(String line) {
        System.out.println(line);
        Book book = new Book();
        String[] columns = line.split(",");
        book.setTitle(columns[0].trim());
        book.setAuthor(columns[1].trim());
        book.setPublish(columns[2].trim());
        return book;
    }
}
