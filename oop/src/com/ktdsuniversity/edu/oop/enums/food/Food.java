package com.ktdsuniversity.edu.oop.enums.food;

public class Food {

	private String name;
	private int calories;
	/**
	 * 0: 채소 1: 과일 2: 고기 3: 생선 4: 패스트푸드
	 */
	private FoodType type;

	public Food(String name, int calories, FoodType type) {
		this.name = name;
		this.calories = calories;
		this.type = type;
		System.out.println(this + " has made.");
	}

	@Override
	public String toString() {
		return "Food [name=" + this.name + ", calories=" + this.calories + ", type=" + this.type + "]";
	}
}
