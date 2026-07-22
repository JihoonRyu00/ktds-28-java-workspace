package com.ktdsuniversity.edu.oop.restaurant;

public class Food {

	private final int satiety;
	private final int inebriation;

	Food(int satiety, int inebriation) {
		this.satiety = satiety;
		this.inebriation = inebriation;
	}

	public int getSatiety() {
		return satiety;
	}

	public int getInebriation() {
		return inebriation;
	}
}
