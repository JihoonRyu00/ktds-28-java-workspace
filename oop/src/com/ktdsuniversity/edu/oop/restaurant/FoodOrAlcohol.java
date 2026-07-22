package com.ktdsuniversity.edu.oop.restaurant;

public class FoodOrAlcohol {

	/** 포만감 */
	private final int satiety;
	/** 취기 */
	private final int inebriation;
	/** true: food, false: alcohol */
	private final boolean isFood;

	/** 음식명 */
	private String name;

	/**
	 * 생성자
	 * 
	 * @param satiety
	 * @param inebriation
	 * @param isFood
	 * @param name
	 */
	FoodOrAlcohol(int satiety, int inebriation, boolean isFood, String name) {
		this.satiety = satiety;
		this.inebriation = inebriation;
		this.isFood = isFood;
		this.name = name;
	}

	/**
	 * satiety Getter
	 * 
	 * @return
	 */
	public int getSatiety() {
		return this.satiety;
	}

	/**
	 * inebriation Getter
	 * 
	 * @return
	 */
	public int getInebriation() {
		return this.inebriation;
	}

	/**
	 * isFood Getter
	 * 
	 * @return
	 */
	public boolean getIsFood() {
		return this.isFood;
	}

	/**
	 * name Getter
	 * 
	 * @return
	 */
	public String getName() {
		return this.name;
	}
}