package com.ktdsuniversity.edu.oop.restaurant;

public class Alcohol {

	private final int satiety;
	private final int inebriation;

	Alcohol(int satiety, int inebriation) {
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
