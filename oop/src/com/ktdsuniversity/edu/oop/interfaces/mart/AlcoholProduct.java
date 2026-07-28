package com.ktdsuniversity.edu.oop.interfaces.mart;

public class AlcoholProduct extends Product {
	private final int AGE_LIMIT = 19;
	private float abv;

	public AlcoholProduct(String name, int price, float abv) {
		super(name, price);
		this.abv = abv;
	}

	public int getAgeLimit() {
		return AGE_LIMIT;
	}

	public float getAbv() {
		return abv;
	}

	@Override
	public String toString() {
		return super.toString() + ", age limit: " + this.AGE_LIMIT + ", abv: " + this.abv;
	}
}
