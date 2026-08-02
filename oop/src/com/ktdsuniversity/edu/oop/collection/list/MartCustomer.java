package com.ktdsuniversity.edu.oop.collection.list;

import java.util.ArrayList;
import java.util.List;

import com.ktdsuniversity.edu.oop.interfaces.mart.Product;

public class MartCustomer implements CustomerInterface {

	private String name;
	private int age;
	private int balance;
	protected List<Product> cartList;

	public MartCustomer(String name, int balance, int age) {
		this.name = name;
		this.balance = balance;
		this.age = age;
		this.cartList = new ArrayList<>();
		System.out.println("Customer constructed. (" + this.toString() + ")");
	}

	public String getName() {
		return this.name;
	}

	public int getAge() {
		return this.age;
	}

	public int getBalance() {
		return this.balance;
	}

	public List<Product> getCartList() {
		return this.cartList;
	}

	public String toString() {
		return "name: " + this.name + ", age: " + this.age + ", balance: " + this.balance;
	}

	@Override
	public void addProduct(Product product) {
		this.cartList.add(product);
	}

	@Override
	public int calcTotalPrice() {
		int totalPrice = 0;
		for (Product p : this.cartList) {
			if (p != null) {
				totalPrice += p.getPrice();
			}
		}
		return totalPrice;
	}

	@Override
	public void buyRequest(Mart mart) {
		int totalPrice = 0;
		if (!mart.returnBuyable(this)) {
			System.out.println("Fail to buy.");
			return;
		}
		totalPrice = mart.returnTotalPrice(this);
		if (this.balance < totalPrice) {
			System.out.println("Out of budget.");
			return;
		}
		this.balance -= totalPrice;
		System.out.println("Success to buy. " + totalPrice + " charged.");
	}
}
