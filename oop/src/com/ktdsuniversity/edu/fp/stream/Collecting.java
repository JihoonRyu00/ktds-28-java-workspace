package com.ktdsuniversity.edu.fp.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.ktdsuniversity.edu.fp.objects.Dish;
import com.ktdsuniversity.edu.fp.objects.DishList;
import com.ktdsuniversity.edu.fp.objects.enums.DishType;
import com.ktdsuniversity.edu.fp.objects.enums.FoodType;

public class Collecting {

	public static List<Integer> getEvenList(List<Integer> intList) {
		return intList.stream() // Stream<Integer>
				.filter(num -> num % 2 == 0) // Stream<Integer>
				.collect(Collectors.toList()) // <List<Integer>, Object>
		;
	}

	public static List<Integer> getOrderedList(List<Integer> intList) {
		return intList.stream() // Stream<Integer>
				.sorted() // Stream<Integer>
				.collect(Collectors.toList()) // <List<Integer>, Object>
		;
	}

	public static List<Integer> getDescendingList(List<Integer> intList) {
		return intList.stream() // Stream<Integer>
				.sorted((n1, n2) -> n2 - n1) // Stream<Integer>
				.collect(Collectors.toList()) // <List<Integer>, Object>
		;
	}

	public static Dish getMaxCalDish() {
		List<Dish> dishes = DishList.makeDishList();
		return dishes.stream() // Stream<Dishes>
				.collect(Collectors.maxBy((d1, d2) -> d1.getCalories() - d2.getCalories())) // Optional<Dish>
				.orElse(null) // Dish
		;
	}

	public static Dish getMinCalDish() {
		List<Dish> dishes = DishList.makeDishList();
		return dishes.stream() // Stream<Dishes>
//				.collect(Collectors.minBy((d1, d2) -> d1.getCalories() - d2.getCalories())) // Optional<Dish>
				.collect(Collectors.maxBy((d1, d2) -> d2.getCalories() - d1.getCalories())) // Optional<Dish>
				.orElse(null) // Dish
		;
	}

	public static String concatStrings(List<String> strings, String sep) {
//		return strings.stream() // Stream<String>
//				.reduce("", (s1, s2) -> s1 + sep + s2) // String
//		;
		return strings.stream() // Stream<String>
				.collect(Collectors.joining(sep)) // String
		;
	}

	// 메뉴의 이름들을 구분자 ", "로 출력
	public static void printDishNames() {
		List<Dish> dishes = DishList.makeDishList();
		System.out.println(dishes.stream() // Stream<Dishes>
				.map(Dish::getName) // Stream<String>
				.reduce("", (s1, s2) -> s1 + ", " + s2) // String
//				.collect(Collectors.joining(", ")) // String
		);
	}

	// 메뉴의 이름들을 칼로리 오름차순으로 구분자 " -> "로 출력
	public static void printDishNamesByCalOrder() {
		List<Dish> dishes = DishList.makeDishList();
		System.out.println(dishes.stream() // Stream<Dishes>
				.sorted((d1, d2) -> d1.getCalories() - d2.getCalories()) // Stream<Dishes>
				.map(Dish::getName) // Stream<String>
				.reduce("", (s1, s2) -> s1 + " -> " + s2) // String
//				.collect(Collectors.joining(" -> ")) // String
		);
	}

	// 메뉴의 칼로리들을 칼로리 내림차순으로 구분자 " -> "로 출력
	public static void printDishCalsByCalOrder() {
		List<Dish> dishes = DishList.makeDishList();
		System.out.println(dishes.stream() // Stream<Dishes>
				.sorted((d1, d2) -> -d1.getCalories() + d2.getCalories()) // Stream<Dishes>
				.map(Dish::getCalories) // Stream<Integer>
				.map(s -> s + "") // Stream<String>
				.reduce("", (s1, s2) -> s1 + " -> " + s2) // String
//				.collect(Collectors.joining(" -> ")) // String
				
		);
	}

	public static void printDishTypeGroups() {
		List<Dish> dishes = DishList.makeDishList();
		Map<DishType, List<Dish>> dishTypeMap = dishes.stream() // Stream<Dishes>
				.collect(Collectors.groupingBy(Dish::getDishType)) // Map<DishType, List<Dish>>
		;
		System.out.println(dishTypeMap.toString().replaceAll("\\]\\], ", "\\]\\], \n"));
		dishTypeMap.forEach((k, v) -> {
			System.out.println("=".repeat(20) + k + "=".repeat(20));
			v.forEach(System.out::println);
		});
	}

	public static void printFoodTypeGroups() {
		List<Dish> dishes = DishList.makeDishList();
		Map<FoodType, List<Dish>> foodTypeMap = dishes.stream() // Stream<Dishes>
				.collect(Collectors.groupingBy(Dish::getFoodType)) // Map<FoodType, List<Dish>>
		;
		System.out.println(foodTypeMap.toString().replaceAll("\\]\\], ", "\\]\\], \n"));
		foodTypeMap.forEach((k, v) -> {
			System.out.println("=".repeat(20) + k + "=".repeat(20));
			v.forEach(System.out::println);
		});
	}

	public static void printCalGroups() {
		// 400 이하 => DIET
		// 700 이하 => NORMAL
		// 700 초과 => FAT
		List<Dish> dishes = DishList.makeDishList();
		Map<String, List<Dish>> calRangeMap = dishes.stream() // Stream<Dishes>
				.collect(Collectors.groupingBy(dish -> {
					int cal = dish.getCalories();
					if (cal <= 400) {
						return "DIET";
					}
					if (cal <= 700) {
						return "NORMAL";
					}
					return "FAT";
				})) // Map<String, List<Dish>>
		;
		System.out.println(calRangeMap.toString().replaceAll("\\]\\], ", "\\]\\], \n"));
		calRangeMap.forEach((k, v) -> {
			System.out.println("=".repeat(20) + k + "=".repeat(20));
			v.forEach(System.out::println);
		});
	}

	public static void main(String[] args) {

//		List<Integer> evenList = getEvenList(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
//		evenList.forEach(n -> System.out.print(n + " "));
//
//		System.out.println();
//
//		List<Integer> orderedList = getOrderedList(List.of(1324, 36, 3, -14, 5, 282, 34, -23125, 4, 36));
//		orderedList.forEach(n -> System.out.print(n + " "));
//
//		System.out.println();
//
//		List<Integer> descendingdList = getDescendingList(List.of(1324, 36, 3, -14, 5, 282, 34, -23125, 4, 36));
//		descendingdList.forEach(n -> System.out.print(n + " "));
//
//		System.out.println();
//
//		System.out.println(getMaxCalDish());
//		System.out.println(getMinCalDish());
//		System.out.println(concatStrings(List.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "10"), " "));

//		printDishNames();
//		System.out.println();
//		printDishNamesByCalOrder();
//		System.out.println();
//		printDishCalsByCalOrder();

//		printDishTypeGroups();
//		printFoodTypeGroups();
		printCalGroups();
	}
}
