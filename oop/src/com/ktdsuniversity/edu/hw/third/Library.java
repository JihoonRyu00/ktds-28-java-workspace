package com.ktdsuniversity.edu.hw.third;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import com.ktdsuniversity.edu.hw.third.enums.Genre;

public class Library {

	private long nextAccessionNumber;
	private List<BookCopy> books;
	private List<Member> members;

	public Library() {
		this.nextAccessionNumber = 1;
		this.books = new ArrayList<>();
		this.members = new ArrayList<>();
	}

	public long getNextAccessionNumber() {
		return this.nextAccessionNumber;
	}

	public List<BookCopy> getBooks() {
		return this.books;
	}

	public List<Member> getMembers() {
		return this.members;
	}

	public void stockNewBook(Book book) {
		this.books.add(new BookCopy(nextAccessionNumber++, book, LocalDate.now()));
	}

	public void discardOldBooks() {
		List<BookCopy> oldBooks = this.books.stream() // Stream<BookCopy>
				.filter(book -> {
					LocalDate pubDate = book.getOriginalBook().getPublicationDate();
					return pubDate.plusYears(10).isBefore(LocalDate.now());
				}) // Stream<BookCopy>
//				.map(BookCopy::getACCESSION_NUMBER) // Stream<Long>
				.toList() // List<BookCopy
		;
//		for (BookCopy bc : oldBooks) {
//			this.books.remove(bc);
//			if (bc.getRenter() == null) {
//				continue;
//			}
//			bc.getRenter().getRentedBooks().remove(bc);
//		}
		this.books.removeAll(oldBooks);
		oldBooks.stream() // Stream<BookCopy>
				.forEach(BookCopy::setDiscarded) // void
		;
	}

	public void printOverdueOrDueSoonMembers() {
		this.members.stream() // Stream<Member>
				.filter(member -> {
					return member.getRentedBooks().stream() // Stream<Book>
							.anyMatch(book -> book.getReturnDate().plusDays(-2).isBefore(LocalDate.now())) // boolean
					;
				}) // Stream<Member>
				.forEach(System.out::println) // void
		;

	}

	public void printPopularityRank() {
		this.books.stream() // Stream<BookCopy>
				.map(BookCopy::getOriginalBook) // Stream<Book>
				.distinct() // Stream<Book>
				.sorted((a, b) -> b.getTotalRentalCount() - a.getTotalRentalCount()) // Stream<Book>
				.forEach(System.out::println) // void
		;
	}

	public void printOverdueRank() {
		this.members.stream() // Stream<Member>
				.sorted((a, b) -> b.getOverdueCount() - a.getOverdueCount()) // Stream<Member>
				.forEach(System.out::println) // void
		;
	}

	public void printSearchByPublisher(String publisher) {
		this.books.stream() // Stream<BookCopy>
				.map(BookCopy::getOriginalBook) // Stream<Book>
				.distinct() // Stream<Book>
				.filter(book -> book.getPublisher().equals(publisher)) // Stream<Book>
				.forEach(System.out::println) // void
		;
	}

	public void printSearchByAuthor(String author) {
		this.books.stream() // Stream<BookCopy>
				.map(BookCopy::getOriginalBook) // Stream<Book>
				.distinct() // Stream<Book>
				.filter(book -> book.getAuthor().equals(author)) // Stream<Book>
				.forEach(System.out::println) // void
		;
	}

	public void printSearchByGenre(Genre genre) {
		this.books.stream() // Stream<BookCopy>
				.map(BookCopy::getOriginalBook) // Stream<Book>
				.distinct() // Stream<Book>
				.filter(book -> book.getGenre().equals(genre)) // Stream<Book>
				.forEach(System.out::println) // void
		;
	}

	public void rentBook(Member member, BookCopy book) {
		if (member.getOverdueCount() >= 3) {
			System.out.println("반납기간 초과 횟수가 3회 이상인 회원은 책을 대여할 수 없습니다.");
			return;
		}
		if (book.isRented()) {
			System.out.println("대여중인 도서는 대여할 수 없습니다.");
			return;
		}
		book.rentTo(member);
		member.rentBook(book);
	}

	public void returnBook(Member member, BookCopy book) {
		if (!member.hasRentedBooks()) {
			System.out.println("대여 중인 책이 없습니다.");
			return;
		}
		if (!member.isRenting(book)) {
			System.out.println("해당 책을 대여하고 있지 않습니다.");
			return;
		}
		if (book.isDiscarded()) {
			System.out.println("폐기 처리된 도서는 반납할 필요 없습니다.");
			return;
		}
		if (book.getReturnDate().isBefore(LocalDate.now())) {
			int overdueDays = Period.between(book.getReturnDate(), LocalDate.now()).getDays();
			member.updateFine(overdueDays * 500);
			member.increaseOverdueCount();
		}
		book.resetRentalStatus();
		member.returnBook(book);
	}
}
