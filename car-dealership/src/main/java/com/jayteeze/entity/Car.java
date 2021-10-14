package com.jayteeze.entity;

public class Car {
	private String ownership;
	private int year;
	private String color;
	private String make;
	private String model;
	private int price;
	private String description;
	
	public Car() {};
	
	public Car(String ownership, int year, String color, String make, String model, int price, String description) {
		this.ownership = ownership;
		this.year = year;
		this.color = color;
		this.make = make;
		this.model = model;
		this.price = price;
		this.description = description;
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
		this.color = color;
	}
	
	public String getMake() {
		return make;
	}
	
	public void setMake(String make) {
		this.make = make;
	}
	
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getOverview() {
		return ownership + " " + year + " " + make + " " + model;
	}
	
}