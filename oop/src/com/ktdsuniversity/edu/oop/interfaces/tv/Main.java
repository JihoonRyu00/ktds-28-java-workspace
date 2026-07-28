package com.ktdsuniversity.edu.oop.interfaces.tv;

public class Main {

	public static void main(String[] args) {
		TV smartTV = new SmartTV();
		smartTV.turnOn();

		RemoteController smartRC = new SmartRemoteController();
		smartRC.turnOff(smartTV);
		smartRC.turnOn(smartTV);
		smartRC.increaseVolume(smartTV);
		smartRC.increaseVolume(smartTV);
		smartRC.increaseVolume(smartTV);
		smartRC.increaseVolume(smartTV);
		smartRC.decreaseVolume(smartTV);
		smartRC.decreaseVolume(smartTV);
		smartRC.mute(smartTV);
		smartRC.changeInputSource(smartTV);
		smartRC.changeInputSource(smartTV);
		smartRC.changeInputSource(smartTV);
		smartRC.enterChannelNumber(smartTV, 2);
	}
}
