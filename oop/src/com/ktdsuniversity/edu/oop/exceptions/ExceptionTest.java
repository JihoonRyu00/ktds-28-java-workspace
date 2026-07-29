package com.ktdsuniversity.edu.oop.exceptions;

public class ExceptionTest {

	public static void main(String[] args) {
		System.out.println("출력 시작");

		int[] arr = new int[3];
//		arr[3] = 10;

		String name = null;
		// name 인스턴스 값이 null이라면 "Enter name." 출력
		// 아니라면 값 출력
		if (name == null) {
			System.out.println("Enter name.");
		} else {
			System.out.println(name);
		}

		String job = "";
		// job 인스턴스 값이 ""이라면 "Enter job." 출력
		// 아니라면 값 출력
		if (job == null || job.equals("")) {
			System.out.println("Enter job.");
		} else {
			System.out.println(job);
		}

		String address = " \n   \t\s\s\s\s\s\s \t\n   			";
		// address 인스턴스 값이 공백으로만 이루어져있다면 "Enter address." 출력
		// 아니라면 값 출력
		if (address == null || address.strip().length() == 0) {
			System.out.println("Enter address.");
		} else {
			System.out.println(address);
		}

		System.out.println("출력 종료");
	}
}
