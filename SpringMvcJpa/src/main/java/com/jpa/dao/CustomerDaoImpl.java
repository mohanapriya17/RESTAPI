package com.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.jpa.model.Customer;
@Repository
public class CustomerDaoImpl implements CustomerDao {
@PersistenceContext
EntityManager entityManager;
	@Override
	public List<Customer> fetchCustomer() {
		  return entityManager.createQuery("SELECT cust FROM Customer cust",Customer.class).getResultList();
	       
	}

	@Override
	public void addCustomerDetails(Customer customer) {
		// TODO Auto-generated method stub
		entityManager.persist(customer);
	}
	public Customer getCustomer(int id) {
		return entityManager.find(Customer.class, id);
		}
		public void updateCustomer(Customer customer) {
		entityManager.merge(customer);}

		@Override
		public void deleteCustomer(int id) {
			entityManager.createQuery("delete from Customer customer where customer.customerId=:id").setParameter("id", id).executeUpdate();
			
		}

}
