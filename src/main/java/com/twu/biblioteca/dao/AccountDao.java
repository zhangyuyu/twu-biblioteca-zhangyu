package com.twu.biblioteca.dao;

import com.twu.biblioteca.entity.Account;

import java.util.List;

public interface AccountDao {
    boolean isValidAccount(String libraryNumber, String password);
    List<Account> getAccountsFromFile();
}
