package com.finance.microfinance.service;

import com.finance.microfinance.exceptions.ItemNotFoundException;
import com.finance.microfinance.model.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> searchByCriteria(String lastName) throws ItemNotFoundException;

    void save(Customer customer);

    void createNewCustomer(Customer customer);

    void updateCustomer(Customer customer);

    Customer findCustomerById(int theId) throws ItemNotFoundException;

    void delete(int theId);
}

