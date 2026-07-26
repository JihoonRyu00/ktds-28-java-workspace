package com.ktdsuniversity.edu.oop.exam.string.quiz;

//https://school.programmers.co.kr/learn/courses/30/lessons/181875
public class P181875 {

	public static String[] solution(String[] strArr) {
		String[] newStrArr = strArr.clone();
		for (int i = 0; i < newStrArr.length; ++i) {
			if (i % 2 == 0) {
				newStrArr[i] = newStrArr[i].toLowerCase();
			} else {
				newStrArr[i] = newStrArr[i].toUpperCase();
			}
		}
		return newStrArr;
	}

	public static void main(String[] args) {
		String[] strArr1 = solution(new String[] { "AAA", "BBB", "CCC", "DDD" });
		for (String str : strArr1) {
			System.out.println(str);
		}

		String[] strArr2 = solution(new String[] { "aaa", "BBB", "ccc", "DDD" });
		for (String str : strArr2) {
			System.out.println(str);
		}
	}
}
