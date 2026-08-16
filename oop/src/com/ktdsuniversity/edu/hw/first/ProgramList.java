package com.ktdsuniversity.edu.hw.first;

import java.util.List;

public class ProgramList {

	private ProgramList() {
	}

	public static List<Program> makeDishList() {
		return List.of(new Program("프로그램 1", "03:00", "05:00"), new Program("프로그램 2", "05:01", "06:30"),
				new Program("프로그램 3", "06:31", "08:00"), new Program("프로그램 4", "08:01", "09:00"),
				new Program("프로그램 5", "09:01", "10:00"), new Program("프로그램 6", "10:01", "12:00"),
				new Program("프로그램 7", "12:01", "13:30"), new Program("프로그램 8", "13:31", "15:00"),
				new Program("프로그램 9", "15:01", "17:00"), new Program("프로그램 10", "17:01", "18:00"),
				new Program("프로그램 11", "18:01", "21:00"), new Program("프로그램 12", "21:01", "23:00"),
				new Program("프로그램 13", "23:01", "23:59"));
	}
}
