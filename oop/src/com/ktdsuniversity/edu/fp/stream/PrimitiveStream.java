package com.ktdsuniversity.edu.fp.stream;

import java.util.IntSummaryStatistics;
import java.util.List;

import com.ktdsuniversity.edu.fp.objects.Dish;
import com.ktdsuniversity.edu.fp.objects.DishList;

public class PrimitiveStream {

	public static void printSumOf() {
		List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -1, -2, -3, -4, -5, -6, -7, -8, -10);
		int result = numbers.stream() // Stream<Integer>
				.mapToInt(num -> num) // IntStream
				.sum() // Integer
		;
		System.out.println(result);
	}

	public static void printMaxNum() {
		List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -1, -2, -3, -4, -5, -6, -7, -8, -10);
		int result = numbers.stream() // Stream<Integer>
				.mapToInt(num -> num) // IntStream
				.max() // OptionalInt
				.orElse(-1) // Integer
		;
		System.out.println(result);
	}

	public static void printMinNum() {
		List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -1, -2, -3, -4, -5, -6, -7, -8, -10);
		int result = numbers.stream() // Stream<Integer>
				.mapToInt(num -> num) // IntStream
				.min() // OptionalInt
				.orElse(-1) // Integer
		;
		System.out.println(result);
	}

	public static void printMinNumStr() {
		List<String> numbers = List.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "-1", "-2", "-3", "-4", "-5",
				"-6", "-7", "-8", "-10");
		int result = numbers.stream() // Stream<String>
				.mapToInt(Integer::parseInt) // IntStream
				.min() // OptionalInt
				.orElse(-1) // Integer
		;
		System.out.println(result);
	}

	public static void printSummaryStatistics() {
		List<Dish> dishes = DishList.makeDishList();
		IntSummaryStatistics result = dishes.stream() // Stream<Dish>
				.mapToInt(Dish::getCalories) // IntStream
				.summaryStatistics() // IntSummaryStatistics
//				.getSum() // long
		;
		long cnt = result.getCount();
		System.out.println(cnt);
		long sum = result.getCount();
		System.out.println(sum);
		double avg = result.getAverage();
		System.out.println(avg);
		double max = result.getMax();
		System.out.println(max);
		double min = result.getMax();
		System.out.println(min);
		String sumStat = result.toString();
		System.out.println(sumStat);
		System.out.println(result);
	}

	public static void printDishesAverageCalories() {
		List<Dish> dishes = DishList.makeDishList();

		double result = dishes.stream() // Stream<Dish>
				.mapToInt(Dish::getCalories) // IntStream
				.average() // OptionalDouble
				.orElse(0) // double
		;

//		double result = dishes.stream() // Stream<Dish>
//				.mapToInt(Dish::getCalories) // IntStream
//				.summaryStatistics() // IntSummaryStatistics
//				.getAverage() // long
//		;

		System.out.println(result);

		Integer[] result2 = dishes.stream() // Stream<Dish>
//				.mapToInt(Dish::getCalories)
				.map(dish -> new Integer[] { 0, dish.getCalories() }) // Stream<Integer[]>
				.reduce(new Integer[] { 0, 0 }, ((arr, curr) -> new Integer[] { arr[0] + 1, arr[1] + curr[1] })) // Integer[]
		;
		System.out.println(result2[1] / (double) result2[0]);
	}

	public static void main(String[] args) {

//		printSumOf();
//		printMaxNum();
//		printMinNum();
//		printMinNumStr();
//		printSummaryStatistics();
		printDishesAverageCalories();
	}
}
