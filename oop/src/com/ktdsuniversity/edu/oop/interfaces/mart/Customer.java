package com.ktdsuniversity.edu.oop.interfaces.mart;

public class Customer implements CustomerInterface {

	private final static int MAX_LIST = 10;

	private String name;
	private int age;
	private int balance;
	protected Product[] cartList;

	public Customer(String name, int balance, int age) {
		this.name = name;
		this.balance = balance;
		this.age = age;
		this.cartList = new Product[MAX_LIST];
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

	public Product[] getCartList() {
		return this.cartList;
	}

	public String toString() {
		return "name: " + this.name + ", age: " + this.age + ", balance: " + this.balance;
	}

	@Override
	public void addProduct(Product product) {
		for (int i = 0; i < MAX_LIST; ++i) {
			if (cartList[i] == null) {
				cartList[i] = product;
				break;
			}
		}
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
