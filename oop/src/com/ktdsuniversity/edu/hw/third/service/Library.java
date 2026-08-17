package com.ktdsuniversity.edu.hw.third.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import com.ktdsuniversity.edu.hw.third.domain.Book;
import com.ktdsuniversity.edu.hw.third.domain.BookCopy;
import com.ktdsuniversity.edu.hw.third.domain.Member;
import com.ktdsuniversity.edu.hw.third.enums.Genre;
import com.ktdsuniversity.edu.hw.third.utils.NioFileUtil;

public class Library {

	private long nextAccessionNumber;
	private long nextMemberId;
	private List<BookCopy> books;
	private List<Member> members;

	public Library() {
		this.nextAccessionNumber = 1;
		this.nextMemberId = 1;
		this.books = new ArrayList<>();
		this.members = new ArrayList<>();
		NioFileUtil.initDirectory();
		loadData();
	}

	public long getNextAccessionNumber() {
		return this.nextAccessionNumber;
	}

	public long getNextMemberId() {
		return this.nextMemberId;
	}

	public List<BookCopy> getBooks() {
		return this.books;
	}

	public List<Member> getMembers() {
		return this.members;
	}

	private void loadData() {
		// members.csv
		List<String> memberLines = NioFileUtil.readFile("members.csv");
		long maxMemberId = 0;
		for (String line : memberLines) {
			// id, name, contact, fine, overdueCount
			if (line == null) {
				continue;
			}
			String[] args = line.split(",");
			long currId = Long.parseLong(args[0]);
			maxMemberId = Math.max(maxMemberId, currId);
			Member member = new Member(currId, args[1], args[2]);
			member.setFine(Integer.parseInt(args[3]));
			member.setOverdueCount(Integer.parseInt(args[4]));
			this.members.add(member);
		}
		this.nextMemberId = (maxMemberId == 0) ? 1 : maxMemberId + 1;

		// books.csv
		List<String> bookLines = NioFileUtil.readFile("books.csv");
		List<Book> loadedOriginalBooks = new ArrayList<>();
		for (String line : bookLines) {
			// ISBN, genre, publicationDate, title, subtitle, publisher, author, edition,
			// price
			if (line == null) {
				continue;
			}
			String[] args = line.split(",");
			Book book = new Book(args[0], Genre.valueOf(args[1]), LocalDate.parse(args[2]), args[3], args[4], args[5],
					args[6], Integer.parseInt(args[7]), Integer.parseInt(args[8]));
			book.setTotalRentalCount(Integer.parseInt(args[9]));
			loadedOriginalBooks.add(book);
		}

		// book_copies.csv
		List<String> bookCopyLines = NioFileUtil.readFile("book_copies.csv");
		long maxAccessionNum = 0;
		for (String line : bookCopyLines) {
			// accessionNumber, ISBN(Book), inboundDate, isRented, rentalDate, returnDate,
			// isReturned, isDiscarded, id(Member)
			if (line == null) {
				continue;
			}
			String[] args = line.split(",");
			long currAccessionNum = Long.parseLong(args[0]);
			maxAccessionNum = Math.max(maxAccessionNum, currAccessionNum);
			Book originalBook = loadedOriginalBooks.stream() // Stream<Book>
					.filter(b -> b.getISBN().equals(args[1])) // Stream<Book>
					.findFirst() // Optional<Book>
					.orElse(null) // Book
			;
			BookCopy bookCopy = new BookCopy(currAccessionNum, originalBook, LocalDate.parse(args[2]));
			bookCopy.setRented(Boolean.parseBoolean(args[3]));
			if (!args[4].equals("NONE")) {
				bookCopy.setRentalDate(LocalDate.parse(args[4]));
			}
			if (!args[5].equals("NONE")) {
				bookCopy.setReturnDate(LocalDate.parse(args[5]));
			}
			bookCopy.setReturned(Boolean.parseBoolean(args[6]));
			if (Boolean.parseBoolean(args[7])) {
				bookCopy.setDiscarded();
			}
			if (!args[8].equals("NONE")) {
				long renterId = Long.parseLong(args[8]);
				Member renter = this.members.stream() // Stream<Member>
						.filter(m -> m.getId() == renterId) // Stream<Member>
						.findFirst() // Optional<Member>
						.orElse(null) // Member
				;
				if (renter != null) {
					bookCopy.setRenter(renter);
					renter.rentBook(bookCopy);
				}
			}
			this.books.add(bookCopy);
		}
		this.nextAccessionNumber = (maxAccessionNum == 0) ? 1 : maxAccessionNum + 1;
	}

	private void saveData() {
		// books.csv
		List<String> bookData = this.books.stream() // Stream<BookCopy>
				.map(BookCopy::getOriginalBook) // Stream<Book>
				.distinct() // Stream<Book>
				.map(Book::toCsvRow) // Stream<String>
				.toList() // List<String>
		;
		NioFileUtil.writeFile("books.csv", bookData);
		// members.csv
		List<String> memberData = this.members.stream() // Stream<Member>
				.map(Member::toCsvRow) // Stream<String>
				.toList() // List<String>
		;
		NioFileUtil.writeFile("members.csv", memberData);
		// book_copies.csv
		List<String> copyData = this.books.stream() // Stream<BookCopy>
				.map(BookCopy::toCsvRow) // Stream<String>
				.toList() // List<String>
		;
		NioFileUtil.writeFile("book_copies.csv", copyData);
	}

	public void addNewMember(String name, String contact) {
		this.members.add(new Member(nextMemberId++, name, contact));
		saveData();
	}

	public void stockNewBook(Book book) {
		this.books.add(new BookCopy(nextAccessionNumber++, book, LocalDate.now()));
		saveData();
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
		saveData();
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
		saveData();
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
		saveData();
	}
}
