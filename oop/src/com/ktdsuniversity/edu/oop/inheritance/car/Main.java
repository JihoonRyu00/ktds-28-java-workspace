package com.ktdsuniversity.edu.oop.inheritance.car;

public class Main {

	public static void turnEngineOn(Vehicle car) {
		car.turnEngineOn();
	}

	public static void turnTurboModeOn(Vehicle car) {
		if (car instanceof SportsCar sc) {
			sc.turnTurboModeOn();
		}
	}

	public static void seperateBatpod(Vehicle car) {
		if (car instanceof BatMobile bm) {
			bm.seperateBatpod();
		}	
	}

	public static void checkBatteryPower(Vehicle car) {
		if (car instanceof EV ev) {
			ev.checkBatteryPower();
		}
	}

	public static void main(String[] args) {
		Vehicle veh = new Vehicle("JustVehicle");
		SportsCar sc = new SportsCar("JustSportsCar");
		Vehicle vehsc = new SportsCar("VehicleSportsCar");
		BatMobile bm = new BatMobile("Tumbler");
		SportsCar scbm = new BatMobile("SportsCarTumbler");
		Vehicle vehbm = new BatMobile("VehicleTumbler");
		EV ev = new EV("Tesla", 100);
		Vehicle vehev = new EV("VehicleTesla", 100);
		((EV) vehbm).getBatteryPower(); // runtime error

	}
}
