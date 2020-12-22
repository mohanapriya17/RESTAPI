package com.jpa.dao;

import java.util.List;

import com.jpa.model.Customer;

public interface CustomerDao {

	List<Customer> fetchCustomer();


	void addCustomerDetails(Customer customer);


	Customer getCustomer(int id);

	  void deleteCustomer(int id);
	void updateCustomer(Customer customer);

}
