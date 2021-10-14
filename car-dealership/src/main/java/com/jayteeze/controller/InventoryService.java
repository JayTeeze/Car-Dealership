package com.jayteeze.controller;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.jayteeze.entity.Car;
import com.jayteeze.entity.Customer;
import com.jayteeze.entity.Transaction;

@Service
public class InventoryService {
	
	private ArrayList<Transaction> inventory = new ArrayList<Transaction>();
	// Only used to populate app
	private boolean isPopulated = false;

	public ArrayList<Transaction> getInventory() {
		return inventory;
	}

	public void setInventory(ArrayList<Transaction> inventory) {
		this.inventory = inventory;
	}
	
	public void saveTransaction(Transaction save) {
		inventory.add(save);
	}
	
	// Only used to populate app
	public void populateApp() {
		if (isPopulated == false) {
			Car car1 = new Car("Used", 2015, "Black", "Honda", "Accord", 15499, "Great condition");
			Customer customer1 = new Customer("John", "Doe");
			Transaction transaction1 = new Transaction(1, LocalDate.of(2021, 5, 11), car1, customer1);
			inventory.add(transaction1);
			
			Car car2 = new Car("Used", 2018, "Blue", "Hyuandai", "Sonata", 16799, "Great condition");
			Customer customer2 = new Customer("Mark", "Johnson");
			Transaction transaction2 = new Transaction(2, LocalDate.of(2021, 7, 12), car2, customer2);
			inventory.add(transaction2);
			
			Car car3 = new Car("Used", 2020, "Black", "Toyota", "Tundra", 42499, "Great condition");
			Customer customer3 = new Customer("Adrian", "Blayne");
			Transaction transaction3 = new Transaction(3, LocalDate.of(2021, 10, 1), car3, customer3);
			inventory.add(transaction3);
			
			Car car4 = new Car("Used", 2019, "White", "Ford", "Fiesta", 11299, "Great condition");
			Customer customer4 = new Customer("Chris", "Flanigan");
			Transaction transaction4 = new Transaction(4, LocalDate.of(2020, 10, 8), car4, customer4);
			inventory.add(transaction4);
			
			Car car5 = new Car("Used", 2014, "Gray", "Nissan", "Sentra", 9999, "Great condition");
			Customer customer5 = new Customer("Christina", "Cardenas");
			Transaction transaction5 = new Transaction(5, LocalDate.of(2020, 10, 31), car5, customer5);
			inventory.add(transaction5);
			
			isPopulated = true;
		}
		
	}

}
