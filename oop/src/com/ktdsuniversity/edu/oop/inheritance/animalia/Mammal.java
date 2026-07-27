package com.ktdsuniversity.edu.oop.inheritance.animalia;

public class Mammal extends Animalia {

	private String furColor;
	private int bodyTemperature;
	private int gestationPeriod; // months

	public Mammal(int height, int weight, int width, int birthYear, Gender gender, String name, Habitat[] habitats,
			String furColor, int bodyTemperature, int gestationPeriod) {
		super(height, weight, width, birthYear, gender, name, habitats);
		this.furColor = furColor;
		this.bodyTemperature = bodyTemperature;
		this.gestationPeriod = gestationPeriod;
	}

	public String getFurColor() {
		return furColor;
	}

	public int getBodyTemperature() {
		return bodyTemperature;
	}

	public int getGestationPeriod() {
		return gestationPeriod;
	}
}
