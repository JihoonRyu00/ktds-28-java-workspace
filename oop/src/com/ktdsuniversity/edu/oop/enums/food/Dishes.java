package com.ktdsuniversity.edu.oop.enums.food;

public class Dishes {

	public static void main(String[] args) {
		Food qCW = new Food("Quatro Cheese Whopper", 3000, FoodType.FAST_FOOD);
		Food beef = new Food("Wagyu", 600, FoodType.MEAT);
		Food pork = new Food("Handon", 700, FoodType.MEAT);
		Food salmon = new Food("Norway Salmon", 400, FoodType.FISH);
		Food olive = new Food("Extravirgin", 1000, FoodType.VEGE);
	}
}
