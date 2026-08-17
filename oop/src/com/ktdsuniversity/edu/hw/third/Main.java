package com.ktdsuniversity.edu.hw.third;

import java.time.LocalDate;
import java.util.List;

import com.ktdsuniversity.edu.hw.third.domain.Book;
import com.ktdsuniversity.edu.hw.third.domain.BookCopy;
import com.ktdsuniversity.edu.hw.third.domain.Member;
import com.ktdsuniversity.edu.hw.third.enums.Genre;
import com.ktdsuniversity.edu.hw.third.service.Library;

public class Main {

	private static void setupInitialEnvironment(Library library) {

		// 1. 회원 등록
		library.addNewMember("Peter Parker", "010-1111-1111");
		library.addNewMember("Tony Stark", "010-2222-2222");
		library.addNewMember("Steve Rogers", "010-3333-3333");
		library.addNewMember("Clark Kent", "010-7777-7777");
		library.addNewMember("Bruce Wayne", "010-8888-8888");
		library.addNewMember("Diana Prince", "010-9999-9999");

		// 2. 도서 객체 생성
		Book kravensLastHunt = new Book("978-1302911843", Genre.ADVENTURE, LocalDate.of(2018, 8, 21),
				"Spider-Man: Kraven's Last Hunt", "Deluxe Edition", "Marvel Comics", "J.M. DeMatteis", 1, 39900);
		Book civilWar = new Book("978-0785121794", Genre.ADVENTURE, LocalDate.of(2006, 1, 1), "Civil War",
				"Issues #1-7", "Marvel Comics", "Mark Millar", 1, 24900);
		Book infinityGauntlet = new Book("978-0785156598", Genre.FANTASY, LocalDate.of(1991, 7, 1),
				"The Infinity Gauntlet", "Issues #1-6", "Marvel Comics", "Jim Starlin", 1, 25000);
		Book darkKnightReturns = new Book("978-1563893421", Genre.ADVENTURE, LocalDate.of(1986, 2, 1),
				"Batman: The Dark Knight Returns", "Trade Paperback", "DC Comics", "Frank Miller", 1, 22000);
		Book watchmen = new Book("978-1779501127", Genre.SCI_FI, LocalDate.of(1987, 9, 1), "Watchmen",
				"International Edition", "DC Comics", "Alan Moore", 1, 28000);
		Book redSon = new Book("978-1401201913", Genre.SCI_FI, LocalDate.of(2004, 2, 1), "Superman: Red Son",
				"Trade Paperback", "DC Comics", "Mark Millar", 1, 21000);

		// 3. 도서 복본 입고
		for (int i = 0; i < 3; i++) {
			library.stockNewBook(kravensLastHunt);
			library.stockNewBook(civilWar);
			library.stockNewBook(infinityGauntlet);
			library.stockNewBook(darkKnightReturns);
			library.stockNewBook(watchmen);
			library.stockNewBook(redSon);
		}

		// 4. 운영 이력 시뮬레이션
		List<Member> members = library.getMembers();
		List<BookCopy> bookCopies = library.getBooks();

		Member peter = members.get(0);
		Member tony = members.get(1);
		Member clark = members.get(3);
		Member bruce = members.get(4);
		Member diana = members.get(5);

		BookCopy kravenCopy1 = bookCopies.stream()
				.filter(c -> c.getOriginalBook().getISBN().equals(kravensLastHunt.getISBN())).findFirst().orElse(null);
		BookCopy watchmenCopy1 = bookCopies.stream()
				.filter(c -> c.getOriginalBook().getISBN().equals(watchmen.getISBN())).findFirst().orElse(null);
		BookCopy darkKnightCopy1 = bookCopies.stream()
				.filter(c -> c.getOriginalBook().getISBN().equals(darkKnightReturns.getISBN())).findFirst()
				.orElse(null);
		BookCopy civilWarCopy1 = bookCopies.stream()
				.filter(c -> c.getOriginalBook().getISBN().equals(civilWar.getISBN())).findFirst().orElse(null);
		BookCopy redSonCopy1 = bookCopies.stream().filter(c -> c.getOriginalBook().getISBN().equals(redSon.getISBN()))
				.findFirst().orElse(null);

		// 이력 생성
		library.rentBook(tony, watchmenCopy1);
		library.returnBook(tony, watchmenCopy1);

		library.rentBook(peter, kravenCopy1);
		kravenCopy1.setReturnDate(LocalDate.now().minusDays(5));
		library.returnBook(peter, kravenCopy1);

		library.rentBook(clark, redSonCopy1);

		library.rentBook(bruce, darkKnightCopy1);
		darkKnightCopy1.setReturnDate(LocalDate.now().minusDays(3));

		library.rentBook(diana, civilWarCopy1);
		library.rentBook(diana, watchmenCopy1);

		BookCopy gauntletCopy3 = bookCopies.stream()
				.filter(c -> c.getOriginalBook().getISBN().equals(infinityGauntlet.getISBN())).skip(2).findFirst()
				.orElse(null);
		if (gauntletCopy3 != null) {
			gauntletCopy3.setDiscarded();
		}

		BookCopy redSonCopy3 = bookCopies.stream().filter(c -> c.getOriginalBook().getISBN().equals(redSon.getISBN()))
				.skip(2).findFirst().orElse(null);
		if (redSonCopy3 != null) {
			redSonCopy3.setDiscarded();
		}

		library.addNewMember("Barry Allen", "010-0000-0000"); // 강제 조작 데이터 반영하여 write
	}

