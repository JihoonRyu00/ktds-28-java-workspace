package com.ktdsuniversity.edu.hw.first;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Program {

	private String name;
	private LocalTime startTime;
	private LocalTime endTime;

	public Program(String name, String startTime, String endTime) {
		this.name = name;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:m");
		this.startTime = LocalTime.parse(startTime, formatter);
		this.endTime = LocalTime.parse(endTime, formatter);
	}

	public Program(String name, int startTime, int endTime) {
		// valid check 생략
		this(name, startTime / 60 + ":" + startTime % 60, endTime / 60 + ":" + endTime % 60);
	}

	public LocalTime getStartTime() {
		return this.startTime;
	}

	public LocalTime getEndTime() {
		return this.endTime;
	}

	public String getName() {
		return this.name;
	}

	public boolean isAirTime(LocalTime now) {
		return !(now.isBefore(startTime) || now.isAfter(endTime));
	}

	@Override
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
		return this.name + "\n시작시간: " + startTime.format(formatter) + " 종료시간: " + endTime.format(formatter);
	}
}
