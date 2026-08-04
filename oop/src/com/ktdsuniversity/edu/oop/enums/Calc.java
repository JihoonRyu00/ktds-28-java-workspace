package com.ktdsuniversity.edu.oop.enums;

public class Calc {

	private static final int ADD = 1;
	private static final int SUB = 2;
	private static final int MUL = 3;
	private static final int DIV = 4;

	/**
	 * type에 전달된 연산의 종류에 따라 num1과 num2를 연산하고 겨과를 출력한다.
	 * 
	 * @param type 연산의 종류 (Calc.ADD, Calc.SUB, Calc.MUL, Calc.DIV)
	 * @param num1
	 * @param num2
	 */
	public void calc(int type, int num1, int num2) {
		if (type == ADD) {
			System.out.println(num1 + num2);
		} else if (type == SUB) {
			System.out.println(num1 - num2);
		} else if (type == MUL) {
			System.out.println(num1 * num2);
		} else if (type == DIV) {
			System.out.println(num1 / num2);
		} else {
			throw new IllegalArgumentException("연산의 종류가 잘못되었습니다. Calc.ADD, Calc.SUB, Calc.MUL, Calc.DIV 중 하나를 선택하세요.");
		}
	}

	public void computeNumbers(CalcType type, int num1, int num2) {
		System.out.println("Run public void computeNumbers(CalcType " + type + ", int " + num1 + ", int " + num2 + ")");
		System.out.println(type.getName());
		if (type == CalcType.ADD) {
			System.out.println(num1 + num2);
		} else if (type == CalcType.SUB) {
			System.out.println(num1 - num2);
		} else if (type == CalcType.MUL) {
			System.out.println(num1 * num2);
		} else if (type == CalcType.DIV) {
			System.out.println(num1 / num2);
		}
	}

	public static void main(String[] args) {

		Calc calc = new Calc();

//		calc.calc(ADD, 10, 20);
//		calc.calc(SUB, 10, 20);
//		calc.calc(MUL, 10, 20);
//		calc.calc(DIV, 10, 20);

		calc.computeNumbers(CalcType.ADD, 10, 20);
		calc.computeNumbers(CalcType.SUB, 10, 20);
		calc.computeNumbers(CalcType.MUL, 10, 20);
		calc.computeNumbers(CalcType.DIV, 10, 20);
	}
}
