package com.twu.biblioteca.handler;

import com.twu.biblioteca.entity.MainMenu;

import java.util.HashMap;
import java.util.Map;

import static com.twu.biblioteca.entity.MainMenu.*;

public class Handlers {
    private static final Map<String, MainMenu> menuMap = new HashMap<String, MainMenu>() {
        {
            put("1", LIST_BOOKS);
            put("2", QUIT);
            put("3", CHECKOUT_BOOK);
            put("4", RETURN_BOOK);
            put("5", LIST_MOVIES);
            put("6", CHECKOUT_MOVIE);
            put("7", USER_INFORMATION);
        }
    };

    public static Map<String, MainMenu> getMenuMap() {
        return menuMap;
    }

    public static String findMenuMessage(String menuOption) {
        return menuMap.get(menuOption).toString();
    }

    public static Handler findMenuHandler(String menuOption) {
        return menuMap.get(menuOption).getHandler();
    }

}
