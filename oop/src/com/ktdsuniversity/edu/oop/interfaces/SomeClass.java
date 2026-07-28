package com.ktdsuniversity.edu.oop.interfaces;

// Someinterface를 구현한 구현 클래스
// 인터페이스로 구현한 클래스는 인터페이스 내부의 메소드를 구현해야만 함
public class SomeClass implements SomeInterface {

	@Override
	public void doSomething1() {
		System.out.println("do sth 1.");
	}

	@Override
	public void doSomething2() {
		System.out.println("do sth 2.");
	}

	@Override
	public void doSomething3() {
		System.out.println("do sth 3.");
	}

	@Override
	public int getSomething() {
		return 111111;
	}

	@Override
	public String getString() {
		return "ay";
	}

}
