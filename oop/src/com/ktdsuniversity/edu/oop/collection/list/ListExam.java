package com.ktdsuniversity.edu.oop.collection.list;

import java.util.List;
import java.util.ArrayList;

import com.ktdsuniversity.edu.oop.exceptions.Goods;

public class ListExam {

	public static void main(String[] args) {

		// 정수를 관리하는 리스트
		List<Integer> intList = new ArrayList<>();
		System.out.println(intList.size());
		for (int i = 0; i < 10; ++i) {
			intList.add((int) (Math.random() * 1000));
		}
		for (int i = 0; i < intList.size(); ++i) {
			System.out.print(intList.get(i) + " ");
		}
		System.out.println();
		for (int i = intList.size() - 1; i >= 5; --i) {
			System.out.println("index: " + i + ", value: " + intList.remove(i) + " deleted.");
		}
		System.out.println(intList.size());
//		intList.clear();
		intList = new ArrayList<>();
		System.out.println(intList.size());
		for (int i = 0; i < 10; ++i) {
			intList.add(i * 100);
		}
		if (intList.contains(100)) {
			System.out.println("100 exists.");
		}
		if (intList.contains(200)) {
			System.out.println("200 exists.");
		}
		if (intList.contains(300)) {
			System.out.println("300 exists.");
		}
		System.out.println(intList);
		for (Object a : intList) {
			System.out.println(a);
		}

		List<Goods> goodsList = new ArrayList<>();
		for (int i = 0; i < 3; ++i) {
			goodsList.add(new Goods("Goods" + i, (int) (Math.random() * 1000 + 1) * 100));
		}
		for (int i = 0; i < goodsList.size(); ++i) {
			System.out.println(goodsList.get(i));
		}
		for (Goods g : goodsList) {
			System.out.println(g);
		}
		System.out.println(new String("a") == new String("a"));
		String str1 = "a";
		String str2 = "a";
		str1 = "b";
		str2 = "b";
		String str3 = "a";
		System.out.println(str1 == str2);
		System.out.println(new String("a") == str2);
		System.out.println(new String("a") == str3);

		Goods g1 = new Goods("a", 1);
		Goods g2 = new Goods("a", 1);
		System.out.println("Is g1 equals g2: " + g1.equals(g2));

		System.out.println(goodsList.contains(new Goods("a", 1))); // Goods의 equals에 의해 주소값이 아닌 필드비교 결과 리턴

//		Queue<Map<Integer, String>> mapQ = new Queue<Map<Integer, String>()>();
//		mapQ.
	}
}
