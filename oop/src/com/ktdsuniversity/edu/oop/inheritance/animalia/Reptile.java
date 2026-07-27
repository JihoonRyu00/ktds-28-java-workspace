package com.ktdsuniversity.edu.oop.inheritance.animalia;

public class Reptile extends Animalia {

	public enum ScaleType {
		SMOOTH, KEELED, GRANULAR, SCUTE, TUBERCULAR, SPIKY
	}

	private ScaleType scaleType;
	private boolean isVenomous;
	private int sheddingFrequency;
	private boolean isColdBlooded;

	public Reptile(int height, int weight, int width, int birthYear, Gender gender, String name, Habitat[] habitats,
			ScaleType scaleType, boolean isVenomous, int sheddingFrequency, boolean isColdBlooded) {
		super(height, weight, width, birthYear, gender, name, habitats);
		this.scaleType = scaleType;
		this.isVenomous = isVenomous;
		this.sheddingFrequency = sheddingFrequency;
		this.isColdBlooded = isColdBlooded;
	}

	public ScaleType getScaleType() {
		return this.scaleType;
	}

	public boolean isVenomous() {
		return this.isVenomous;
	}

	public int getSheddingFrequency() {
		return this.sheddingFrequency;
	}

	public boolean isColdBlooded() {
		return this.isColdBlooded;
	}
}
