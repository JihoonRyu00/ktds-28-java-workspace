package com.ktdsuniversity.edu.fp.stream;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import com.ktdsuniversity.edu.fp.objects.Dish;
import com.ktdsuniversity.edu.fp.objects.DishList;
import com.ktdsuniversity.edu.fp.objects.enums.DishType;

/**
 * 스트립의 데이터를 변경시키는 Map 실습
 */
public class Mapping {

	private static final Comparator<? super Dish> Comparator = null;

	public static void printDouble() {
		List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		numbers.stream() // Stream<Integer>
				.map((n) -> 2 * n) // Stream<Integer>
				.forEach(System.out::println); // void
	}

	public static void printStrToInt() {
		List<String> strings = List.of("1234", "1231313", "6342648", "123415", "5351", "12441");
		strings.stream() // Stream<String>
				.map(Integer::parseInt) // Stream<Integer>
				.forEach(System.out::println); // void
	}

	public static void printStrToInt2() {
		List<String> strings = List.of("---12412414", "0", "000010", "-121321", "1234", "abs", "6342648", "123sdsd15",
				"5f1", "12441", "", "		");

//		numbers.stream() // Stream<String>
//				.filter((str) -> !(str.isEmpty() || str.isBlank())) // Stream<String>
//				.filter((str) -> str.matches("^-{0,1}[0-9]+$")) // Stream<String>
//				.map(Integer::parseInt) // Stream<Integer>
//				.forEach(System.out::println); // void

//		numbers.stream() // Stream<String>
//				.filter((str) -> {
//					try {
//						Integer.parseInt(str);
//						return true;
//					} catch (NumberFormatException nfe) {
//						return false;
//					}
//				}) // Stream<String>
//				.map(Integer::parseInt) // Stream<Integer>
//				.forEach(System.out::println); // void

		strings.stream() // Stream<String>
				.filter(Mapping::isStringIntFormat) // Stream<String>
				.map(Integer::parseInt) // Stream<Integer>
				.forEach(System.out::println); // void
	}

	public static boolean isStringIntFormat(String string) {
		try {
			Integer.parseInt(string);
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}

	public static void printMultiplesOf(int n) {
		List<String> strings = List.of("---12412414", "0", "000010", "-121321", "1234", "abs", "6342648", "123sdsd15",
				"5f1", "3666366", "", "		");

		strings.stream() // Stream<String>
				.filter(Mapping::isStringIntFormat) // Stream<String>
				.map(Integer::parseInt) // Stream<Integer>
				.filter(num -> num % n == 0) // Stream<Integer>
				.forEach(System.out::println); // void
	}

	public static void printFishDishesName() {
		List<Dish> dishes = DishList.makeDishList();
		dishes.stream() // Stream<Dish>
				.filter((dish) -> dish.getDishType() == DishType.FISH) // Stream<Dish>
				.map(dish -> dish.getName()) // Stream<String>
				.forEach(System.out::println); // void
	}

	public static void printUniqueDishTypeOfDishes() {
		List<Dish> dishes = DishList.makeDishList();
		dishes.stream() // Stream<Dish>
				.map(Dish::getDishType) // Stream<DishType>
				.distinct() // Stream<DishType>
				.forEach(System.out::println); // void
	}

	public static void printUniqueFoodTypeOfDishes() {
		List<Dish> dishes = DishList.makeDishList();
		dishes.stream() // Stream<Dish>
				.map(dish -> dish.getFoodType()) // Stream<FoodType>
				.distinct() // Stream<FoodType>
				.forEach(System.out::println); // void
	}

	public static void compareString() {
		String a = "이름";
		String b = "이름";

		System.out.println(a == b);
		Scanner sc = new Scanner(System.in);
		String c = sc.nextLine();
		String d = sc.nextLine();
		System.out.println(c == d);

		System.out.println(a == d);
		String e = "이" + "름";
		System.out.println(a == e);

		String f = "";
		String g = sc.nextLine();
		System.out.println(f == g);
	}

//	public static void printDishesByOrder() {
//		List<Dish> dishes = DishList.makeDishList();
//		dishes.stream() // Stream<Dish>
////				.sorted((dish1, dish2) -> dish2.getCalories() - dish1.getCalories()) // Stream<Dish>
//				.sorted((dish1, dish2) -> dish2.getName().compareTo(dish1.getName()))// Stream<Dish>
//				.forEach();
//	}

	public static void main(String[] args) {

//		printDouble();
//		printStrToInt();
//		printStrToInt2();
//		printMultiplesOf(3);
//		printFishDishesName();
//		printUniqueDishTypeOfDishes();
//		printUniqueFoodTypeOfDishes();
		compareString();
	}
}
