package com.finance.microfinance.repository;

import com.finance.microfinance.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    /*List<Customer> search(String code, String name, String lastName, String internationalCode);*/

/*
    List<Customer> search(@Param("code") String code, @Param("name") String name, @Param("lastName") String lastName, @Param("internationalCode") String internationalCode, Pageable pageable);
*/

    @Query(value = "select c from Customer c where c.id = ?1")
    Customer findCustomerById(@Param("theId") Integer theId);
}
