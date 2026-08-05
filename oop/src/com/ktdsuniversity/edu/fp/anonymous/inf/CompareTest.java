package com.ktdsuniversity.edu.fp.anonymous.inf;

import com.ktdsuniversity.edu.fp.objects.Dish;
import com.ktdsuniversity.edu.fp.objects.enums.DishType;
import com.ktdsuniversity.edu.fp.objects.enums.FoodType;

public class CompareTest {

	public static void main(String[] args) {

		// Compare 인터페이스를 클래스 없이 인스턴스화한다.
		Dish dish1 = new Dish("메뉴1", FoodType.MEAT, 500, DishType.MEAT);
		Dish dish2 = new Dish("메뉴2", FoodType.VEGETABLES, 200, DishType.OTHER);
		Dish dish3 = new Dish("메뉴3", FoodType.MEAT, 700, DishType.FISH);

		Compare<DishType> dishCompare = new Compare<>() {
			@Override
			public boolean compareType(Dish dish, DishType type) {
				return dish.getDishType() == type;
			}
		};
		// dish1의 DishType이 OTHER인지
		System.out.println(dishCompare.compareType(dish1, DishType.OTHER));
		// dish1의 DishType이 MEAT인지
		System.out.println(dishCompare.compareType(dish1, DishType.MEAT));

		Compare<FoodType> foodCompare = new Compare<>() {
			@Override
			public boolean compareType(Dish dish, FoodType type) {
				return dish.getFoodType() == type;
			}
		};
		// dish1의 FoodType이 MEAT인지
		System.out.println(foodCompare.compareType(dish1, FoodType.MEAT));
		// dish1의 FoodType이 VEGETABLE인지
		System.out.println(foodCompare.compareType(dish1, FoodType.VEGETABLES));
	}
}
