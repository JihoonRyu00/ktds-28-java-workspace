package com.ktdsuniversity.edu.oop.inheritance.animalia;

public class Animalia {

	public enum Gender {
		MALE, FEMALE, UNKNOWN
	}

	public enum Habitat {
		TERRESTRIAL, FRESHWATER, MARINE, ESTUARINE, ARBOREAL, AERIAL, SUBTERRANEAN
	}

	private int height;
	private int weight;
	private int width;
	private int birthYear;
	private Gender gender;
	private String name;
	private Habitat[] habitats;

	public Animalia(int height, int weight, int width, int birthYear, Gender gender, String name, Habitat[] habitats) {
		this.height = height;
		this.weight = weight;
		this.width = width;
		this.birthYear = birthYear;
		this.gender = gender;
		this.name = name;
		this.habitats = habitats;
	}

	public int getHeight() {
		return this.height;
	}

	public int getWeight() {
		return this.weight;
	}

	public int getWidth() {
		return this.width;
	}

	public int getBirthYear() {
		return this.birthYear;
	}

	public Gender getGender() {
		return this.gender;
	}

	public String getName() {
		return this.name;
	}

	public Habitat[] getHabitats() {
		return habitats;
	}

}
