package com.ktdsuniversity.edu.oop.interfaces.mart;

public class VipCustomer extends Customer {

	public VipCustomer(String name, int balance, int age) {
		super(name, balance, age);
	}

	@Override
	public int calcTotalPrice() {
		int totalPrice = 0;
		int minPrice = Integer.MAX_VALUE;
		for (Product p : this.cartList) {
			if (p != null) {
				minPrice = Math.min(minPrice, p.getPrice());
				totalPrice += p.getPrice();
			}
		}
		return totalPrice - minPrice;
	}
}
