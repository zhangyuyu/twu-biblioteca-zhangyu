package com.twu.biblioteca.handler;

import com.twu.biblioteca.entity.Customer;
import com.twu.biblioteca.entity.Item;
import com.twu.biblioteca.exception.ReadFileException;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class ViewInformationHandler<E extends Item> implements Handler<E> {

    @Override
    public void handle(List<E> itemList, String libraryNum) {
        Customer loggedCustomer = getCustomersFromFile().stream()
                .filter(customer -> customer.getLibraryNum().equals(libraryNum))
                .findAny().get();
        System.out.println(loggedCustomer);
    }

    private List<Customer> getCustomersFromFile() {
        try {
            return FileUtils.readLines(new File("src/main/resources/customers"))
                    .stream()
                    .map(this::getCustomer)
                    .collect(toList());
        } catch (IOException e) {
            throw new ReadFileException(e.getMessage());
        }
    }

    private Customer getCustomer(String line) {
        Customer customer = new Customer();
        String[] columns = line.split(",");
        customer.setName(columns[0].trim());
        customer.setEmail(columns[1].trim());
        customer.setPhoneNum(columns[2].trim());
        customer.setLibraryNum(columns[3].trim());
        return customer;
    }

}
