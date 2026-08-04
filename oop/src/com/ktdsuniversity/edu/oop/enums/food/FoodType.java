package com.ktdsuniversity.edu.oop.enums.food;

public enum FoodType {

	VEGE("채소"), FRUIT("과일"), MEAT("육류"), FISH("생선"), FAST_FOOD("패스트푸드");

	private String name;

	FoodType(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
}
