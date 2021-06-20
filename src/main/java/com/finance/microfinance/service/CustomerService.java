package com.finance.microfinance.service;

import com.finance.microfinance.exceptions.ItemNotFoundException;
import com.finance.microfinance.model.Customer;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface CustomerService {

    List<Customer> search(String code, String name, String lastName, String internationalCode) throws ItemNotFoundException;

    void save(Customer customer);

    void createNewCustomer(Customer customer);

    void updateCustomer(Customer customer);

    Customer findCustomerById(int theId) throws ItemNotFoundException;

    void delete(int theId);
}

