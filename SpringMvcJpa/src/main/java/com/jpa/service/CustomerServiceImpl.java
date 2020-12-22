package com.jpa.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.dao.CustomerDao;
import com.jpa.model.Customer;
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
@Autowired
private CustomerDao dao;
	@Override
	public List<Customer> fetchCustomer() {
		// TODO Auto-generated method stub
		return dao.fetchCustomer();
	}
	@Override
	public void addCustomerDetails(Customer customer) {
	dao.addCustomerDetails(customer);
		
	}
	public Customer getCustomer(int id) {
		return dao.getCustomer(id);
		}
		public void updateCustomer(Customer customer) {
		dao.updateCustomer(customer);
		}
		@Override
		public void deleteCustomer(int id) {
			// TODO Auto-generated method stub
			dao.deleteCustomer(id);
		}

}
