package com.ktdsuniversity.edu.fp.objects;

import java.util.List;

import com.ktdsuniversity.edu.fp.objects.enums.DishType;
import com.ktdsuniversity.edu.fp.objects.enums.FoodType;

public abstract class DishList {

	private DishList() { }
	
	public static List<Dish> makeDishList() {
		return List.of( 
			new Dish("돼지고기", FoodType.MEAT, 800, DishType.MEAT), 
			new Dish("소고기", FoodType.MEAT, 700, DishType.MEAT), 
			new Dish("치킨", FoodType.MEAT, 400, DishType.MEAT), 
			new Dish("프렌치 프라이", FoodType.VEGETABLES, 530, DishType.OTHER), 
			new Dish("쌀밥", FoodType.VEGETABLES, 350, DishType.OTHER), 
			new Dish("계절 과일", FoodType.VEGETABLES, 120, DishType.OTHER), 
			new Dish("피자", FoodType.VEGETABLES, 550, DishType.OTHER), 
			new Dish("새우", FoodType.MEAT, 300, DishType.FISH), 
			new Dish("연어", FoodType.MEAT, 450, DishType.FISH)
		);
	}
	
}
