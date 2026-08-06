package com.ktdsuniversity.edu.fp.stream;

import java.util.Comparator;
import java.util.List;

import com.ktdsuniversity.edu.fp.objects.Dish;
import com.ktdsuniversity.edu.fp.objects.DishList;
import com.ktdsuniversity.edu.fp.objects.enums.DishType;
import com.ktdsuniversity.edu.fp.objects.enums.FoodType;

/**
 * 리스트 인스턴스를 스트림 인스턴스로 변환하여 필요한 데이터만 추출하는 실습
 */
public class Filtering {

	public static void printLowCalDishes() {
		List<Dish> dishes = DishList.makeDishList();
		dishes.stream() // Stream<Dish>
				.filter((dish) -> dish.getCalories() <= 400) // Stream<Dish>
				.forEach(System.out::println); // void
	}

	public static void printHighCalDishes() {
		List<Dish> dishes = DishList.makeDishList();
		dishes.stream() // Stream<Dish>
				.filter((dish) -> dish.getCalories() >= 800) // Stream<Dish>
				.forEach(System.out::println); // void
	}

	public static void printFishDishes() {
		List<Dish> dishes = DishList.makeDishList();
		dishes.stream() // Stream<Dish>
				.filter((dish) -> dish.getDishType() == DishType.FISH) // Stream<Dish>
				.forEach(System.out::println); // void
	}

	public static void printMeatDishes() {
		List<Dish> dishes = DishList.makeDishList();
		dishes.stream() // Stream<Dish>
				.filter((dish) -> dish.getFoodType() == FoodType.MEAT) // Stream<Dish>
				.forEach(System.out::println); // void
	}

	public static void printVegeDishes() {
		List<Dish> dishes = DishList.makeDishList();
		dishes.stream() // Stream<Dish>
				.filter((dish) -> dish.getFoodType() == FoodType.VEGETABLES) // Stream<Dish>
				.forEach(System.out::println); // void
	}

	public static void printLowCalFishDishes() {
		List<Dish> dishes = DishList.makeDishList();
		dishes.stream() // Stream<Dish>
				.filter((dish) -> dish.getDishType() == DishType.FISH) // Stream<Dish>
				.filter((fishDish) -> fishDish.getCalories() <= 400) // Stream<Dish>
				.forEach(System.out::println); // void
	}

	public static void main(String[] args) {

//		printVegeDishes();
//		printFishDishes();
//		printMeatDishes();
//		printLowCalDishes();
//		printHighCalDishes();
		printLowCalFishDishes();
	}
}
