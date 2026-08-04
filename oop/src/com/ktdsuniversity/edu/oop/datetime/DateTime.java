package com.ktdsuniversity.edu.oop.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateTime {

	public static void printNowDate() {
		LocalDate now = LocalDate.now();
		System.out.println(now);
	}

	public static void printNowTime() {
		LocalTime now = LocalTime.now();
		System.out.println(now);
	}

	public static void printNowDateTime() {
		LocalDateTime now = LocalDateTime.now();
		System.out.println(now);
	}

	public static void setAndPrintDate(int year, Month month, int day) {
		LocalDate then = LocalDate.of(year, month, day);
		System.out.println(then);
	}

	public static void setAndPrintTime(int hour, int miniute, int second) {
		LocalTime then = LocalTime.of(hour, miniute, second);
		System.out.println(then);
	}

	public static void setAndPrintDateTime(int year, int month, int day, int hour, int miniute, int second) {
		LocalDateTime then = LocalDateTime.of(year, month, month, hour, miniute, second);
		System.out.println(then);
	}

	public static void setAndPrintDateString(String date) {
		LocalDate then = LocalDate.parse(date);
		System.out.println(then);
	}

	public static void setAndPrintTimeString(String time) {
		LocalTime then = LocalTime.parse(time);
		System.out.println(then);
	}

	public static void setAndPrintDateTimeString(String dateTime) {
		LocalDateTime then = LocalDateTime.parse(dateTime);
		System.out.println(then);
	}

	public static void printNowDateWithformat() {
		LocalDate now = LocalDate.now();
		System.out.println("기본: " + now);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMdd");
		System.out.println("포맷 후: " + now.format(formatter));
	}

	public static void printNowTimeWithformat() {
		LocalTime now = LocalTime.now();
		System.out.println("기본: " + now);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("a hh:mm:ss.n");
		System.out.println("포맷 후: " + now.format(formatter));
	}

	public static void printNowDateTimeWithformat() {
		LocalDateTime now = LocalDateTime.now();
		System.out.println("기본: " + now);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("G yyMMdd EEEE a hh:mm:ss.n");
		System.out.println("포맷 후: " + now.format(formatter));
	}

	public static void setAndPrintDateWithFormat(String date, String pattern) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
		LocalDate then = LocalDate.parse(date, formatter);
		System.out.println(then);
	}

	public static void setAndPrintTimeWithFormat(String time, String pattern) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
		LocalTime then = LocalTime.parse(time, formatter);
		System.out.println(then);
	}

	public static void setAndPrintDateTimeWithFormat(String dateTime, String pattern) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
		LocalDateTime then = LocalDateTime.parse(dateTime, formatter);
		System.out.println(then);
	}

	public static void plusAndPrintDatefromNow() {
		LocalDate now = LocalDate.now();
		System.out.println(now.plusYears(7));
		System.out.println(now.plusDays(365 * 7));
		System.out.println(now.plusDays(30 * 12 * 7));
	}

	public static void printPeriodFromTo(LocalDate from, LocalDate to) {
		Period p = Period.between(from, to);
		System.out
				.println("%s부터 %s까지 %d년 %d개월 %d일 지났습니다.".formatted(from, to, p.getYears(), p.getMonths(), p.getDays()));
		long days = ChronoUnit.DAYS.between(from, to);
		System.out.println("%s부터 %s까지 %d일 지났습니다.".formatted(from, to, days));
		long hours = days * 24;
		System.out.println("%s부터 %s까지 %d시간 지났습니다.".formatted(from, to, hours));
	}

	public static void printIsFuture(LocalDate date) {
		if (date.isAfter(LocalDate.now())) {
			System.out.print(date + " is future date");
		} else {
			System.out.print(date + " is not future date");
		}
		System.out.println(" than " + LocalDate.now() + ".");
	}

	public static void printIsPast(LocalDate date) {
		if (date.isBefore(LocalDate.now())) {
			System.out.print(date + " is past date");
		} else {
			System.out.print(date + " is not past date");
		}
		System.out.println(" than " + LocalDate.now() + ".");
	}

	public static void printIsToday(LocalDate date) {
		if (date.isEqual(LocalDate.now())) {
			System.out.println(date + " is today.");
		} else {
			System.out.println(date + " is not today.");
		}
	}

	public static void printChangeToThisYear() {
		LocalDate now = LocalDate.now();
		System.out.println(now.withYear(2000));
	}

	public static void main(String[] args) {

		printNowDate();
		printNowTime();
		printNowDateTime();

		setAndPrintDate(2000, Month.NOVEMBER, 30);
//		setAndPrintDate(2026, Month.FEBRUARY, 29); // java.time.DateTimeException
		setAndPrintTime(0, 1, 1);
//		setAndPrintTime(24, 1, 1); // java.time.DateTimeException
//		setAndPrintTime(25, 1, 1); // java.time.DateTimeException
		setAndPrintDateTime(1988, 8, 18, 8, 18, 18);

		setAndPrintDateString("2007-12-03");
		setAndPrintTimeString("10:15:30");
		setAndPrintDateTimeString("2007-12-03T10:15:30");

		// 날짜 포맷 -> 날짜를 표현하는 방법 (yyyy년 MM월 dd일)
		// 시각 포맷 -> 시간을 표현하는 방법 (HH시 mm분 ss초)
		printNowDateWithformat();
		printNowTimeWithformat();
		printNowDateTimeWithformat();

		setAndPrintDateWithFormat("2007-12-03", "yyyy-MM-dd");
		setAndPrintDateWithFormat("2007년 12월 03일", "yyyy년 MM월 dd일");

		setAndPrintTimeWithFormat("(오전) 01시 01분 01초", "(a) hh시 mm분 ss초");
//		setAndPrintTimeWithFormat("13시 01분 01초", "hh시 mm분 ss초");
		setAndPrintTimeWithFormat("13시 01분 01초", "HH시 mm분 ss초");
		setAndPrintTimeWithFormat("오전 01:01:01.999999999", "a hh:mm:ss.n");

		// 88 -> 2088
		setAndPrintDateTimeWithFormat("880818 (오전) 01시 01분 01초", "yyMMdd (a) hh시 mm분 ss초");

		plusAndPrintDatefromNow();

		printPeriodFromTo(LocalDate.parse("2000-11-30"), LocalDate.now());

		printIsFuture(LocalDate.parse("2026-08-03"));
		printIsFuture(LocalDate.parse("2026-08-04"));
		printIsFuture(LocalDate.parse("2026-08-05"));

		printIsPast(LocalDate.parse("2026-08-03"));
		printIsPast(LocalDate.parse("2026-08-04"));
		printIsPast(LocalDate.parse("2026-08-05"));

		printIsToday(LocalDate.parse("2026-08-03"));
		printIsToday(LocalDate.parse("2026-08-04"));
		printIsToday(LocalDate.parse("2026-08-05"));

		printChangeToThisYear();
	}

}
