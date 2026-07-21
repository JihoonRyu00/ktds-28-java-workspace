package kyobobook;

public class Author {
	/**
	 * 작가 생년월일
	 */
	String birthDay;
	/**
	 * 작가 성별
	 */
	boolean gender;
	/**
	 * 작가 이름
	 */
	String name;
	/**
	 * 작가가 집필한 도서 리스트
	 */
	Book[] bookList = new Book[100];
}
