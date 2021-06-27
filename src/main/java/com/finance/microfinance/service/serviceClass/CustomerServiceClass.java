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
    public List<Customer> searchByCriteria(String lastName) throws ItemNotFoundException {
        if (lastName != null) {
            return customerRepository.search(lastName);
        }
        return customerRepository.findAll();
    }

    /*    Session session = new Configuration().configure().buildSessionFactory().openSession();
        try {
            if (Objects.nonNull(code) || Objects.nonNull(name) || Objects.nonNull(lastName) || Objects.nonNull(internationalCode)) {
                String queryString = "SELECT c FROM Customer c WHERE 1=1";
                if (Objects.nonNull(code)) {
                    queryString += "and c.code = code";
                } else if (Objects.nonNull(name)) {
                    queryString += "and c.name = name";
                } else if (Objects.nonNull(lastName)) {
                    queryString += "and c.lastName = lastName";
                } else if (Objects.nonNull(internationalCode)) {
                    queryString += "and c.name = customerCriteria.internationalCode";
                }
                Query query = session.createQuery(queryString);
                query.setParameter("code", "code");
                query.setParameter("name", "name");
                query.setParameter("lastName", "lastName");
                query.setParameter("internationalCode", "internationalCode");
                List<Customer> customerList = query.list();
                return customerList;
            }
        } catch (Exception exception) {
            System.out.println("Exception " + exception);
        } finally {
            session.close();
    */

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

    public Customer get(int id) {
        return customerRepository.findById(id).get();
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