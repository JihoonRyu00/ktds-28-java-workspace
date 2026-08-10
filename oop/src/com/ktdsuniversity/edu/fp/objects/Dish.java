package com.ktdsuniversity.edu.fp.objects;

import com.ktdsuniversity.edu.fp.objects.enums.DishType;
import com.ktdsuniversity.edu.fp.objects.enums.FoodType;

public class Dish {

	private final String name;
	private final FoodType foodType;
	private final int calories;
	private final DishType dishType;

	public Dish(String name, FoodType foodType, int calories, DishType type) {
		this.name = name;
		this.foodType = foodType;
		this.calories = calories;
		this.dishType = type;
	}

	public String getName() {
		return this.name;
	}

	public FoodType getFoodType() {
		return this.foodType;
	}

	public int getCalories() {
		return this.calories;
	}

	public DishType getDishType() {
		return this.dishType;
	}

	@Override
	public String toString() {
		return "Dish [name=" + this.name + ", foodType=" + this.foodType + ", calories=" + this.calories + ", dishType="
				+ this.dishType + "]";
	}

	public static void main(String[] args) {
		Dish dish = new Dish("돼지고기", FoodType.MEAT, 800, DishType.MEAT);
		System.out.println(dish);
		System.out.println("sdas");
	}
}
