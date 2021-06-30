package com.finance.microfinance.service;

import com.finance.microfinance.exceptions.InternationalCodeValidationException;
import com.finance.microfinance.exceptions.ItemNotFoundException;
import com.finance.microfinance.model.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> searchByCriteria(String lastName) throws ItemNotFoundException;

    void save(Customer customer);

    void createNewCustomer(Customer customer) throws InternationalCodeValidationException;

    void updateCustomer(Customer customer);

    Customer get(int id);

    void delete(int theId);
}

