package com.ktdsuniversity.edu.oop.sellandbuy;

/**
 * 판매자 클래스
 */
public class Seller {

	/**
	 * 판매자 상품 재고
	 */
	private int stock;

	/**
	 * 판매자 상품 가격
	 */
	private int price;

	/**
	 * 판매자 매출액
	 */
	private int totalIncome;

	/**
	 * 판매자 생성자
	 * 
	 * @param stock
	 * @param price
	 * @param totalIncome
	 */
	Seller(int stock, int price, int totalIncome) {
		this.stock = stock;
		this.price = price;
		this.totalIncome = totalIncome;
	}

	/**
	 * 판매자 상품 재고 getter
	 * 
	 * @return
	 */
	public int getStock() {
		return this.stock;
	}

	/**
	 * 판매자 상품 가격 getter
	 * 
	 * @return
	 */
	public int getPrice() {
		return this.price;
	}

	/**
	 * 판매
	 * 
	 * @param quantity
	 * @return
	 */
	public int sell(int quantity) {
		this.stock -= quantity;
		int totalPrice = quantity * this.price;
		this.totalIncome += totalPrice;
		return totalPrice;
	}
}
