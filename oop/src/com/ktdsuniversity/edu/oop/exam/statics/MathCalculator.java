package com.ktdsuniversity.edu.oop.exam.statics;

/**
 * 사칙연산기
 */
public class MathCalculator {

	/** 첫번째 피연산자 */
	private int firstOperand;
	/** 두번째 피연산자 */
	private int secondOperand;

	/**
	 * 
	 * @param firstNum
	 * @param secondNum
	 */
	public MathCalculator(int firstOperand, int secondOperand) {
		this.firstOperand = firstOperand;
		this.secondOperand = secondOperand;
	}

	/**
	 * 두 수를 연산하여 반환
	 * 
	 * @see com.ktdsuniversity.edu.oop.exam.statics.Operators 연산자 종류
	 * @param operator 연산자 종류
	 * @return
	 */
	public int getCoumputeResult(int operator) {
		if (operator == Operators.ADD) {
			return this.firstOperand + this.secondOperand;
		} else if (operator == Operators.SUB) {
			return this.firstOperand - this.secondOperand;
		} else if (operator == Operators.MUL) {
			return this.firstOperand * this.secondOperand;
		} else if (operator == Operators.DIV) {
			return this.firstOperand / this.secondOperand;
		} else if (operator == Operators.MOD) {
			return this.firstOperand % this.secondOperand;
		}
		return 0;
	}

	public static void main(String[] args) {

		MathCalculator mc = new MathCalculator(10, 2);
		System.out.println(mc.getCoumputeResult(Operators.ADD));
		System.out.println(mc.getCoumputeResult(Operators.SUB));
		System.out.println(mc.getCoumputeResult(Operators.MUL));
		System.out.println(mc.getCoumputeResult(Operators.DIV));
		System.out.println(mc.getCoumputeResult(Operators.MOD));
	}
}
