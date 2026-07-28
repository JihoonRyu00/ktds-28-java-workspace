package com.ktdsuniversity.edu.oop.interfaces.tv;

public class SmartRemoteController implements RemoteController {

	@Override
	public void turnOn(TV tv) {
		tv.turnOn();
	}

	@Override
	public void turnOff(TV tv) {
		tv.turnOff();
	}

	@Override
	public void increaseVolume(TV tv) {
		tv.increaseChannel();
	}

	@Override
	public void decreaseVolume(TV tv) {
		tv.decreaseVolume();
	}

	@Override
	public void increaseChannel(TV tv) {
		tv.increaseChannel();
	}

	@Override
	public void decreaseChannel(TV tv) {
		tv.decreaseChannel();
	}

	@Override
	public void changeInputSource(TV tv) {
		tv.changeInputSource();
	}

	@Override
	public void runApp(TV tv) {
		tv.runApp();
	}

	@Override
	public void runAI(TV tv) {
		System.out.println("This TV has NO AI.");
	}

	@Override
	public void controlShopping(TV tv) {
		System.out.println("This TV has NO Shopping Service.");
	}

	@Override
	public void enterChannelNumber(TV tv, int number) {
		tv.changeChannel(number);
	}

	@Override
	public void mute(TV tv) {

	}

	@Override
	public void changeSettings(TV tv) {
		System.out.println("This TV has NO Changing Setting Service.");
	}

}
