package com.twu.biblioteca.dao;

import com.twu.biblioteca.entity.Account;
import com.twu.biblioteca.exception.ReadFileException;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class DefaultAccountDao implements AccountDao {

    @Override
    public boolean isValidAccount(String libraryNumber, String password) {
        return getAccountsFromFile().stream()
                .anyMatch(account -> (account.getLibraryNum().equals(libraryNumber))
                        && (account.getPassword().equals(password)));
    }

    @Override
    public List<Account> getAccountsFromFile() {
        try {
            return FileUtils.readLines(new File("src/main/resources/accounts"))
                    .stream()
                    .map(this::getAccount)
                    .collect(toList());
        } catch (IOException e) {
            throw new ReadFileException(e.getMessage());
        }
    }

    private Account getAccount(String line) {
        Account account = new Account();
        String[] columns = line.split(",");
        account.setLibraryNum(columns[0].trim());
        account.setPassword(columns[1].trim());
        return account;
    }
}
