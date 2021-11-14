package com.finance.microfinance.service.serviceClass;

import com.finance.microfinance.exceptions.InternationalCodeValidationException;
import com.finance.microfinance.model.Customer;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.testng.annotations.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class CustomerServiceClassTest {

    @Autowired
    private CustomerServiceClass customerServiceClass;

    @Test
    void searchByCriteria() {
    }

    @org.junit.jupiter.api.Test
    void save() {
    }

    @org.junit.jupiter.api.Test
    void validateNumber() {
    }

    @org.junit.jupiter.api.Test
    void createNewCustomer() throws InternationalCodeValidationException {
        Customer customer = new Customer();
        customer.setName("ela");
        customer.setLastName("boh");
        customer.setCode("2755656298");
        customer.setCreateDate(new Date());
        customer.setInternationalCode("2755656298");
        customer.setActive(true);
        customer.setPortionNumber("2");
        customer.setLastModifiedDataTime(new Date());
        customer.setId(1);
        Customer customer1 = customerServiceClass.createNewCustomer(customer);
        assertNotNull(customer1);
        assertNotNull(customer1.getInternationalCode());
        assertEquals("ela", customer1.getName());
    }

    @org.junit.jupiter.api.Test
    void updateCustomer() {
    }

    @org.junit.jupiter.api.Test
    void get() {
    }

    @org.junit.jupiter.api.Test
    void delete() {
    }
}