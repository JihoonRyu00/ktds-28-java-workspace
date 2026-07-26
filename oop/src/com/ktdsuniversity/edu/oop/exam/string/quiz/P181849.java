package com.ktdsuniversity.edu.oop.exam.string.quiz;

//https://school.programmers.co.kr/learn/courses/30/lessons/181849
public class P181849 {

	public static int solution(String num_str) {
		int sum = 0;
//		for (char c : num_str.toCharArray()) {
//			sum += Integer.parseInt(c + "");
//		}
		// split 사용
		for (String s : num_str.split("")) {
			sum += Integer.parseInt(s);
		}
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(solution("123456789"));

		System.out.println(solution("1000000"));
	}
}
