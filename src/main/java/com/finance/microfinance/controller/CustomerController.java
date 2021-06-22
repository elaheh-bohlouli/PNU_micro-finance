package com.finance.microfinance.controller;

import com.finance.microfinance.exceptions.ItemNotFoundException;
import com.finance.microfinance.model.Customer;
import com.finance.microfinance.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    private Specification<Customer> customerSpec;
    private Pageable pageable;

    @RequestMapping(value = "/newCustomer", method = RequestMethod.GET)
    public ModelAndView addCustomer(ModelAndView mv) {
        Customer customer = new Customer();
        mv.addObject("customer", customer);
        mv.setViewName("newCustomer");
        return mv;
    }

    @Transactional
    @RequestMapping(value = "/customerList", method = RequestMethod.GET)
    public ModelAndView findCustomersByCriteria(
            ModelAndView mv,
            @Param("code") String code,
            @Param("name") String name,
            @Param("lastName") String lastName,
            @Param("internationalCode") String internationalCode) throws ItemNotFoundException {
        List<Customer> listCustomers = customerService.searchByCriteria(code, name, lastName, internationalCode);
        mv.addObject("listCustomers", listCustomers);
        mv.addObject("code", code);
        mv.addObject("name", name);
        mv.addObject("lastName", lastName);
        mv.addObject("internationalCode", internationalCode);
        mv.setViewName("customerList");
        return mv;
    }

    @RequestMapping(value = "/saveCustomer", method = RequestMethod.POST)
    public ModelAndView saveCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.save(customer);
        return new ModelAndView("redirect:customerList");
    }

    @RequestMapping(value = "/deleteCustomer", method = {RequestMethod.GET})
    public ModelAndView deleteCustomer(HttpServletRequest request) {
        int customerId = Integer.parseInt(request.getParameter("id"));
        customerService.delete(customerId);
        return new ModelAndView("redirect:/customerList");
    }

    @RequestMapping(value = "/editCustomer", method = {RequestMethod.GET})
    public ModelAndView editCustomer(HttpServletRequest request) throws ItemNotFoundException {
        int customerId = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerService.findCustomerById(customerId);
        customerService.updateCustomer(customer);
        ModelAndView model = new ModelAndView("customer/CustomerForm");
        model.addObject("customer", customer);
        return model;
    }
}
