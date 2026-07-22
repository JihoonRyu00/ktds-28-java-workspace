package com.ktdsuniversity.edu.oop.manhwacafe;

/** 만화 카페 클래스 */
public class ManhwaCafe {

	private final int SHELF_SIZE = 100;

	private int balance;
	private Manhwa[] manhwaList;

	public ManhwaCafe() {
		this.setManhwaList(new Manhwa[SHELF_SIZE]);
		System.out.println("만화 카페가 생성 되었습니다.");
	}

	public ManhwaCafe(int balance) {
		this();
		this.setBalance(balance);
	}

	private int getShelfSize() {
		return SHELF_SIZE;
	}

	private int getBalance() {
		return balance;
	}

	private void setBalance(int balance) {
		this.balance = balance;
	}

	public Manhwa[] getManhwaList() {
		return manhwaList;
	}

	private void setManhwaList(Manhwa[] manhwaList) {
		this.manhwaList = manhwaList;
	}

	public void addNewManhwa(int index, Manhwa manhwa) {
		if (this.manhwaList[index] != null) {
			System.out.println("해당 카페 인덱스에는 이미 만화책이 존재합니다.");
			return;
		}
		this.manhwaList[index] = manhwa;
		System.out.println(index + "번째 칸에 " + manhwa.getName() + "을 추가하였습니다.");
	}

	public void printManhwaList() {
		System.out.println("======= 전체 만화 목록 =======");
		for (int i = 0; i < SHELF_SIZE; ++i) {
			Manhwa manhwa = manhwaList[i];
			if (manhwa != null) {
				System.out.println(manhwa.getID() + ".\t" + manhwa.getName() + "\t" + manhwa.isRentPossible());
			}
		}
		System.out.println("===========================");
	}

	private void increaseBalance(int cash) {
		this.setBalance(this.getBalance() + cash);
	}

	public boolean isValidIndex(int index) {
		return (index >= 0 || index < this.getShelfSize());
	}

	public void rentProcess(Customer customer, int customerManhwaIndex, int cafeManhwaIndex) {
		Manhwa manhwa = this.manhwaList[cafeManhwaIndex];
		if (!this.isValidIndex(cafeManhwaIndex)) {
			System.out.println("해당 카페 인덱스는 존재하지 않습니다.");
			return;
		}
		if (!customer.isValidIndex(customerManhwaIndex)) {
			System.out.println("해당 대여자 인덱스는 존재하지 않습니다.");
			return;
		}
		if (manhwa == null) {
			System.out.println("해당 카페 인덱스에는 만화책이 존재하지 않습니다.");
			return;
		}
		if (customer.getRentingManhwas()[customerManhwaIndex] != null) {
			System.out.println("해당 대여자 인덱스에는 이미 만화책이 존재합니다.");
			return;
		}
		if (manhwa.isRented()) {
			System.out.println("이미 대여 중인 책입니다.");
			return;
		}
		if (!customer.pay(manhwa.getFee(), this)) {
			System.out.println("소비자의 잔고가 부족합니다.");
			return;
		}
		customer.getRentingManhwas()[customerManhwaIndex] = manhwa;
		this.increaseBalance(manhwa.getFee());
		manhwa.setRented(true);
		System.out.println("대여가 완료되었습니다.");
	}

	public void returnProcess(Customer customer, int customerManhwaIndex, int cafeManhwaIndex) {
		Manhwa manhwa = customer.getRentingManhwas()[customerManhwaIndex];
		if (manhwa == null) {
			System.out.println("해당 대여자 인덱스에는 만화책이 존재하지 않습니다.");
			return;
		}
		manhwa.setRented(false);
		customer.getRentingManhwas()[customerManhwaIndex] = null;
		System.out.println("반납이 완료되었습니다.");
	}
}
