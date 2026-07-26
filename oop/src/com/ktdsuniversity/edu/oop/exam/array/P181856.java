package com.ktdsuniversity.edu.oop.exam.array;

//https://school.programmers.co.kr/learn/courses/30/lessons/181856
public class P181856 {

	public static int solution(int[] arr1, int[] arr2) {
		if (arr1.length > arr2.length) {
			return 1;
		} else if (arr1.length < arr2.length) {
			return -1;
		}
		int sum1 = 0;
		int sum2 = 0;
		for (int i = 0; i < arr1.length; ++i) {
			sum1 += arr1[i];
			sum2 += arr2[i];
		}
		if (sum1 > sum2) {
			return 1;
		} else if (sum1 < sum2) {
			return -1;
		}
		return 0;
	}

	public static void main(String[] args) {

		int[] arr1_1 = { 49, 13 };
		int[] arr1_2 = { 70, 11, 2 };
		System.out.println(solution(arr1_1, arr1_2));

		int[] arr2_1 = { 100, 17, 84, 1 };
		int[] arr2_2 = { 55, 12, 65, 36 };
		System.out.println(solution(arr2_1, arr2_2));

		int[] arr3_1 = { 1, 2, 3, 4, 5 };
		int[] arr3_2 = { 3, 3, 3, 3, 3 };
		System.out.println(solution(arr3_1, arr3_2));
	}
}
