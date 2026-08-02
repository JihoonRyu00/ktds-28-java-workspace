package com.ktdsuniversity.edu.oop.file;

public class RecursiveCallExam {

	public static void explore(int number) {
		System.out.print(" ".repeat(number));
		System.out.println("insert explore(%d)".formatted(number));
		if (number > 10) {
			return;
		}
		explore(number + 1);
		System.out.print(" ".repeat(number));
		System.out.println("pop explore(%d)".formatted(number));
	}

	public static void main(String[] args) {
		explore(0);
	}
}
