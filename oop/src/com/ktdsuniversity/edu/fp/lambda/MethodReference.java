package com.ktdsuniversity.edu.fp.lambda;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public class MethodReference {

	public static void main(String[] args) {

		String strVar = "1234";
		String strVar2 = "23";
		// 문자를 숫자로 변경하여 반환
		// 1. lambda
		Function<String, Integer> strToInt = (str) -> Integer.parseInt(str);
		System.out.println(strToInt.apply(strVar));
		// 2. method reference
		Function<String, Integer> strToIntRef = Integer::parseInt;
		System.out.println(strToIntRef.apply(strVar));

		// 문자를 받아 문자의 길이를 반환
		// 1. lambda
		Function<String, Integer> getStrLen = (str) -> str.length();
		System.out.println(getStrLen.apply(strVar));
		// 2. method reference
		Function<String, Integer> getStrLenRef = String::length;
		System.out.println(getStrLenRef.apply(strVar));

		BiFunction<String, String, Integer> getIndexOfRef = String::indexOf;
		System.out.println(getIndexOfRef.apply(strVar, strVar2));
		
		BiFunction<String, String, String> getConcatedRef = String::concat;
		System.out.println(getConcatedRef.apply(strVar, strVar2));

		Consumer<String> print = (str) -> System.out.println(str);
		print.accept(strVar);
		Consumer<String> printRef = System.out::println;
		printRef.accept(strVar);
	}
}
