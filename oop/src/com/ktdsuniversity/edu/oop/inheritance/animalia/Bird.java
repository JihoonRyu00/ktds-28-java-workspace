package com.ktdsuniversity.edu.oop.inheritance.animalia;

public class Bird extends Animalia {

	public enum BeakShape {
		CONICAL, // 씨앗용 (참새)
		HOOKED, // 고기용 (독수리)
		SPEAR, // 물고기용 (외가리)
		FLAT_BILL, // 여과용 (오리)
		PROBING, // 흙속 탐사용 (도요새)
		TUBULAR, // 꿀 채집용 (벌새)
		CHISEL // 나무뚫기용 (딱따구리)
	}

	private int wingSpan;
	private String featherColor;
	private boolean canFly;
	private BeakShape beakShape;

	public Bird(int height, int weight, int width, int birthYear, Gender gender, String name, Habitat[] habitats,
			int wingSpan, String featherColor, boolean canFly, BeakShape beakShape) {
		super(height, weight, width, birthYear, gender, name, habitats);
		this.wingSpan = wingSpan;
		this.featherColor = featherColor;
		this.canFly = canFly;
		this.beakShape = beakShape;
	}

	public int getWingSpan() {
		return this.wingSpan;
	}

	public String getFeatherColor() {
		return this.featherColor;
	}

	public boolean isCanFly() {
		return this.canFly;
	}

	public BeakShape getBeakShape() {
		return this.beakShape;
	}
}
