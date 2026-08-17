package com.ktdsuniversity.edu.hw.third.domain;

import java.util.ArrayList;
import java.util.List;

public class Member {

	private final long id;
	private List<BookCopy> rentedBooks;
	private String name;
	private String contact;
	private int fine;
	private int overdueCount;

	public Member(long id, String name, String contact) {
		this.id = id;
		this.rentedBooks = new ArrayList<>();
		this.name = name;
		this.contact = contact;
		this.fine = 0;
		this.overdueCount = 0;
	}

	public long getId() {
		return this.id;
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

	public void setFine(int fine) {
		this.fine = fine;
	}

	public void setOverdueCount(int count) {
		this.overdueCount = count;
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

	public String toCsvRow() {
		return String.join(",", this.id + "", this.name, this.contact, this.fine + "", this.overdueCount + "");
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", rentedBooks=" + rentedBooks + ", name=" + name + ", contact=" + contact
				+ ", fine=" + fine + ", overdueCount=" + overdueCount + "]";
	}

}
