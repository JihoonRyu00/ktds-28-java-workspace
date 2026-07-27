package com.ktdsuniversity.edu.oop.inheritance.car;

public class Vehicle {
	
	private String modelName;

	public Vehicle(String modelName) {
		this.modelName = modelName;
	}

	public String getModelName() {
		return modelName;
	}
	
	public void turnEngineOn() {
		System.out.println("시동이 걸렸습니다.");
	}

}
