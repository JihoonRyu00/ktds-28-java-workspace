package com.ktdsuniversity.edu.oop.collection.list;

import java.util.ArrayList;
import java.util.List;

import com.ktdsuniversity.edu.oop.manhwacafe.Manhwa;

/** 만화 카페 클래스 */
public class ManhwaCafe {

	private int balance;
	private List<Manhwa> manhwaList;

	public ManhwaCafe() {
		this.manhwaList = new ArrayList<>();
		System.out.println("만화 카페가 생성 되었습니다.");
	}

	public ManhwaCafe(int balance) {
		this();
		this.setBalance(balance);
	}

	private int getBalance() {
		return balance;
	}

	private void setBalance(int balance) {
		this.balance = balance;
	}

	public List<Manhwa> getManhwaList() {
		return manhwaList;
	}

	public void addNewManhwa(Manhwa manhwa) {
		this.manhwaList.add(manhwa);
		System.out.println(manhwa.getName() + "을 추가하였습니다.");
	}

	public void printManhwaList() {
		System.out.println("======= 전체 만화 목록 =======");
		for (int i = 0; i < manhwaList.size(); ++i) {
			Manhwa manhwa = manhwaList.get(i);
			System.out.println(manhwa.getID() + ".\t" + manhwa.getName() + "\t" + manhwa.isRentPossible());
		}
		System.out.println("===========================");
	}

	private void increaseBalance(int cash) {
		this.setBalance(this.getBalance() + cash);
	}

	public void rentProcess(Customer customer, int cafeManhwaIndex) {
		if (cafeManhwaIndex < 0 && cafeManhwaIndex >= this.manhwaList.size()) {
			System.out.println("해당 카페 인덱스는 존재하지 않습니다.");
			return;
		}
		Manhwa manhwa = this.manhwaList.get(cafeManhwaIndex);
		if (manhwa.isRented()) {
			System.out.println("이미 대여 중인 책입니다.");
			return;
		}
		if (!customer.pay(manhwa.getFee(), this)) {
			System.out.println("소비자의 잔고가 부족합니다.");
			return;
		}
		customer.getRentingManhwas().add(manhwa);
		this.increaseBalance(manhwa.getFee());
		manhwa.setRented(true);
		System.out.println("대여가 완료되었습니다.");
	}

	public void returnProcess(Customer customer, int customerManhwaIndex, int cafeManhwaIndex) {
		if (customerManhwaIndex < 0 && customerManhwaIndex >= customer.getRentingManhwas().size()) {
			System.out.println("해당 대여자 인덱스에는 만화책이 존재하지 않습니다.");
			return;
		}
		Manhwa manhwa = customer.getRentingManhwas().get(customerManhwaIndex);
		manhwa.setRented(false);
		System.out.println("반납이 완료되었습니다.");
	}
}
