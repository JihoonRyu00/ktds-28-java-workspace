package com.ktdsuniversity.edu.hw.third;

import java.util.ArrayList;
import java.util.List;

public class Member {

	private List<BookCopy> rentedBooks;
	private String name;
	private String contact;
	private int fine;
	private int overdueCount;

	public Member(String name, String contact) {
		this.rentedBooks = new ArrayList<>();
		this.name = name;
		this.contact = contact;
		this.fine = 0;
		this.overdueCount = 0;
	}

	public List<BookCopy> getRentedBooks() {
		return this.rentedBooks;
	}

	public String getName() {
		return this.name;
	}

	public String getContact() {
		return this.contact;
	}

	public int getFine() {
		return this.fine;
	}

	public int getOverdueCount() {
		return this.overdueCount;
	}

	public void updateFine(int amount) {
		this.fine += amount;
	}

	public void increaseOverdueCount() {
		this.overdueCount++;
	}

	public void rentBook(BookCopy book) {
		this.rentedBooks.add(book);
	}

	public void returnBook(BookCopy book) {
		this.rentedBooks.remove(book);
	}

	public boolean hasRentedBooks() {
		return !this.rentedBooks.isEmpty();
	}

	public boolean isRenting(BookCopy book) {
		return this.rentedBooks.contains(book);
	}

	@Override
	public String toString() {
		return "이름: " + this.name + " 연락처: " + this.contact + "\n벌금: " + this.fine + " 반납기간 초과 횟수: " + this.overdueCount
				+ "\n대여한 도서의 목록:\n" + this.rentedBooks;
	}
}
