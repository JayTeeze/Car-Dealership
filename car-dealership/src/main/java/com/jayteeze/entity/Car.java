package com.jayteeze.entity;

public class Car {
	private String ownership;
	private int year;
	private String color;
	private String make;
	private String model;
	private double originalPrice;
	private String description;
	private int mileage;
	private double discountPrice;
	private boolean isOnSale = false;
	
	public Car() {};
	
	public Car(String ownership, int year, String color, String make, String model, double originalPrice, String description, int mileage) {
		this.ownership = ownership;
		this.year = year;
		this.color = color;
		this.make = make;
		this.model = model;
		this.originalPrice = originalPrice;
		this.description = description;
		this.mileage = mileage;
	}

	public String getOwnership() {
		return ownership;
	}
	
	public void setOwnership(String ownership) {
		this.ownership = ownership;
	}
	
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		if (!color.isEmpty()) {
			this.color = capitalCase(color);
		} else {
			this.color = color;
		}
	}
	
	public String getMake() {
		return make;
	}
	
	public void setMake(String make) {
		if (!make.isEmpty()) {
			this.make = capitalCase(make);
		} else {
			this.make = make;
		}
	}
	
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		if (!model.isEmpty()) {
			this.model = capitalCase(model);
		} else {
			this.model = model;
		}
	}
	
	public double getOriginalPrice() {
		return originalPrice;
	}
	
	public void setOriginalPrice(double originalPrice) {
		this.originalPrice = originalPrice;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	public double getDiscountPrice() {
		return Double.parseDouble(String.format("%.2f", discountPrice));
	}

	public void setDiscountPrice(double discountPrice) {
		this.discountPrice = discountPrice;
	}

	public boolean isOnSale() {
		return isOnSale;
	}

	public void setOnSale(boolean isOnSale) {
		this.isOnSale = isOnSale;
	}

	public String getOverview() {
		return ownership + " " + year + " " + make + " " + model;
	}
	
	public String getDetails() {
		return ownership + " " + year + " " + color + " " + make + " " + model + " " + mileage + " miles $" + originalPrice + " description: " + description;
	}
	
	private String capitalCase(String word) {
		String[] words = word.split(" ");
		word = "";
		
		for (int i = 0; i < words.length; i++) {
			words[i] = words[i].substring(0, 1).toUpperCase() + words[i].substring(1);
			word += words[i] + " ";
		}
		return word.trim();
	}
	
}