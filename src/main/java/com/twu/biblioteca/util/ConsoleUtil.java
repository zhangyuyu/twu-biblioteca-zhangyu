package com.twu.biblioteca.util;

import java.util.Scanner;

public class ConsoleUtil {

    private final static String VALID_NUMBER="[0-9]";

    public static String getInputNum() {
        String inputNumber = getInputString();

        if (!inputNumber.matches(VALID_NUMBER)) {
            System.out.println("Select a valid option!");
            inputNumber = getInputNum();
        }
        return inputNumber;
    }

    public static String getInputString(){
        return new Scanner(System.in).nextLine();
    }
}