	public static void run() {
		Library library = new Library();
//		초기에만 실행
//		setupInitialEnvironment(library);
//		=============================================
		List<Member> members = library.getMembers();
		List<BookCopy> copies = library.getBooks();
		Member peter = members.get(0);
		Member tony = members.get(1);
		BookCopy testCopy1 = copies.get(0);
		BookCopy testCopy2 = copies.get(1);

//		1. 도서 검색 관련 기능
//		library.printSearchByPublisher("DC Comics");
//		library.printSearchByPublisher("Marvel Comics");
//
//		library.printSearchByAuthor("Mark Millar");
//
//		library.printSearchByGenre(Genre.SCI_FI);
//		library.printSearchByGenre(Genre.ADVENTURE);

//		2. 랭킹 및 현황 출력 기능
//		library.printPopularityRank();
//
//		library.printOverdueRank();
//
//		library.printOverdueOrDueSoonMembers();

//		3. 신규 데이터 추가 기능
//		library.addNewMember("Gwen Stacy", "010-1234-5678");
//		library.printOverdueRank();
//
//		Book newBook = new Book("978-0000000001", Genre.ESSAY, LocalDate.now(), "New Marvel Guide", "", "Marvel Comics",
//				"Stan Lee", 1, 15000);
//		library.stockNewBook(newBook);
//		library.printPopularityRank();

//		4. 대여 및 반납 기능
//		정상 대여
//		library.rentBook(tony, testCopy1);

//		이미 대여중인 도서 대여 시도
//		library.rentBook(peter, testCopy1);

//		연체 횟수 3회 이상인 회원의 대여 시도
//		peter.setOverdueCount(3); // 강제로 연체 횟수 3회 부여
//		library.rentBook(peter, testCopy2);

//		정상 반납
//		library.returnBook(tony, testCopy1);

//		대여하지 않은 책 반납 시도
//		library.returnBook(peter, testCopy2);

//		연체 반납
//		library.rentBook(peter, testCopy2);
//		testCopy2.setReturnDate(LocalDate.now().minusDays(10)); // 반납일을 10일 전으로 조작
//		library.returnBook(peter, testCopy2);
//		System.out.println(peter);

//		5. 오래된 도서 폐기 기능
//		System.out.println("폐기 전 전체 도서 수: " + library.getBooks().size());
//		library.discardOldBooks();
//		System.out.println("폐기 후 전체 도서 수: " + library.getBooks().size());
//		=============================================
	}

	public static void main(String[] args) {
		run();
	}
}
