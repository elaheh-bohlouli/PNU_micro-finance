package com.finance.microfinance.controller;

import com.finance.microfinance.exceptions.ItemNotFoundException;
import com.finance.microfinance.model.Customer;
import com.finance.microfinance.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/customerList")
    public String viewSearchPage(ModelAndView model, @Param("code") String code, @Param("name") String name, @Param("lastName") String lastName, @Param("internationalCode") String internationalCode) throws ItemNotFoundException {
        List<Customer> listCustomers = customerService.search(code, name, lastName, internationalCode);
        model.addObject("listCustomers", listCustomers);
        model.addObject("code", code);
        model.addObject("name", name);
        model.addObject("lastName", lastName);
        model.addObject("internationalCode", internationalCode);
        model.setViewName("customerList");
        return "model";
    }

    @RequestMapping(value = "/saveCustomer", method = RequestMethod.POST)
    public ModelAndView saveCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.save(customer);
        return new ModelAndView("redirect:customerList");
    }

    @RequestMapping(value = "/newCustomer", method = RequestMethod.GET)
    public ModelAndView addCustomer(ModelAndView model, HttpServletRequest request) throws ItemNotFoundException {
        Customer customer = new Customer();
        model.addObject("customer", customer);
        model.setViewName("newCustomer");
        return model;
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
