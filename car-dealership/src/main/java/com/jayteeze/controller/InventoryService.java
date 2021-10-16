package com.jayteeze.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

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
	
	public void sortByAcquireDate() {
		Collections.sort(inventory, Transaction.AcqiuredDate);
	}
	
	public void updateEntry(Transaction updatedEntry) {
		
		System.out.println("in update entry method");
		System.out.println(updatedEntry.getCar().getModel());
		System.out.println(updatedEntry.getId());
		
		for (int i = 0; i < inventory.size(); i++) {
			if (inventory.get(i).getId() == updatedEntry.getId()) {
				
				System.out.println(inventory.get(i));
				
				inventory.set(i, updatedEntry);
				break;
			}
		}
	}
	
	public void deleteEntry(Integer transactionId) {
		if (!transactionId.equals(null)) {
			inventory.remove(entryById(transactionId));
		}
	}
	
	public Transaction entryById(Integer transactionId) {
		for (int i = 0; i < inventory.size(); i++) {
			if (inventory.get(i).getId() == transactionId.intValue()) {
				return inventory.get(i);
			}
		}
		return new Transaction();
	}
	
	// Only used to populate app
	public void populateApp() {
		if (isPopulated == false) {
			Car car1 = new Car("Used", 2015, "Black", "Honda", "Accord", 15499, "Great condition", 71200);
			Customer customer1 = new Customer("Candice", "Strazulla");
			Transaction transaction1 = new Transaction(1, LocalDate.of(2021, 5, 11), car1, customer1);
			inventory.add(transaction1);
			
			Car car2 = new Car("Used", 2018, "Blue", "Hyuandai", "Sonata", 16799, "Great condition", 38578);
			Customer customer2 = new Customer("Mark", "Johnson");
			Transaction transaction2 = new Transaction(2, LocalDate.of(2021, 7, 12), car2, customer2);
			inventory.add(transaction2);
			
			Car car3 = new Car("Used", 2020, "Black", "Toyota", "Tundra", 42499, "Great condition", 7988);
			Customer customer3 = new Customer("Adrian", "Blayne");
			Transaction transaction3 = new Transaction(3, LocalDate.of(2021, 10, 1), car3, customer3);
			inventory.add(transaction3);
			
			Car car4 = new Car("Used", 2019, "White", "Ford", "Fiesta", 11299, "Great condition", 16542);
			Customer customer4 = new Customer("Chris", "Flanigan");
			Transaction transaction4 = new Transaction(4, LocalDate.of(2020, 10, 8), car4, customer4);
			inventory.add(transaction4);
			
			Car car5 = new Car("Used", 2014, "Gray", "Nissan", "Maxima", 9999, "Great condition", 92002);
			Customer customer5 = new Customer("Christina", "Cardenas");
			Transaction transaction5 = new Transaction(5, LocalDate.of(2020, 10, 31), car5, customer5);
			inventory.add(transaction5);
			
			Car car6 = new Car("New", 2020, "Silver", "Ford", "Explorer", 36000, "Great condition", 807);
			Customer customer6 = new Customer("David", "Castle");
			Transaction transaction6 = new Transaction(6, LocalDate.of(2021, 10, 8), car6, customer6);
			inventory.add(transaction6);
			
			Car car7 = new Car("New", 2020, "Red", "Toyota", "Corolla", 23500, "Great condition", 602);
			Customer customer7 = new Customer("Josh", "Cole");
			Transaction transaction7 = new Transaction(7, LocalDate.of(2021, 9, 27), car7, customer7);
			inventory.add(transaction7);
			
			Car car8 = new Car("New", 2021, "Black", "Audi", "A3", 44999, "Great condition", 701);
			Customer customer8 = new Customer("Juan", "Palacio");
			Transaction transaction8 = new Transaction(8, LocalDate.of(2021, 10, 5), car8, customer8);
			inventory.add(transaction8);
			
			Car car9 = new Car("New", 2021, "Blue", "Ford", "Mustang", 31000, "Great condition", 211);
			Customer customer9 = new Customer("Chad", "Beasly");
			Transaction transaction9 = new Transaction(9, LocalDate.of(2021, 5, 3), car9, customer9);
			inventory.add(transaction9);
			
			Car car10 = new Car("New", 2020, "Green", "Chevrolet", "Suburban", 37000, "Great condition", 345);
			Customer customer10 = new Customer("Keisha", "Anderson");
			Transaction transaction10 = new Transaction(10, LocalDate.of(2021, 8, 22), car10, customer10);
			inventory.add(transaction10);
			
			sortByAcquireDate();
			isPopulated = true;
		}
		
	}

}
