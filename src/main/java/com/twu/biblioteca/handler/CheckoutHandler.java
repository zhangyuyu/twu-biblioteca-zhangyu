package com.twu.biblioteca.handler;

import com.twu.biblioteca.entity.Item;

import java.util.List;

import static com.twu.biblioteca.util.ConsoleUtil.getInputString;

public class CheckoutHandler<E extends Item> implements Handler<E> {
    public String checkoutItem(String name, List<E> itemList) {
        for (E item : itemList) {
            if (item.getName().equalsIgnoreCase(name) && item.isAvailable()) {
                item.setIsAvaliable(false);
                return "Thank you! Enjoy the item.";
            }
        }
        return "That item is not available.";
    }

    @Override
    public void handle(List<E> itemList) {
        System.out.println("Please enter the name of item:");
        System.out.println(checkoutItem(getInputString(), itemList));
    }
}
