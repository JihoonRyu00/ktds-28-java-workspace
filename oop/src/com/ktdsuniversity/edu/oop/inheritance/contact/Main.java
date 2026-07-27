package com.ktdsuniversity.edu.oop.inheritance.contact;

public class Main {

	public static void printNameAndPN(Contact contact) {
		System.out.println(contact.getName());
		System.out.println(contact.getPhoneNumber());
	}

	public static void main(String[] args) {

//		Contact con = new EmailContact("q", "a", "a");
//		con.printContact();
//		con = (EmailContact) con;
		
		Contact con = new Contact(null, null);
		printNameAndPN(con);
		System.out.println(con.toString());
		System.out.println(con.P);

		EmailContact econ = new EmailContact(null, null, null);
		printNameAndPN(econ);
		System.out.println(econ.toString());
		econ.onlyForEC();
		System.out.println(econ.P);
		System.out.println(econ.getClass().getName());
		System.out.println(econ.getClass().getSuperclass().getName());

		Contact eecon = new EmailContact(null, null, null);
		printNameAndPN(eecon);
		System.out.println(eecon.toString());
//		eecon.onlyForEC();
		System.out.println(eecon instanceof Contact);
		System.out.println(eecon instanceof EmailContact);
	}
}
