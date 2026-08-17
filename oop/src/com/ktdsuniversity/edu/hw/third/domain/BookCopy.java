package com.ktdsuniversity.edu.hw.third.domain;

import java.time.LocalDate;

public class BookCopy {

	private final long accessionNumber;
	private Book originalBook;
	private Member renter;
	private LocalDate inboundDate;
	private LocalDate rentalDate;
	private LocalDate returnDate;
	private boolean isRented;
	private boolean isReturned;
	private boolean isDiscarded;

	public BookCopy(long accessionNumber, Book originalBook, LocalDate inboundDate) {
		this.accessionNumber = accessionNumber;
		this.originalBook = originalBook;
		this.renter = null;
		this.inboundDate = inboundDate;
		this.rentalDate = null;
		this.returnDate = null;
		this.isRented = false;
		this.isReturned = true;
		this.isDiscarded = false;
	}

	public long getAccessionNumber() {
		return this.accessionNumber;
	}

	public Book getOriginalBook() {
		return this.originalBook;
	}

	public Member getRenter() {
		return this.renter;
	}

	public LocalDate getInboundDate() {
		return this.inboundDate;
	}

	public LocalDate getRentalDate() {
		return this.rentalDate;
	}

	public LocalDate getReturnDate() {
		return this.returnDate;
	}

	public boolean isRented() {
		return this.isRented;
	}

	public boolean isReturned() {
		return this.isReturned;
	}

	public boolean isDiscarded() {
		return this.isDiscarded;
	}

	public void setRenter(Member renter) {
		this.renter = renter;
	}

	public void setRentalDate(LocalDate rentalDate) {
		this.rentalDate = rentalDate;
	}

	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}

	public void setRented(boolean isRented) {
		this.isRented = isRented;
	}

	public void setReturned(boolean isReturned) {
		this.isReturned = isReturned;
	}

	public void setDiscarded() {
		this.isDiscarded = true;
	}

	public void rentTo(Member member) {
		this.isRented = true;
		this.rentalDate = LocalDate.now();
		this.returnDate = LocalDate.now().plusDays(7);
		this.renter = member;
		this.originalBook.increaseTotalRentalCount();
	}

	public void resetRentalStatus() {
		this.renter = null;
		this.rentalDate = null;
		this.returnDate = null;
		this.isRented = false;
		this.isReturned = true;
	}

	public String toCsvRow() {
		String renterId = (this.renter != null) ? this.renter.getId() + "" : "NONE";
		String rentalDateStr = (this.rentalDate != null) ? this.rentalDate.toString() : "NONE";
		String returnDateStr = (this.returnDate != null) ? this.returnDate.toString() : "NONE";
		return String.join(",", this.accessionNumber + "", this.originalBook.getISBN(), this.inboundDate.toString(),
				this.isRented + "", rentalDateStr, returnDateStr, this.isReturned + "", this.isDiscarded + "",
				renterId);
	}

	@Override
	public String toString() {
		String renterName = (renter != null) ? renter.getName() : "null";
		return "BookCopy [accessionNumber=" + accessionNumber + ", originalBook=" + originalBook + ", renter="
				+ renterName + ", inboundDate=" + inboundDate + ", rentalDate=" + rentalDate + ", returnDate="
				+ returnDate + ", isRented=" + isRented + ", isReturned=" + isReturned + ", isDiscarded=" + isDiscarded
				+ "]";
	}

}
