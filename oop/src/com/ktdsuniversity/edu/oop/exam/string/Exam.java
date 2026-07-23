package com.ktdsuniversity.edu.oop.exam.string;

import java.util.Arrays;

public class Exam {

	public static void main(String[] args) {

		/** contains */
		System.out.println("서울특별시 서초구 효령로 176".contains("시 서"));

		/** endsWith */
		System.out.println("서울특별시 서초구 효령로 176".endsWith("176"));

		/** startsWith */
		System.out.println("서울특별시 서초구 효령로 176".startsWith("서울"));

		/** equals */
		System.out.println("KTDS".equals("ktds"));

		/** equalsIgnoreCase */
		System.out.println("KTDS".equalsIgnoreCase("ktds"));

		/** format */
		System.out.println(String.format("%d %s %f %.2f", 10, "aa", 10.2121212, 10.2121212));

		/** formatted */
		System.out.println("%,d".formatted(Integer.MAX_VALUE));

		String S = "%,d";
		String.format(S, 1000); // 인스턴스의 정보는 update 되지 않고 return만 해줌.
		System.out.println(S);
		S.formatted(1000); // 인스턴스의 정보는 update 되지 않고 return만 해줌.
		System.out.println(S);

		/** indexOf */
		System.out.println("abcdef".indexOf('a'));
		System.out.println("abcdef".indexOf("cde"));

		/** isBlank */
		System.out.println("\n\n\n\t\t\t\t\t".isBlank());

		/** isEmpty */
		System.out.println("----".replace("-", "").isEmpty());

		/** String.join */
		String[] strArr = { "상수", "변수", "생성자", "메소드" };
		System.out.println(String.join("->", strArr));

		/** lastIndexOf */
		System.out.println("011011".lastIndexOf('1'));
		System.out.println("011011".lastIndexOf("11"));

		/** length */
		System.out.println("notthatlongstring".length());

		/** matches */
		System.out.println("emain@email.com".matches(
				"[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?"));

		/** replace */
		System.out.println("i'm a actor.".replace(" a ", " a(an) "));

		/** relaceAll */
		System.out.println("010-1212.6666".replaceAll("[^0-9]", ""));

		/** split */
		System.out.println(Arrays.toString("010-1212.6666".split("[^0-9]")));

		/** substring */
		System.out.println("19880818".substring(4, 8));

		/** strip */
		System.out.println(" \t\t\t000\n  \n".strip());
	}
}
