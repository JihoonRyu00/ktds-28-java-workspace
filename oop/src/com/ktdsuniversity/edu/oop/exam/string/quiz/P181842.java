package com.ktdsuniversity.edu.oop.exam.string.quiz;

//https://school.programmers.co.kr/learn/courses/30/lessons/181842
public class P181842 {

	public static int solution(String str1, String str2) {
		if (str2.contains(str1)) {
			return 1;
		}
		return 0;
	}

	public static void main(String[] args) {
		System.out.println(solution("abc", "aabcc"));

		System.out.println(solution("tbt", "tbbttb"));

	}
}
