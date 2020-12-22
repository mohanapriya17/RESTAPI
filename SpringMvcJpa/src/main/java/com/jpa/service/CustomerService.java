package com.jpa.service;

import java.util.List;

import com.jpa.model.Customer;

public interface CustomerService {

	List<Customer> fetchCustomer();

	void addCustomerDetails(Customer customer);
	Customer getCustomer(int id);
	void updateCustomer(Customer customer);

	void deleteCustomer(int id);

}
