package com.ktdsuniversity.edu.oop.inheritance.animalia;

public class Amphibian extends Animalia {

	private int moistureLevel;
	private boolean hasGills;
	private boolean isMetamorphosed;
	private int clutchSize;

	public Amphibian(int height, int weight, int width, int birthYear, Gender gender, String name, Habitat[] habitats,
			int moistureLevel, boolean hasGills, boolean isMetamorphosed, int clutchSize) {
		super(height, weight, width, birthYear, gender, name, habitats);
		this.moistureLevel = moistureLevel;
		this.hasGills = hasGills;
		this.isMetamorphosed = isMetamorphosed;
		this.clutchSize = clutchSize;
	}

	public int getMoistureLevel() {
		return moistureLevel;
	}

	public boolean isHasGills() {
		return hasGills;
	}

	public boolean isMetamorphosed() {
		return isMetamorphosed;
	}

	public int getClutchSize() {
		return clutchSize;
	}

}
