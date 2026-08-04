package com.ktdsuniversity.edu.oop.datetime;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Talk {

	public static void main(String[] args) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("y-M-d");
		Friends talk = new Friends();
		int year = 0;
		int month = 0;
		int day = 0;
		for (int i = 1; i <= 500; ++i) {
			year = (int) (Math.random() * 20) + 1990 + 1;
			month = (int) (Math.random() * 12) + 1;
//			month = 2;
			day = 0;
			if (month == 2 && year % 4 == 0) {
				day = (int) (Math.random() * 29) + 1;
//				day = 29;
			} else if (month == 2) {
				day = (int) (Math.random() * 28) + 1;
//				day = 28;
			} else if (month == 4 || month == 6 || month == 9 || month == 11) {
				day = (int) (Math.random() * 30) + 1;
			} else {
				day = (int) (Math.random() * 31) + 1;
			}
			talk.addFriend(new Friend("친구" + i, LocalDate.parse("%d-%d-%d".formatted(year, month, day), formatter)));
		}
		System.out.println(talk);
		System.out.println();
		System.out.println(talk.findFriendsBy(3).toString().replaceAll("\\[F", "\\[\nF").replaceAll(", F", ",\nF")
				.replaceAll("\\]\\]", "\\]\n\\]"));
	}
}
