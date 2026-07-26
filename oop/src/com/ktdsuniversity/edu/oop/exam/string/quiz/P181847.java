package com.ktdsuniversity.edu.oop.exam.string.quiz;

//https://school.programmers.co.kr/learn/courses/30/lessons/181847
public class P181847 {

	public static String solution(String n_str) {
		int curr = 0;
		while (curr <= n_str.length() - 1 && n_str.toCharArray()[curr] == '0') {
			curr++;
		}
		if (curr > n_str.length() - 1) {
			return "";
		}
		return n_str.substring(curr);
	}

	public static void main(String[] args) {
		System.out.println(solution("0010"));

		System.out.println(solution("854020"));
	}
}
