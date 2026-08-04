package com.ktdsuniversity.edu.oop.datetime;

import java.time.LocalDate;
import java.time.Period;

public class Friend {

	private String name;
	private int age;
	private LocalDate birthdate; // 1985-11-16

	public Friend(String name, LocalDate birthdate) {
		this.name = name;
		this.birthdate = birthdate;

		Period period = Period.between(birthdate, LocalDate.now());
		this.age = period.getYears();
	}

	public String getName() {
		return this.name;
	}

	public int getAge() {
		return this.age;
	}

	public LocalDate getBirthdate() {
		return this.birthdate;
	}

	@Override
	public String toString() {
		return "Friend [name=" + name + ", age=" + age + ", birthdate=" + birthdate + "]";
	}

}