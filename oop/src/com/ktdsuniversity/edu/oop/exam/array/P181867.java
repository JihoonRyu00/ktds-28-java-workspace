package com.ktdsuniversity.edu.oop.exam.array;

// https://school.programmers.co.kr/learn/courses/30/lessons/181867
public class P181867 {

	public static int[] solution(String myString) {
		String[] temp = myString.split("x");
		int ansLength = temp.length;
		if (myString.endsWith("x")) {
			ansLength++;
		}
		int[] answer = new int[ansLength];
		int currI = 0;
		for (String s : temp) {
			answer[currI] = s.length();
			currI++;
		}
		return answer;
	}

	public static void main(String[] args) {
		for (int a : solution("oxooxoxxox")) {
			System.out.print(a + " ");
		}

		for (int a : solution("xabcxdefxghi")) {
			System.out.print(a + " ");
		}
	}
}
