package com.ktdsuniversity.edu.oop.manhwaCafe;

/** 만화책 클래스 */
public class Manhwa {
	private final String ID;

	private String name;
	private int fee;
	private boolean isRented;

	Manhwa(String ID, String name, int fee) {
		this.ID = ID;
		this.setName(name);
		this.setFee(fee);
		this.setRented(false);
	}

	public String getID() {
		return ID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}

	public boolean isRented() {
		return isRented;
	}

	public void setRented(boolean isRented) {
		this.isRented = isRented;
	}

	public String isRentPossible() {
		if (this.isRented) {
			return "대여 불가";
		}
		return "대여 가능";
	}
}
