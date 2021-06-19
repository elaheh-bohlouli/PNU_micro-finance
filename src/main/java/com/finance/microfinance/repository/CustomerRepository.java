package com.finance.microfinance.repository;

import com.finance.microfinance.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    /*    @Query("select c FROM Customer c WHERE c.code LIKE %?1%"
                + " OR c.name LIKE %?2%"
                + " OR c.lastName LIKE %?3%"
                + " OR c.internationalCode LIKE %?4%")
            *//*+ " OR CONCAT(c.price, '') LIKE %?1%"*//*
    List<Customer> search(String Code, String name, String lastName, String internationalCode);*/
/*
    List<Customer> search(@Param("code") String code, @Param("name") String name, @Param("lastName") String lastName, @Param("internationalCode") String internationalCode, Pageable pageable);
*/
    @Query(value = "select c from Customer c where c.code LIKE %?1% or c.name LIKE %?2% or c.lastName LIKE %?3% or c.internationalCode LIKE %?4%")
    List<Customer> search(@Param("code") String code, @Param("name") String name, @Param("lastName") String lastName, @Param("internationalCode") String internationalCode);


    @Query(value = "select c from Customer c where c.id = ?1")
    Customer findCustomerById(@Param("theId") Integer theId);
}
