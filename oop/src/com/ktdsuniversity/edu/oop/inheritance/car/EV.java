package com.ktdsuniversity.edu.oop.inheritance.car;

public class EV extends Vehicle {

	private int batteryPower;

	public EV(String modelName, int batteryPower) {
		super(modelName);
		this.batteryPower = batteryPower;
	}

	public int getBatteryPower() {
		return batteryPower;
	}

	public void checkBatteryPower() {
		System.out.println("남은 배터리: " + this.batteryPower);
	}
}
