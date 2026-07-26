package com.ktdsuniversity.edu.oop.exam.array;

//https://school.programmers.co.kr/learn/courses/30/lessons/181861
public class P181861 {

	public static int[] solution(int[] arr) {
		int answerLength = 0;
		for (int a : arr) {
			answerLength += a;
		}
		int[] answer = new int[answerLength];
		int currI = 0;
		for (int a : arr) {
			for (int i = 0; i < a; ++i) {
				answer[currI + i] = a;
			}
			currI += a;
		}
		return answer;
	}

	public static void main(String[] args) {
		int[] resultArr1 = solution(new int[] { 5, 1, 4 });
		for (int a : resultArr1) {
			System.out.print(a + "");
		}

		int[] resultArr2 = solution(new int[] { 6, 6 });
		for (int a : resultArr2) {
			System.out.print(a + "");
		}

		int[] resultArr3 = solution(new int[] { 1 });
		for (int a : resultArr3) {
			System.out.print(a + "");
		}
	}
}
