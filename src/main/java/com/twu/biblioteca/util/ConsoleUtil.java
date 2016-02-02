package com.twu.biblioteca.util;

import java.util.Scanner;

public class ConsoleUtil {

    private final static String VALID_NUMBER="[1-9]";

    public static String getInputNum() {
        String inputNumber = new Scanner(System.in).nextLine();

        if (!inputNumber.matches(VALID_NUMBER)) {
            System.out.println("Select a valid option!");
            inputNumber = getInputNum();
        }
        return inputNumber;
    }
}
