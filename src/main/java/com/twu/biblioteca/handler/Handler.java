package com.twu.biblioteca.handler;

import com.twu.biblioteca.entity.Item;

import java.util.List;

public interface Handler <E extends Item>{
    void handle(List<E> itemList, String libraryNum);
}
