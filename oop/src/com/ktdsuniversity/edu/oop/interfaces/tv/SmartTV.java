package com.ktdsuniversity.edu.oop.interfaces.tv;

public class SmartTV implements TV {

	private final String[] INPUT_SRC = { "COMPONENT", "HTML1", "HTML2", "USB" };
	private final String[] APPS = { "NETFLIX", "YOUTUBE", "DISNEY_PLUS", "HBO_MAX" };

	private boolean isOn;
	private int volume;
	private int channelIndex;
	private int activeInputSourceIndex;
	private int activeAppIndex;

	@Override
	public void turnOn() {
		this.isOn = true;
		System.out.println("turned on.");
	}

	@Override
	public void turnOff() {
		this.isOn = false;
		System.out.println("turned off.");
	}

	@Override
	public void increaseVolume() {
		if (!this.isOn) {
			return;
		}
		if (this.volume == 100) {
			System.out.println("cannot increase volume more.");
		} else {
			this.volume++;
		}
		System.out.println("현재 볼륨은 " + this.volume + " 입니다");
	}

	@Override
	public void decreaseVolume() {
		if (!this.isOn) {
			return;
		}
		if (this.volume == 0) {
			System.out.println("cannot decrease volume more.");
		} else {
			this.volume--;
		}
		System.out.println("현재 볼륨은 " + this.volume + " 입니다");
	}

	@Override
	public void increaseChannel() {
		if (!this.isOn) {
			return;
		}
		this.channelIndex = (this.channelIndex + 1) % (TV.CHANNELS.length);
		System.out.println("현재 채널은 " + TV.CHANNELS[channelIndex] + " 입니다.");
	}

	@Override
	public void decreaseChannel() {
		if (!this.isOn) {
			return;
		}
		this.channelIndex = (this.channelIndex - 1 + TV.CHANNELS.length) % (TV.CHANNELS.length);
		System.out.println("현재 채널은 " + TV.CHANNELS[channelIndex] + " 입니다.");
	}

	@Override
	public void changeInputSource() {
		if (!this.isOn) {
			return;
		}
		this.activeInputSourceIndex = (this.activeInputSourceIndex + 1) % (INPUT_SRC.length);
		System.out.println("현재 외부 입력은 " + INPUT_SRC[activeInputSourceIndex] + " 입니다.");
		if (INPUT_SRC[this.activeInputSourceIndex] == "USB") {
			this.readUSB();
		}
	}

	@Override
	public void readUSB() {
		System.out.println("USB를 읽습니다.");
	}

	@Override
	public void runApp() {
		if (!this.isOn) {
			return;
		}
		this.activeAppIndex = (this.activeAppIndex + 1) % (APPS.length);
		System.out.println("현재 실행 중인 앱은 " + APPS[activeAppIndex] + " 입니다.");
	}

	@Override
	public void mute() {
		this.volume = 0;
		System.out.println("음소거되었습니다.");
	}

	@Override
	public void changeChannel(int channelNumber) {
		for (int i = 0; i < TV.CHANNELS.length; ++i) {
			if (TV.CHANNELS[i] == channelNumber + "") {
				this.channelIndex = i;
				break;
			}
		}
		System.out.println("현재 채널은 " + TV.CHANNELS[channelIndex] + " 입니다.");
	}
}
