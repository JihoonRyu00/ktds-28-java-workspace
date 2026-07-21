package kyobobook;

public class Book {
	/**
	 * ISBN
	 */
	String ISBN;
	/**
	 * 책 쪽수
	 */
	int totalPage;
	/**
	 * 도서명
	 */
	String Name;
	/**
	 * 작가
	 */
	Author author;
	/**
	 * 출판일자
	 */
	String publishDate;
	/**
	 * 가격
	 */
	int price;
	/**
	 * 범주
	 */
	String category;
	/**
	 * 책설명
	 */
	String bookDescription;
	/*
	 * 목차
	 */
	// Index[] indexList = new Index[n];
	/*
	 * 책에 달린 리뷰 리스트
	 */
	Review[] reviewList = new Review[100];
}
