package com.ktdsuniversity.edu.oop.inheritance.contact;

public class Contact {

	private String name;
	private String phoneNumber;
	protected int P = 1;

	public Contact(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return this.name;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void printContact() {
		System.out.println("name: " + this.name);
		System.out.println("phone number: " + this.phoneNumber);
	}
}
