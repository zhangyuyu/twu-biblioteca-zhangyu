package com.twu.biblioteca.dao;

public interface AccountDao {
    boolean isValidAccount(String libraryNumber, String password);
}
