package com.ktdsuniversity.edu.oop.inheritance.contact;

public class EmailContact extends Contact {

	private String emailAddress;

	public EmailContact(String name, String phoneNumber, String emailAddress) {
		super(name, phoneNumber);
		this.emailAddress = emailAddress;
	}

	public String getEmailAddress() {
		return this.emailAddress;
	}

	public void printContact() {
		super.printContact();
		System.out.println("email address: " + this.emailAddress);
	}

	public void onlyForEC() {
//		System.out.println(this.name);
		System.out.println(this.getName());
	}
}
