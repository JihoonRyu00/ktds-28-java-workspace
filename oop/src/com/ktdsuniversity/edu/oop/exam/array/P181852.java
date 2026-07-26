package com.ktdsuniversity.edu.oop.exam.array;

import java.util.Arrays;

//https://school.programmers.co.kr/learn/courses/30/lessons/181852
public class P181852 {

	public static int[] solution(int[] num_list) {
		Arrays.sort(num_list);
		int[] resultArr = new int[num_list.length - 5];
//		for (int i = 0; i < num_list.length - 5; ++i) {
//			resultArr[i] = num_list[i + 5];
//		}
		System.arraycopy(num_list, 5, resultArr, 0, num_list.length - 5);
		return resultArr;
	}

	public static void main(String[] args) {
		int[] resultArr = solution(new int[] { 12, 4, 15, 46, 38, 1, 14, 56, 32, 10 });
		for (int a : resultArr) {
			System.out.println(a);
		}
	}
}
