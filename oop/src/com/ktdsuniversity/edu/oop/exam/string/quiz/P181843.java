package com.ktdsuniversity.edu.oop.exam.string.quiz;

//https://school.programmers.co.kr/learn/courses/30/lessons/181843
public class P181843 {

    public static int solution(String my_string, String target) {
		if (my_string.contains(target)) {
			return 1;
		}
		return 0;
    }
    
    public static void main(String[] args) {
		System.out.println(solution("banana", "ana"));

		System.out.println(solution("banana", "wxyz"));
	}
}
