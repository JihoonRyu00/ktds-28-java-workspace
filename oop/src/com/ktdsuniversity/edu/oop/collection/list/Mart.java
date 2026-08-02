package com.ktdsuniversity.edu.oop.collection.list;

import java.util.ArrayList;
import java.util.List;

import com.ktdsuniversity.edu.oop.interfaces.mart.AlcoholProduct;
import com.ktdsuniversity.edu.oop.interfaces.mart.Product;

public class Mart {

	private List<Product> productList;

	public Mart() {
		this.productList = new ArrayList<>();
	}

	public List<Product> getProductList() {
		return this.productList;
	}

	public boolean returnBuyable(MartCustomer customer) {
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
