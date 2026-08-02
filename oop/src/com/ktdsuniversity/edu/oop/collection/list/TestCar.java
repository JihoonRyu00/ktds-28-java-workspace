package com.ktdsuniversity.edu.oop.collection.list;

import java.util.ArrayList;
import java.util.List;

import com.ktdsuniversity.edu.oop.inheritance.car.BatMobile;
import com.ktdsuniversity.edu.oop.inheritance.car.EV;
import com.ktdsuniversity.edu.oop.inheritance.car.SportsCar;
import com.ktdsuniversity.edu.oop.inheritance.car.Vehicle;

public class TestCar {

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
		List<Vehicle> vehicles=new ArrayList<>();
		vehicles.add(new Vehicle("JustVehicle"));
		vehicles.add(new SportsCar("JustSportsCar"));
		vehicles.add(new SportsCar("VehicleSportsCar"));
		vehicles.add(new BatMobile("Tumbler"));
		vehicles.add(new BatMobile("SportsCarTumbler"));
		vehicles.add(new BatMobile("VehicleTumbler"));
		vehicles.add(new EV("Tesla", 100));
		vehicles.add(new EV("VehicleTesla", 100));
//		Vehicle veh = new Vehicle("JustVehicle");
//		SportsCar sc = new SportsCar("JustSportsCar");
//		Vehicle vehsc = new SportsCar("VehicleSportsCar");
//		BatMobile bm = new BatMobile("Tumbler");
//		SportsCar scbm = new BatMobile("SportsCarTumbler");
//		Vehicle vehbm = new BatMobile("VehicleTumbler");
//		EV ev = new EV("Tesla", 100);
//		Vehicle vehev = new EV("VehicleTesla", 100);
//		((EV) vehbm).getBatteryPower(); // runtime error

	}
}
