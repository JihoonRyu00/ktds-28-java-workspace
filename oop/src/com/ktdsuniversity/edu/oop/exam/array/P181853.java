package com.ktdsuniversity.edu.oop.exam.array;

import java.util.Arrays;

//https://school.programmers.co.kr/learn/courses/30/lessons/181853
public class P181853 {

	public static int[] solution(int[] num_list) {
		Arrays.sort(num_list);
		int[] resultArr = new int[5];
		System.arraycopy(num_list, 0, resultArr, 0, 5);
		return resultArr;
	}

	public static void main(String[] args) {
		int[] resultArr = solution(new int[] { 12, 4, 15, 46, 38, 1, 14 });
		for (int a : resultArr) {
			System.out.println(a);
		}
	}
}
