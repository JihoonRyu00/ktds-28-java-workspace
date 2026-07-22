package com.ktdsuniversity.edu.oop;

import com.ktdsuniversity.edu.oop.exam.Car;
import com.ktdsuniversity.edu.oop.exam.Student;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String name = ""; // java.lang은 생략 가능
		double rand = Math.random(); // java.lang은 생략 가능

		Car testCar = new Car();
		testCar.pressEngineStartButton();
		System.out.println(testCar.zero100Seconds); // 멤버변수가 public 이기 때문에 가능
//		System.out.println(testCar.notExistedField);

		Student student = new Student(0, 0, 0, 0); // 생성자가 public 이기 때문에 가능
	}
}
