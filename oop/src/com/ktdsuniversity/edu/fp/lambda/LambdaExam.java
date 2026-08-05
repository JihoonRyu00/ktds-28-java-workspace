package com.ktdsuniversity.edu.fp.lambda;

public class LambdaExam {

	public static void main(String[] args) {

		// 람다 함수 조건
		// 1. 반드시 인터페이스 필요
		// 2. 추상 메소드가 반드시 1개만 있어야 한다.
		Computable addComputer = new Computable() {
			@Override
			public int compute(int number1, int number2) {
				return number1 + number2;
			}
		};
		System.out.println(addComputer); // ~.LambdaExam$1@1f32e575
		System.out.println(addComputer.compute(10, 40));

		// Computable 인터페이스를 이용해 추상메소드가 1개만 있는 함수를 만들기
		Computable mulComputer = (int number1, int number2) -> {
			return number1 * number2;
		};
		System.out.println(mulComputer); // ~.LambdaExam$$Lambda/0x0000022dbe000400@65b54208
		System.out.println(mulComputer.compute(10, 5));

		// Computable 인터페이스를 이용해 두 개의 숫자를 뺄셈한 결과를 반환시키는 함수
		Computable subComputer = (n1, n2) -> n1 - n2;
		System.out.println(subComputer);
		System.out.println(subComputer.compute(1, 10));

		// Computable 인터페이스를 이용해 두 개의 숫자를 나눈 몫을 반환시키는 함수
		Computable divComputer = (n1, n2) -> n1 / n2;
		System.out.println(divComputer);
		System.out.println(divComputer.compute(1, 10));

		// Computable 인터페이스를 이용해 두 개의 숫자를 나눈 나머지를 반환시키는 함수
		Computable modComputer = (n1, n2) -> n1 % n2;
		System.out.println(modComputer);
		System.out.println(modComputer.compute(1, 10));
	}
}
