package com.twu.biblioteca;

import java.io.File;
import java.io.IOException;

import static java.lang.String.format;
import static org.apache.commons.io.FileUtils.readFileToString;

public class Library {

    private String name;

    public Library(String name) {
        this.name = name;
    }

    public void printlnWelcomeMessage() {
        System.out.println(format("Welcome to %s !\n", this.name));
    }

    public void listBooks(String filePath) {
        try {
            String fileContent = readFileToString(new File(filePath));
            System.out.println(fileContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
