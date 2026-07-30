package com.ktdsuniversity.edu.oop.exceptions;

public class Goods {
	private String name;
	private int price;

	public Goods() {

	}

	public Goods(String name, int price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return this.name;
	}

	public int getPrice() {
		return this.price;
	}

	public String toString() {
		return this.getClass().getSimpleName() + "[name: " + name + ", price: " + price + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Goods other) {
			return this.name == other.getName() && this.price == other.getPrice();
		}
		return false;
	}

	public boolean equals(Goods other) {
		return this.name == other.getName() && this.price == other.getPrice();
	}

}