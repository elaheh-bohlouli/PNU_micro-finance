package com.finance.microfinance.repository;

import com.finance.microfinance.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query("SELECT c FROM Customer c WHERE c.lastName LIKE %?1%")
    List<Customer> search(String lastName);

    @Query(value = "select c from Customer c where c.id = ?1")
    Customer findCustomerById(@Param("theId") Integer theId);
}
