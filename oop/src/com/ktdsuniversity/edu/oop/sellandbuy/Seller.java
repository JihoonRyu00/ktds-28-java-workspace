package com.ktdsuniversity.edu.oop.sellandbuy;

/**
 * 판매자 클래스
 */
public class Seller {

	/** 판매자 상품 재고 */
	private int stock;

	/** 판매자 상품 가격 */
	private int price;

	/** 총 판매 수량 */
	private int salesCount;

	/** 판매자 매출액 */
	private int totalIncome;

	/**
	 * 판매자 생성자
	 * 
	 * @param stock
	 * @param price
	 * @param totalIncome
	 * @param salesCount
	 */
	Seller(int stock, int price, int salesCount, int totalIncome) {
		this.stock = stock;
		this.price = price;
		this.salesCount = salesCount;
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
		this.salesCount += quantity;
		int totalPrice = quantity * this.price;
		this.totalIncome += totalPrice;
		return totalPrice;
	}

	/**
	 * 판매자 상태 출력
	 */
	public void printStatus() {
		System.out.println("===== 판매자의 정보 =====");
		System.out.println("현재 재고\t: " + this.stock);
		System.out.println("판매 상품 단가\t: " + this.price);
		System.out.println("총 판매 수량\t: " + this.salesCount);
		System.out.println("총 매출액\t: " + this.totalIncome);
		System.out.println();
	}
}
