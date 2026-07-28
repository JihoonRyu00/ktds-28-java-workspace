package com.ktdsuniversity.edu.oop.interfaces.mart;

public class FreshProduct extends Product {

	private String dueDate;
	private float storageTemperature;

	public FreshProduct(String name, int price, String dueDate, float storageTemperature) {
		super(name, price);
		this.dueDate = dueDate;
		this.storageTemperature = storageTemperature;
		System.out.println("Product constructed. (" + this.toString() + ")");
	}

	public String getDueDate() {
		return this.dueDate;
	}

	public float getStorageTemperature() {
		return this.storageTemperature;
	}

	@Override
	public String toString() {
		return super.toString() + ", due date: " + this.dueDate + ", storage temperature: " + this.storageTemperature;
	}
}
