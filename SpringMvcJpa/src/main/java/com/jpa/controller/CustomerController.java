package com.jpa.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.jpa.model.Customer;
import com.jpa.service.CustomerService;

@RestController
//@RequestMapping("/customer")
public class CustomerController {
	@Autowired
 private CustomerService service;
	@GetMapping(value="/addCustomer")
	public ModelAndView getCustomer(@ModelAttribute("customer") Customer customer) {
		return new ModelAndView("addCustomer");
		
		
	}
	@GetMapping(value="/fetchCustomer")
	public ModelAndView fetchCustomer(){
		List<Customer> list=service.fetchCustomer();
		return new ModelAndView("fetchCustomer","customerDetails",list);
		
		
	}
/*	@PostMapping(value="/saveCustomer")
	public ModelAndView saveCustomer(@ModelAttribute("customer") Customer customer ) {
		service.addCustomerDetails(customer);
		return new ModelAndView("redirect:/fetchCustomer");
		
	}*/
	@GetMapping(value="/deleteCustomer")
    public ModelAndView deleteCustomer(HttpServletRequest request) {
        int id=Integer.parseInt(request.getParameter("custId"));
        service.deleteCustomer(id);
        return new ModelAndView("redirect:/fetchCustomer");
    }
	@GetMapping(value = "/editCustomer/{id}")
	public ModelAndView editCustomer(@ModelAttribute("customer")Customer customer,@PathVariable("id")int id) {
	customer = service.getCustomer(id);
	return new ModelAndView("addCustomer","customer",customer);
	}
	@PostMapping(value = "/saveCustomer")
	public ModelAndView saveCustomer(@ModelAttribute("customer")Customer customer) {
	System.out.println(customer.getCustomerId());
	if(customer.getCustomerId() > 0 ) {
	service.updateCustomer(customer);
	}else {
	service.addCustomerDetails(customer);
	}
	return new ModelAndView("redirect:/fetchCustomer");
	}
}
