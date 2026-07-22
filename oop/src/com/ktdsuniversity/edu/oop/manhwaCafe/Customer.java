package com.ktdsuniversity.edu.oop.manhwaCafe;

/** 소비자 클래스 */
public class Customer {

	private final String ID;
	private final int MAX_RENT = 10;

	private int balance;
	private Manhwa[] rentingManhwas;

	public Customer(String ID) {
		this.ID = ID;
		this.setBalance(0);
		this.setRentingManhwas(new Manhwa[MAX_RENT]);
	}

	public Customer(String ID, int balance) {
		this(ID);
		this.setBalance(balance);
	}

	public String getID() {
		return ID;
	}

	public int getMaxRent() {
		return MAX_RENT;
	}

	public int getBalance() {
		return balance;
	}

	private void setBalance(int balance) {
		this.balance = balance;
	}

	public Manhwa[] getRentingManhwas() {
		return rentingManhwas;
	}

	private void setRentingManhwas(Manhwa[] rentingManhwas) {
		this.rentingManhwas = rentingManhwas;
	}

	public void printRentingManhwas() {

		System.out.println("===== 대여중인 만화 목록 =====");
		for (int i = 0; i < MAX_RENT; ++i) {
			Manhwa manhwa = rentingManhwas[i];
			if (manhwa != null) {
				System.out.println(manhwa.getID() + ".\t" + manhwa.getName());
			}
		}
		System.out.println("===========================");
	}

	public boolean isValidIndex(int index) {
		return (index >= 0 || index < this.getMaxRent());
	}

	private boolean hasSufficientBalance(int fee) {
		return this.balance >= fee;
	}

	public boolean pay(int fee, ManhwaCafe mc) {
		if (!this.hasSufficientBalance(fee)) {
			return false;
		}
		this.balance -= fee;
		return true;
	}
}
