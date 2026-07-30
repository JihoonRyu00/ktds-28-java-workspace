package com.ktdsuniversity.edu.oop.generics;

public class Printer<T1, T2> {

	private T1 data1;
	private T2 data2;

	public Printer(T1 data1, T2 data2) {
		this.data1 = data1;
		this.data2 = data2;
	}

	public void print() {
		System.out.println("data1: " + this.data1 + ", data2: " + this.data2);
	}

	public T1 getData1() {
		return this.data1;
	}

	public T2 getData2() {
		return this.data2;
	}
}
