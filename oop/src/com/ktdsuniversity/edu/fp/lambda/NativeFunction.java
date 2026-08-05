package com.ktdsuniversity.edu.fp.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class NativeFunction {

	public static void main(String[] args) {
		// Predicate<T> : (T) -> boolean
		Predicate<String> isEmpty = (str) -> str == null || str.isBlank();
		System.out.println(isEmpty.test(""));
		// Consumer<T> : (T) -> void
		Consumer<String> print = (str) -> System.out.println(str); // void도 타입이므로 타입이 같아 중괄호 생략 가능
		print.accept("Ayyyy");
		// Function<T, R> : (T) -> R
		Function<String, Integer> getLength = (str) -> str.length();
		System.out.println(getLength.apply("asassasasasas"));

		Function<String, Integer> strToInt = (str) -> Integer.parseInt(str);
		System.out.println(strToInt.apply("1212121212"));

		Function<Integer, String> intToStr = (n) -> n + "";
		System.out.println(intToStr.apply(12121212));

		Function<Integer, Boolean> isEven = (n) -> n % 2 == 0;
		System.out.println(isEven.apply(12121212));

		Function<List<Integer>, Integer> addAll = (list) -> {
			Integer y = 0;
			for (Integer x : list) {
				y += x;
			}
			return y;
		};
		List<Integer> arr = new ArrayList<>();
		arr.add(1);
		arr.add(2);
		arr.add(3);
		arr.add(4);
		System.out.println(addAll.apply(arr));
	}
}
