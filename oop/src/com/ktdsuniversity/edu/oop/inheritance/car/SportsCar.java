package com.ktdsuniversity.edu.oop.inheritance.car;

public class SportsCar extends Vehicle {

	public SportsCar(String modelName) {
		super(modelName);
	}
	
	public void turnTurboModeOn() {
		System.out.println("터보 모드가 활성화되었습니다.");
	}
}
