package com.jayteeze.entity;

import java.time.LocalDate;

public class Transaction {
	private int id;
	private LocalDate acquireDate;
	private LocalDate soldDate;
	
	public Transaction() {};
	
	public Transaction(int id, LocalDate acquireDate, Car car, Customer customer) {
		this.id = id;
		this.acquireDate = acquireDate;
		this.car = car;
		this.customer = customer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getAcquireDate() {
		return acquireDate;
	}
	
	public void setAcquireDate(LocalDate acquireDate) {
		this.acquireDate = acquireDate;
	}
	
	public LocalDate getSoldDate() {
		return soldDate;
	}
	
	public void setSoldDate(LocalDate soldDate) {
		this.soldDate = soldDate;
	}
	
	Car car = new Car();
	Customer customer = new Customer();
	
	public Car getCar() {
		return car;
	}
	
	public void setCar(Car car) {
		this.car = car;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}