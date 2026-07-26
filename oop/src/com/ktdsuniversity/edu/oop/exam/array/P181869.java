package com.ktdsuniversity.edu.oop.exam.array;

//https://school.programmers.co.kr/learn/courses/30/lessons/181869
public class P181869 {

	public static String[] solution(String my_string) {
		String[] answer = my_string.split("[\\s]+");
		return answer;
	}

	public static void main(String[] args) {
		for (String s : solution("i love you")) {
			System.out.print(s + " ");
		}

		for (String s : solution("programmers")) {
			System.out.print(s + " ");
		}
	}
}
