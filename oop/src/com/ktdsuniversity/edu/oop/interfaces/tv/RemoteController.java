package com.ktdsuniversity.edu.oop.interfaces.tv;

public interface RemoteController {
	void turnOn(TV tv);

	void turnOff(TV tv);

	void increaseVolume(TV tv);

	void decreaseVolume(TV tv);

	void increaseChannel(TV tv);

	void decreaseChannel(TV tv);

	void changeInputSource(TV tv);

	void runApp(TV tv);

	void runAI(TV tv);

	void controlShopping(TV tv);

	void enterChannelNumber(TV tv, int number);

	void mute(TV tv);

	void changeSettings(TV tv);
}
