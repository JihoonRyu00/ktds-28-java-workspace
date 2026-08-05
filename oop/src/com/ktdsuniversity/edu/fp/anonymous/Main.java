package com.ktdsuniversity.edu.fp.anonymous;

import com.ktdsuniversity.edu.fp.anonymous.inf.Compare;
import com.ktdsuniversity.edu.fp.objects.Dish;
import com.ktdsuniversity.edu.fp.objects.enums.DishType;
import com.ktdsuniversity.edu.fp.objects.enums.FoodType;

public class Main {

	public static void main(String[] args) {
		DishSummary summary = new DishSummary();

//		summary.printAllDishes();
//		summary.printAllDishesBy(DishType.FISH);
//		summary.printAllDishesBy(DishType.MEAT);
//		summary.printAllDishesBy(DishType.OTHER);
//		summary.printAllDishesBy(FoodType.MEAT);
//		summary.printAllDishesBy(FoodType.VEGETABLES);
//
//		summary.printTotalCalories();
//		summary.printTotalCaloriesBy(DishType.FISH);
//		summary.printTotalCaloriesBy(DishType.MEAT);
//		summary.printTotalCaloriesBy(DishType.OTHER);
//		summary.printTotalCaloriesBy(FoodType.MEAT);
//		summary.printTotalCaloriesBy(FoodType.VEGETABLES);

//		summary.printAverageCalories();
//		summary.printAverageCaloriesBy(DishType.FISH);
//		summary.printAverageCaloriesBy(DishType.MEAT);
//		summary.printAverageCaloriesBy(DishType.OTHER);
//		summary.printAverageCaloriesBy(FoodType.MEAT);
//		summary.printAverageCaloriesBy(FoodType.VEGETABLES);

//		summary.printAllDishesBy(new Compare<DishType>() {
//			@Override
//			public boolean compareType(Dish dish, DishType type) {
//				return dish.getDishType() == type;
//			}
//		}, DishType.MEAT);
//
//		Compare<DishType> dishCompare = new Compare<>() {
//			@Override
//			public boolean compareType(Dish dish, DishType type) {
//				return dish.getDishType() == type;
//			}
//		};
//		summary.printAllDishesBy(dishCompare, DishType.FISH);
//		summary.printAllDishesBy(dishCompare, DishType.OTHER);
//
//		Compare<FoodType> foodCompare = new Compare<>() {
//			@Override
//			public boolean compareType(Dish dish, FoodType type) {
//				return dish.getFoodType() == type;
//			}
//		};
//		summary.printAllDishesBy(foodCompare, FoodType.MEAT);
//		summary.printAllDishesBy(foodCompare, FoodType.VEGETABLES);

		Compare<Void> voidCompare = new Compare<>() {
			@Override
			public boolean compareType(Dish dish, Void type) {
				return true;
			}
		};
		summary.printAllDishesBy(voidCompare, null);
	}
}
