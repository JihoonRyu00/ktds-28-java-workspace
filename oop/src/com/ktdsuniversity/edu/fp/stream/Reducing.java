package com.ktdsuniversity.edu.fp.stream;

import java.util.List;
import java.util.Optional;

import com.ktdsuniversity.edu.fp.objects.Dish;
import com.ktdsuniversity.edu.fp.objects.DishList;
import com.ktdsuniversity.edu.fp.objects.enums.DishType;

public class Reducing {

	public static void printSumOf() {
		List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		int result = numbers.stream() // Stream<Integer>
				.reduce(0, (temp, next) -> temp + next) // Integer
		;
		System.out.println(result);
	}

	public static void printMaxOf() {
		List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -1, -2, -3, -4, -5, -6, -7, -8, -10);
		int result = numbers.stream() // Stream<Integer>
				.reduce(Integer.MIN_VALUE, (temp, next) -> (temp > next) ? temp : next) // Integer
		;
		System.out.println(result);
	}

	public static void printMaxOfRef() {
		List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -1, -2, -3, -4, -5, -6, -7, -8, -10);
		Optional<Integer> result = numbers.stream() // Stream<Integer>
				.reduce(Math::max) // Optional<Integer>
		;
		System.out.println(result);
	}

	public static void printMinOfRef() {
		List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -1, -2, -3, -4, -5, -6, -7, -8, -10);
		Optional<Integer> result = numbers.stream() // Stream<Integer>
				.reduce(Math::min) // Optional<Integer>
		;
		System.out.println(result);
	}

	public static void printMaxCal() {
		List<Dish> dishes = DishList.makeDishList();
		Optional<Integer> result = dishes.stream() // Stream<Dish>
				.map(Dish::getCalories) // Stream<Integer>
				.reduce(Math::max);
		System.out.println(result);
	}

	public static void printMinCalAmongOther() {
		List<Dish> dishes = DishList.makeDishList();
		Optional<Integer> result = dishes.stream() // Stream<Dish>
				.filter(dish -> dish.getDishType() == DishType.OTHER) // Stream<Dish>
				.map(Dish::getCalories) // Stream<Integer>
				.reduce(Math::min);
		System.out.println(result);
	}

	public static void printLongestNameDish() {
		List<Dish> dishes = DishList.makeDishList();
		Optional<Dish> result = dishes.stream() // Stream<Dish>
				.reduce((temp, curr) -> (temp.getName().length() > curr.getName().length()) ? temp : curr) // Dish
		;
		System.out.println("이름이 가장 긴 dish:\n%s".formatted(result));
	}

	public static void a() {
		List<String> aaa = List.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
		String ss = aaa.stream().reduce("", String::concat);
		System.out.println(ss);
	}

	public static void main(String[] args) {
//		printSumOf();
//		printMaxOf();
//		printMaxCal();
//		printMinCalAmongOther();
//		printLongestNameDish();
		a();
	}
}
