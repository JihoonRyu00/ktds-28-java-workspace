package com.ktdsuniversity.edu.oop.exam.array;

//https://school.programmers.co.kr/learn/courses/30/lessons/181862
public class P181862 {

	public static String[] solution(String myStr) {
		String[] tempAnswer = myStr.split("[abc]");
		int ansLength = 0;
		for (String s : tempAnswer) {
			if (s != "") {
				ansLength++;
			}
		}
		if (ansLength == 0) {
			return new String[] { "EMPTY" };
		}
		String[] answer = new String[ansLength];
		int currI = 0;
		for (String s : tempAnswer) {
			if (s != "") {
				answer[currI] = s;
				currI++;
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		for (String s : solution("baconlettucetomato")) {
			System.out.println(s);
		}

		for (String s : solution("abcd")) {
			System.out.println(s);
		}

		for (String s : solution("cabab")) {
			System.out.println(s);
		}
	}
}
