package com.ktdsuniversity.edu.oop.inheritance.car;

public class BatMobile extends SportsCar {

	public BatMobile(String modelName) {
		super(modelName);
	}

	public void seperateBatpod() {
		System.out.println("배트포드가 분리되었습니다.");
	}
}
