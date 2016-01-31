package com.twu.biblioteca;

import java.io.File;
import java.io.IOException;

import static org.apache.commons.io.FileUtils.readFileToString;

public class Library {

    public void listBooks(String filePath) {
        try {
            String fileContent = readFileToString(new File(filePath));
            System.out.println(fileContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
