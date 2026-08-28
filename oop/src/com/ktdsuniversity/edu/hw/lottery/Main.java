package com.ktdsuniversity.edu.hw.lottery;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

//	public static int[] createDistinctRandomSixNumbers() {
//		int[] lottoNumbers = new int[6];
//		Map<Integer, Boolean> visit = new HashMap<>();
//		int num = 0;
//		for (int i = 0; i < 6; ++i) {
//			num = (int) (Math.random() * 45) + 1;
//			while (visit.get(num) != null) {
//				num = (int) (Math.random() * 45) + 1;
//			}
//			lottoNumbers[i] = num;
//			visit.put(num, null);
//		}
//		return lottoNumbers;
//	}

	public static List<Integer> generateLottoNumbersWithList() {
		List<Integer> numbers = new ArrayList<>();
		int num = 0;
		for (int i = 0; i < 6; ++i) {
			num = (int) (Math.random() * 45) + 1;
			while (numbers.contains(num)) {
				num = (int) (Math.random() * 45) + 1;
			}
			numbers.add(num);
		}
		return numbers;
	}

	public static int[] generateLottoNumbersWithPrimitiveArray() {
		int[] numbers = new int[6];
		boolean[] visit = new boolean[46];
		int num = 0;
		for (int i = 0; i < 6; ++i) {
			num = (int) (Math.random() * 45) + 1;
			while (visit[num]) {
				num = (int) (Math.random() * 45) + 1;
			}
			visit[num] = true;
			numbers[i] = num;
		}
		return numbers;
	}

	public static List<Integer> generateLottoNumbersWithMapAndList() {
		List<Integer> numbers = new ArrayList<>();
		Map<Integer, Boolean> visit = new HashMap<>();
		int num = 0;
		for (int i = 0; i < 6; ++i) {
			num = (int) (Math.random() * 45) + 1;
			while (visit.containsKey(num)) {
				num = (int) (Math.random() * 45) + 1;
			}
			numbers.add(num);
			visit.put(num, null);
		}
		return numbers;
	}

	public static void main(String[] args) {
		
//		System.out.println(generateLottoNumbersWithList().toString().replaceAll("[\\[\\]]", ""));
		
//		int[] numbers=generateLottoNumbersWithPrimitiveArray();
//		for(int i=0;i<numbers.length;++i) {
//			System.out.print(numbers[i]);
//			if(i==numbers.length-1) {
//				continue;
//			}
//			System.out.print(", ");
//		}
		
		Scanner sc = new Scanner(System.in);
		System.out.print("회차를 입력하세요. >> ");
		int times = sc.nextInt();
		List<List<Integer>> lottoNumbersList = new ArrayList<>();
		for (int i = 0; i < times; ++i) {
			lottoNumbersList.add(generateLottoNumbersWithMapAndList());
		}
		for (int i = 0; i < lottoNumbersList.size(); ++i) {
			System.out.print((i + 1) + "회차 ==> " + lottoNumbersList.get(i).toString().replaceAll("[\\[\\]]", ""));
			System.out.println();
		}
	}
}
