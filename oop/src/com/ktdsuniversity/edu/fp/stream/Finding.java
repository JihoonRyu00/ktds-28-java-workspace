package com.ktdsuniversity.edu.fp.stream;

import java.util.ArrayList;
import java.util.List;

import com.ktdsuniversity.edu.fp.objects.Dish;
import com.ktdsuniversity.edu.fp.objects.DishList;
import com.ktdsuniversity.edu.fp.objects.enums.DishType;

/**
 * 스트림에서 하나의 값만 찾아 가져온다.
 */
public class Finding {

	public static void printFirstElement() {
		List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		int firstNumber = numbers.stream() // Stream<Integer>
				.findFirst() // Optional<Integer>
				.get() // Integer
		;
		System.out.println(firstNumber);
	}

	public static void printFistMulOf() {
		List<Integer> randNumbers = new ArrayList<>();
		for (int i = 0; i < 1_000_000; ++i) {
			randNumbers.add((int) (Math.random() * 100_000) + 1);
		}
		System.out.println(randNumbers);
		int n = (int) (Math.random() * 100_000) + 1;
//		int n = (int) (Math.random() * 100_000) + 1 + 100_000;
		System.out.println(n);
		int firstMulOf = randNumbers.stream() // Stream<Integer>
				.filter(num -> num % n == 0) // Stream<Integer>
				.findFirst() // Optional<Integer>
//				.get() // Integer
				.orElse(-42) // Integer
		;
		System.out.println(firstMulOf);
	}

	public static void printFistMulOf(int n) {
		List<Integer> randNumbers = new ArrayList<>();
		for (int i = 0; i < 1_000_000; ++i) {
			randNumbers.add((int) (Math.random() * 100_000) + 1);
		}
		System.out.println(randNumbers);
		int firstMulOf = randNumbers.stream() // Stream<Integer>
				.filter(num -> num % n == 0) // Stream<Integer>
				.findFirst() // Optional<Integer>
				.get() // Integer
		;
		System.out.println(firstMulOf);
	}

	public static void printAnyNumber() {
		List<Integer> randNumbers = new ArrayList<>();
		for (int i = 0; i < 10_000_000; ++i) {
			randNumbers.add((int) (Math.random() * 100_000) + 1);
		}
//		System.out.println(randNumbers);
//		for (int i = 0; i < 10; ++i) {
//			System.out.println(randNumbers.get(i));
//		}
//		randNumbers.stream().limit(10).forEach(System.out::println);
		int stream = randNumbers.stream().findAny().get();
		int pStream = randNumbers.parallelStream() // Stream<Integer>
				.findAny() // Optional<Integer>
				.orElse(-42) // Integer
		;
		System.out.println("stream findAny 결과: " + stream);
		System.out.println("parallelStream findAny 결과: " + pStream);
	}

	public static void printFirstFishDish() {
		List<Dish> dishes = DishList.makeDishList();
		Dish targetDish = dishes.stream() // Stream<Dish>
				.filter(dish -> dish.getDishType() == DishType.FISH) // Stream<Dish>
				.findFirst() // Optional<Dish>
				.orElse(null) // Dish
		;
		System.out.println(targetDish);
	}

	public static void printLowCalDish(int n) {
		List<Dish> dishes = DishList.makeDishList();
		dishes.stream().forEach(System.out::println);
		Dish targetDish = dishes.stream() // Stream<Dish>
				.filter(dish -> dish.getCalories() <= n) // Stream<Dish>
				.findFirst() // Optional<Dish>
				.orElse(null) // Dish
		;
		System.out.println("칼로리가 %d 이하인 첫번째 dish: %s".formatted(n, targetDish));
	}

	public static void main(String[] args) {

//		printFirstElement();
//		printFistMulOf(10000);
//		printFistMulOf();
//		printAnyNumber();
//		printFirstFishDish();
		printLowCalDish(0);
	}
}
