package com.twu.biblioteca;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.twu.biblioteca.MainMenu.LIST_BOOKS;
import static com.twu.biblioteca.MainMenu.QUIT;
import static java.lang.String.format;
import static org.apache.commons.io.FileUtils.readFileToString;

public class Library {

    private String name;
    private Map<String, Enum> menuMap = new HashMap<>();

    public Library(String name) {
        this.name = name;
    }

    public void printlnWelcomeMessage() {
        System.out.println(format("Welcome to %s !", this.name));
    }

    public void listBooks(String filePath) {
        try {
            String fileContent = readFileToString(new File(filePath));
            System.out.println(fileContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
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

}
