package com.ktdsuniversity.edu.oop.exam.array;

//https://school.programmers.co.kr/learn/courses/30/lessons/181854
public class P181854 {

	public static int[] solution(int[] arr, int n) {
		int arrLength = arr.length;
		int[] answer = new int[arrLength];
		for (int i = 0; i < arrLength; ++i) {
			if (i % 2 == arrLength % 2) {
				answer[i] = arr[i];
			} else {
				answer[i] = arr[i] + n;
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		int[] arr1 = { 49, 12, 100, 276, 33 };
		int[] resultArr1 = solution(arr1, 27);
		for (int a : resultArr1) {
			System.out.print(a + " ");
		}

		int[] arr2 = { 444, 555, 666, 777 };
		int[] resultArr2 = solution(arr2, 100);
		for (int a : resultArr2) {
			System.out.print(a + " ");
		}
	}
}
