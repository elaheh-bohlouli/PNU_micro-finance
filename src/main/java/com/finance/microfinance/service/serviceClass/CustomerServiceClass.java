package com.finance.microfinance.service.serviceClass;

import com.finance.microfinance.exceptions.InternationalCodeValidationException;
import com.finance.microfinance.exceptions.ItemNotFoundException;
import com.finance.microfinance.model.Customer;
import com.finance.microfinance.repository.CustomerRepository;
import com.finance.microfinance.service.CustomerService;
import com.finance.microfinance.service.internationalId.DigitNumberCalculation;
import com.finance.microfinance.service.internationalId.RepetitiveNumberCalculation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class CustomerServiceClass implements CustomerService {

    @Autowired
    @Qualifier("customerRepository")
    private CustomerRepository customerRepository;
    public DigitNumberCalculation digitNumberCalculation;

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

    public Boolean validateNumber(String givenNumber) throws InternationalCodeValidationException {
        if (!StringUtils.isNumeric(givenNumber)) {
            throw new InternationalCodeValidationException("الگوی کد ملی فقط آعداد صحیح را می پذیرد.");
        } else if (givenNumber.length() > 10) {
            throw new InternationalCodeValidationException("تعداد اعداد ورودی بیش از ده می باشد.");
        } else if (givenNumber.length() < 10) {
            givenNumber = StringUtils.leftPad(givenNumber, 10, "0");
        }
        RepetitiveNumberCalculation repetitiveNumberCalculation = new RepetitiveNumberCalculation();
        int i = repetitiveNumberCalculation.repetitiveNumber(givenNumber);
        if (i == givenNumber.length()) {
            throw new InternationalCodeValidationException("تمام ارقام وارد شده تکراری می باشند.");
        }
        if (digitNumberCalculation.digitNumberCalculate(givenNumber))
            return true;
        else throw new InternationalCodeValidationException("بنا به محاسبات کد ملی صحیح نمی باشد.");
    }

    @Override
    public void createNewCustomer(Customer customer) throws InternationalCodeValidationException {
        if (Boolean.TRUE.equals(validateNumber(customer.getCode())))
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