package com.ktdsuniversity.edu.oop.exam;

public class StudentTest {

	public static void main(String[] args) {
		Student student = new Student(0, 0, 0, 0);
		student.getSumAllScores(); // private이라 접근 불가
		System.out.println(student.java); // private이라 접근 불가
	}
}
