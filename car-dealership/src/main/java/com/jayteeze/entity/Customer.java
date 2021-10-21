package com.jayteeze.entity;

public class Customer {
	
	private String firstName;
	private String lastName;
	
	public Customer() {};
	
	public Customer(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		if (!firstName.isEmpty()) {
			this.firstName = capitalCase(firstName);
		} else {
			this.firstName = "";
		}
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		if (!lastName.isEmpty()) {
			this.lastName = capitalCase(lastName);
		} else {
			this.lastName = "";
		}
	}

	public String getFullName() {
		return firstName + " " + lastName;
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
