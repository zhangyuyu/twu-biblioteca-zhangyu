package com.twu.biblioteca.handler;

import com.twu.biblioteca.entity.Item;

import java.util.List;

import static com.twu.biblioteca.util.ConsoleUtil.getInputString;


public class ReturnHandler<E extends Item> implements Handler<E> {

    @Override
    public void handle(List<E> itemList, String libraryNum) {
        System.out.println("Please enter the name of book:");
        System.out.println(returnItem(getInputString(), itemList));
    }

    private String returnItem(String name, List<E> itemList) {
        for (E item : itemList) {
            if (item.getName().equalsIgnoreCase(name) && !item.isAvailable()) {
                item.setIsAvailable(true);
                item.setHolder(null);
                return "Thank you for returning the item.";
            }
        }
        return "That is not a valid item to return.";
    }
}
