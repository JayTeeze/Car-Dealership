package com.jayteeze.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

import org.springframework.stereotype.Service;

import com.jayteeze.entity.Transaction;

@Service
public class InventoryService {
	
	// Only used to populate app
	private boolean isPopulated = false;
	
	private ArrayList<Transaction> inventory = new ArrayList<Transaction>();

	public ArrayList<Transaction> getInventory() {
		updatePrices();
		return inventory;
	}

	public void setInventory(ArrayList<Transaction> inventory) {
		this.inventory = inventory;
	}
	
	// Updates prices for vehicles that are on lot longer than 120 days
	public void updatePrices() {
		for (int i = 0; i < inventory.size(); i++) {
			if (inventory.get(i).getDaysOnLot() > 120 && inventory.get(i).isOnSale() == false) {
				inventory.get(i).setOnSale(true);
				inventory.get(i).setDiscountPrice(inventory.get(i).getOriginalPrice() * .9);
			}
		}
	}
	
	public void addToInventory(Transaction newEntry) {
		inventory.add(newEntry);
	}
	
	public void updateEntry(Transaction updatedEntry) {
		// Saves existing affiliated images
		for (int i = 0; i < inventory.size(); i++) {
			if (inventory.get(i).getId() == updatedEntry.getId()) {
				updatedEntry.setImgPath(inventory.get(i).getImgPath());
				inventory.set(i, updatedEntry);
				break;
			}
		}
	}
	
	public void deleteEntry(Integer transactionId) {
		if (!transactionId.equals(null)) {
			inventory.remove(findById(transactionId));
		}
	}
	
	public Transaction findById(Integer transactionId) {
		for (int i = 0; i < inventory.size(); i++) {
			if (inventory.get(i).getId() == transactionId.intValue()) {
				return inventory.get(i);
			}
		}
		return new Transaction();
	}
	
	public ArrayList <Transaction> findByKeyword(String keyword){
		int index = 0;
		ArrayList <Transaction> searchResults = new ArrayList<Transaction>();
		for (int i = 0; i < inventory.size(); i++) {
			if (inventory.get(i).getIsSold().contains("No") && inventory.get(i).getDetails().toUpperCase().contains(keyword.toUpperCase())) {
				searchResults.add(inventory.get(i));
				searchResults.get(index).setImgPath("../" + searchResults.get(index).getImgPath());
				index++;
			}
		}
		return searchResults;
	}
	
	public ArrayList<Transaction> forSale() {
		updatePrices();
		ArrayList<Transaction> carsForSale = new ArrayList<Transaction>();
		
		for (int i = 0; i < inventory.size(); i++) {
			if (inventory.get(i).getIsSold().contains("No")) {
				carsForSale.add(inventory.get(i));
			}
		}
		
		return carsForSale;
	}
	
	public int getNewIdNumber() {
		int latestId = 0;
		
		if (inventory == null) {
			return 1;
		}
		
		for (int i = 0; i < inventory.size(); i++) {
			if (inventory.get(i).getId() > latestId) {
				latestId = inventory.get(i).getId();
			}
		}
		return latestId + 1;
	}
	
	public ArrayList<Transaction> allTransactions() {
		ArrayList <Transaction> transactions = inventory;
		Collections.sort(transactions, Transaction.SellDate);
		return transactions;
	}
	
	// Only used to populate app
	public void populateApp() {
		if (isPopulated == false) {
			Transaction transaction1 = new Transaction(1, LocalDate.of(2021, 5, 11), "Used", 2015, "Black", "Honda", "Accord", 15499, "Great condition", 71200, "images/id1image1.jpg");
			inventory.add(transaction1);
			
			Transaction transaction2 = new Transaction(2, LocalDate.of(2021, 7, 12), "Used", 2018, "Blue", "Hyuandai", "Sonata", 16799, "Great condition", 38578, "images/id2image1.png");
			inventory.add(transaction2);
			
			Transaction transaction3 = new Transaction(3, LocalDate.of(2021, 10, 1), "Used", 2020, "Black", "Toyota", "Tundra", 42499, "Great condition", 7988, "images/id3image1.jpg");
			inventory.add(transaction3);
			
			Transaction transaction4 = new Transaction(4, LocalDate.of(2020, 10, 8), "Used", 2019, "White", "Ford", "Fiesta", 11299, "Great condition", 16542, "images/id4image1.png");
			inventory.add(transaction4);
			
			Transaction transaction5 = new Transaction(5, LocalDate.of(2020, 10, 31), "Used", 2014, "Gray", "Nissan", "Maxima", 9999, "Great condition", 92002, "images/id5image1.jpg");
			inventory.add(transaction5);
			
			Transaction transaction6 = new Transaction(6, LocalDate.of(2021, 10, 8), "New", 2020, "Silver", "Ford", "Explorer", 36000, "Great condition", 807, "images/id6image1.jpg");
			inventory.add(transaction6);
			
			Transaction transaction7 = new Transaction(7, LocalDate.of(2021, 9, 27), "New", 2020, "Red", "Toyota", "Corolla", 23500, "Great condition", 602, "images/id7image1.png");
			inventory.add(transaction7);
			
			Transaction transaction8 = new Transaction(8, LocalDate.of(2021, 10, 5), "New", 2021, "Black", "Audi", "A3", 44999, "Great condition", 701, "images/id8image1.jpg");
			inventory.add(transaction8);
			
			Transaction transaction9 = new Transaction(9, LocalDate.of(2021, 5, 3), "New", 2021, "Blue", "Ford", "Mustang", 31000, "Great condition", 211, "images/id9image1.jpg");
			inventory.add(transaction9);
			
			Transaction transaction10 = new Transaction(10, LocalDate.of(2021, 8, 22), "New", 2020, "Green", "Chevrolet", "Suburban", 37000, "Great condition", 345, "images/id10image1.jpg");
			inventory.add(transaction10);
			
			Collections.sort(inventory, Transaction.AcqiuredDate);
			isPopulated = true;
		}
		
	}

}
