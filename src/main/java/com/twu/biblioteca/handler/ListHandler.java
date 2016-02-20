package com.twu.biblioteca.handler;

import com.twu.biblioteca.entity.Item;

import java.util.List;

public class ListHandler<E extends Item> implements Handler<E>{
    public void handle(List<E> itemList, String libraryNum) {
        itemList.stream()
                .filter(Item::isAvailable)
                .forEach(System.out::println);
    }
}
