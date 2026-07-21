package com.ktdsuniversity.edu.oop;

import com.ktdsuniversity.edu.oop.exam.Car;
import java.util.Scanner;

public class Temp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String name = ""; // java.lang은 생략 가능
		double rand = Math.random(); // java.lang은 생략 가능

		Car testCar = new Car();
		testCar.pressEngineStartButton();
		System.out.println(testCar.zero100Seconds);
		System.out.println(testCar.notExistedField);

	}
}
