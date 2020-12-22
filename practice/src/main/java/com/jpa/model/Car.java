package com.jpa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="carDetails")
public class Car {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;
private String carName;
private int carPrice;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getCarName() {
	return carName;
}
public void setCarName(String carName) {
	this.carName = carName;
}
public int getCarPrice() {
	return carPrice;
}
public void setCarPrice(int carPrice) {
	this.carPrice = carPrice;
}
}
