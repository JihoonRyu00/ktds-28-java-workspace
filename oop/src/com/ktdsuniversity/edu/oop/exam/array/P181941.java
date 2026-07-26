package com.ktdsuniversity.edu.oop.exam.array;

// https://school.programmers.co.kr/learn/courses/30/lessons/181941
public class P181941 {

	public static String solution(String[] arr) {
		StringBuffer sb = new StringBuffer();
		for (String str : arr) {
			sb.append(str);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String[] arr = { "a", "b", "c" };
		System.out.println(solution(arr));
	}
}
