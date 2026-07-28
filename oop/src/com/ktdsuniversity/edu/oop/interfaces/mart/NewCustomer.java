package com.ktdsuniversity.edu.oop.interfaces.mart;

public class NewCustomer extends Customer {

	public NewCustomer(String name, int balance, int age) {
		super(name, balance, age);
	}

	@Override
	public int calcTotalPrice() {
		int totalPrice = 0;
		for (Product p : this.cartList) {
			if (p != null) {
				totalPrice += p.getPrice();
			}
		}
		return (int) (totalPrice * 0.9);
	}
}
