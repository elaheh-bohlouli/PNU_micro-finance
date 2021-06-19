package com.finance.microfinance.service.serviceClass;

import com.finance.microfinance.exceptions.ItemNotFoundException;
import com.finance.microfinance.model.Customer;
import com.finance.microfinance.repository.CustomerRepository;
import com.finance.microfinance.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class CustomerServiceClass implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> search(String code, String name, String lastName, String internationalCode) throws ItemNotFoundException {
        if (Objects.nonNull(code)) {
            return customerRepository.search(code, name, lastName, internationalCode);
        }
        return customerRepository.findAll();
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void createNewCustomer(Customer customer) {
        customer.setActive(true);
        customer.setLastModifiedDataTime(new Date());
        save(customer);
    }

    @Override
    public void updateCustomer(Customer customer) {
        customer.setLastModifiedDataTime(new Date());
        save(customer);
    }

    @Override
    public Customer findCustomerById(int theId) throws ItemNotFoundException {
        if (Objects.nonNull(customerRepository.findCustomerById(theId))) {
            return customerRepository.findCustomerById(theId);
        }
        throw new ItemNotFoundException();
    }

    @Override
    public void delete(int theId) {
        Customer customer = customerRepository.findCustomerById(theId);
        if (Objects.nonNull(customer)) {
            customer.setActive(false);
            save(customer);
        }
    }
}