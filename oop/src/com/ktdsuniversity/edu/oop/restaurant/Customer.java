package com.ktdsuniversity.edu.oop.restaurant;

public class Customer {

	private final int MAX_SATIETY = 100;
	private final int MAX_INEBRIATION = 65;

	private int age;
	private int satietyLevel;
	private int inebriationLevel;

	public Customer(int age, int satietyLevel, int inebriationLevel) {
		this.age = age;
		this.satietyLevel = satietyLevel;
		this.inebriationLevel = inebriationLevel;
	}

	public int getMAX_SATIETY() {
		return MAX_SATIETY;
	}

	public int getMAX_INEBRIATION() {
		return MAX_INEBRIATION;
	}

	public int getAge() {
		return age;
	}

	public int getSatietyLevel() {
		return satietyLevel;
	}

	public int getInebriationLevel() {
		return inebriationLevel;
	}

	public boolean isAdult() {
		return age >= 19;
	}

	public void eatFood(Food food) {
		if (this.satietyLevel >= 100) {
			System.out.println("");
			return;
		}
		this.satietyLevel += food.getSatiety();
		this.inebriationLevel += food.getInebriation();
	}

	public void drinkLiquor(Alcohol alcohol) {
		if (!isAdult()) {
			System.out.println("");
			return;
		}
		if (this.inebriationLevel >= 68) {
			System.out.println("");
			return;
		}
		this.satietyLevel += alcohol.getSatiety();
		this.inebriationLevel += alcohol.getInebriation();
	}

}
