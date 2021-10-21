package com.jayteeze.entity;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;

public class Transaction extends Car {
	private int id;
	private LocalDate acquireDate;
	private LocalDate soldDate;
	private long daysOnLot;
	private boolean isSold;
	
	public Transaction() {};
	
	public Transaction(int id, LocalDate acquireDate, String ownership, int year, 
			String color, String make, String model, int price, String description, int mileage) {
		super(ownership, year, color, make, model, price, description, mileage);
		this.id = id;
		this.acquireDate = acquireDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAcquireDate() {
		if (acquireDate == null) {
			acquireDate = LocalDate.now();
		}
		return acquireDate.toString();
	}
	
	public void setAcquireDate(String acquireDate) {
		if (acquireDate.isEmpty()) {
			this.acquireDate = null;
		} else {
			this.acquireDate = LocalDate.parse(acquireDate);
		}
	}
	
	public String getSoldDate() {
		if (soldDate != null) {
			return soldDate.toString();
		}
		return null;
	}
	
	public void setSoldDate(String soldDate) {
		if (!soldDate.isEmpty()) {
			this.soldDate = LocalDate.parse(soldDate);
		}
	}
	
	public long getDaysOnLot() {
		daysOnLot = acquireDate.until(LocalDate.now(), ChronoUnit.DAYS);
		return daysOnLot;
	}

	public void setDaysOnLot(long daysOnLot) {
		this.daysOnLot = daysOnLot;
	}
	
	public String getIsSold() {
		if (Boolean.valueOf(isSold == true)) {
			return "yes";
		} else {
			return "no";
		}
	}

	public void setIsSold(String isSold) {
		if (isSold.contains("yes")) {
			this.isSold = true;
		} else {
			this.isSold = false;
		}
	}
	
	public void placeBid() {
		setDiscountPrice(getDiscountPrice() + (getDiscountPrice() * .01));
	}

	Customer buyer;
	
	public Customer getBuyer() {
		return buyer;
	}

	public void setBuyer(Customer buyer) {
		this.buyer = buyer;
	}

	public static Comparator<Transaction> AcqiuredDate = new Comparator<Transaction>() {
		public int compare(Transaction t1, Transaction t2) {
			LocalDate date1 = LocalDate.parse(t1.getAcquireDate());
			LocalDate date2 = LocalDate.parse(t2.getAcquireDate());
			return date2.compareTo(date1);
		}
	};
	
	public static Comparator<Transaction> SellDate = new Comparator<Transaction>() {
		public int compare(Transaction t1, Transaction t2) {
			
			if (t1.getSoldDate() == null && t2.getSoldDate() == null) {
				return 0;
			} else if (t1.getSoldDate() != null && t2.getSoldDate() == null) {
				return -1;
			} else if (t1.getSoldDate() == null && t2.getSoldDate() != null) {
				return 1;
			} else {
				LocalDate date1 = LocalDate.parse(t1.getSoldDate());
				LocalDate date2 = LocalDate.parse(t2.getSoldDate());
				return date2.compareTo(date1);
			}
		}
	};
	
}