package com.ktdsuniversity.edu.hw.first;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Schedule {

	public static String nowAirProgram(List<Program> programList, LocalTime now) {
		for (Program p : programList) {
			if (p.isAirTime(now)) {
				return p.getName();
			}
		}
		return "방영중인 시간이 아닙니다.";
	}

	public static void main(String[] args) {
		List<Program> programList = ProgramList.makeDishList();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
		
		LocalTime time1 = LocalTime.parse("10:34", formatter);
		System.out.println(Schedule.nowAirProgram(programList, time1));
		
		LocalTime time2 = LocalTime.parse("01:11", formatter);
		System.out.println(Schedule.nowAirProgram(programList, time2));
		
		LocalTime now = LocalTime.now();
		System.out.println(Schedule.nowAirProgram(programList, now));
	}
}
