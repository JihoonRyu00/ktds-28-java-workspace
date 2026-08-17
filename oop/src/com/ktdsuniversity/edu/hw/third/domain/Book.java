package com.ktdsuniversity.edu.hw.third.domain;

import java.time.LocalDate;

import com.ktdsuniversity.edu.hw.third.enums.Genre;

public class Book {

	private final String ISBN;

	private Genre genre;
	private LocalDate publicationDate;
	private String title;
	private String subtitle;
	private String publisher;
	private String author;
	private int edition;
	private int price;
	private int totalRentalCount;

	public Book(String ISBN, Genre genre, LocalDate publicationDate, String title, String subtitle, String publisher,
			String author, int edition, int price) {
		this.ISBN = ISBN;
		this.genre = genre;
		this.publicationDate = publicationDate;
		this.title = title;
		this.subtitle = subtitle;
		this.publisher = publisher;
		this.author = author;
		this.edition = edition;
		this.price = price;
		this.totalRentalCount = 0;
	}

	public String getISBN() {
		return this.ISBN;
	}

	public Genre getGenre() {
		return this.genre;
	}

	public LocalDate getPublicationDate() {
		return this.publicationDate;
	}

	public String getTitle() {
		return this.title;
	}

	public String getSubtitle() {
		return this.subtitle;
	}

	public String getPublisher() {
		return this.publisher;
	}

	public String getAuthor() {
		return this.author;
	}

	public int getEdition() {
		return this.edition;
	}

	public int getPrice() {
		return this.price;
	}

	public int getTotalRentalCount() {
		return this.totalRentalCount;
	}

	public void increaseTotalRentalCount() {
		this.totalRentalCount++;
	}

	public void setTotalRentalCount(int count) {
		this.totalRentalCount = count;
	}

	public String toCsvRow() {
		return String.join(",", this.ISBN, this.genre.name(), this.publicationDate.toString(), this.title,
				this.subtitle, this.publisher, this.author, this.edition + "", this.price + "",
				this.totalRentalCount + "");
	}

	@Override
	public String toString() {
		return "Book [ISBN=" + ISBN + ", genre=" + genre + ", publicationDate=" + publicationDate + ", title=" + title
				+ ", subtitle=" + subtitle + ", publisher=" + publisher + ", author=" + author + ", edition=" + edition
				+ ", price=" + price + ", totalRentalCount=" + totalRentalCount + "]";
	}

}
