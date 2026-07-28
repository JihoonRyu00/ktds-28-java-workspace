package com.ktdsuniversity.edu.oop.interfaces.mart;

public class Mart {

	private final static int MAX_LIST = 10;

	private Product[] productList;

	public Mart() {
		this.productList = new Product[MAX_LIST];
	}

	public Product[] getProductList() {
		return this.productList;
	}

	public boolean returnBuyable(Customer customer) {
		for (Product p : customer.getCartList()) {
			if (p instanceof AlcoholProduct ap && customer.getAge() < ap.getAgeLimit()) {
				System.out.println("Under 19 years old customer cannot buy an Alcohol.");
				return false;
			}
		}
		return true;
	}

	public int returnTotalPrice(CustomerInterface customer) {
		return customer.calcTotalPrice();
	}
}
