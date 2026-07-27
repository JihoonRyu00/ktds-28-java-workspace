package com.ktdsuniversity.edu.oop.inheritance.animalia;

public class Fish extends Animalia {

	public enum WaterType {
		FRESHWATER, BRACKISH, MARINE, PELAGIC, HYPERSALINE
	}

	private int finCount;
	private int swimDepth;
	private boolean hasScales;
	private WaterType waterType;

	public Fish(int height, int weight, int width, int birthYear, Gender gender, String name, Habitat[] habitats,
			int finCount, int swimDepth, boolean hasScales, WaterType waterType) {
		super(height, weight, width, birthYear, gender, name, habitats);
		this.finCount = finCount;
		this.swimDepth = swimDepth;
		this.hasScales = hasScales;
		this.waterType = waterType;
	}

	public int getFinCount() {
		return this.finCount;
	}

	public int getSwimDepth() {
		return this.swimDepth;
	}

	public boolean isHasScales() {
		return this.hasScales;
	}

	public WaterType getWaterType() {
		return this.waterType;
	}

}
