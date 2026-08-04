package com.ktdsuniversity.edu.oop.enums;

public enum CalcType {

	ADD("더하기"), SUB("빼기"), MUL("곱하기"), DIV("나누기");

	private String name;

	CalcType(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

}
