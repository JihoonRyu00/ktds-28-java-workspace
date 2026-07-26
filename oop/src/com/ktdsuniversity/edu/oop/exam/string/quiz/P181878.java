package com.ktdsuniversity.edu.oop.exam.string.quiz;

//https://school.programmers.co.kr/learn/courses/30/lessons/181878
public class P181878 {

	public static int solution(String myString, String pat) {
		if (myString.toLowerCase().contains(pat.toLowerCase())) {
			return 1;
		}
		return 0;
	}

	public static void main(String[] args) {
		System.out.println(solution("AbCdEfG", "aBc"));

		System.out.println(solution("aaAA", "aaaaa"));
	}
}
