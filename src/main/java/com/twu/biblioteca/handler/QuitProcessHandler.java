package com.twu.biblioteca.handler;

import com.twu.biblioteca.entity.Item;

import java.util.List;

public class QuitProcessHandler<E extends Item> implements Handler<E>{
    @Override
    public void handle(List<E> itemList, String libraryNum) {
        System.exit(0);
    }
}
