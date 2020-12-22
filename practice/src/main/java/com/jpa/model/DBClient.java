package com.jpa.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBClient {
  public static void main(String[]args) {
	  EntityManagerFactory emf=Persistence.createEntityManagerFactory("cars-pu");
	  EntityManager em=emf.createEntityManager();
	  em.getTransaction().begin();
	  Car car=new Car();
	  car.setCarName("audi");
	  car.setCarPrice(1000);
	  car.setId(1);
	  em.persist(car);
	  em.getTransaction().commit();
	  System.out.println("Inserted successfully");
  }
}
