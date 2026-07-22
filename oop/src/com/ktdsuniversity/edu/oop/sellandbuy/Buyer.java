package com.ktdsuniversity.edu.oop.sellandbuy;

/**
 * 구매자 클래스
 */
public class Buyer {

	/**
	 * 구매자 잔고
	 */
	private int balance;

	/**
	 * 구매자 장바구니
	 */
	private int cart;

	/**
	 * 구매자 생성자
	 * 
	 * @param balance
	 * @param cart
	 */
	Buyer(int balance, int cart) {
		this.balance = balance;
		this.cart = cart;
	}

	/**
	 * 구매자 잔고 getter
	 * 
	 * @return
	 */
	public int getBalance() {
		return this.balance;
	}

	/**
	 * 구매자 장바구니 getter
	 * 
	 * @return
	 */
	public int getCart() {
		return this.cart;
	}

	/**
	 * 구매
	 * 
	 * @param seller
	 * @param quantity
	 */
	public void buy(Seller seller, int quantity) {
		int totalPrice = seller.getPrice() * quantity;
		if (totalPrice > this.balance) {
			return;
		}
		if (quantity > seller.getStock()) {
			quantity = seller.getStock();
		}
		this.cart += quantity;
		this.balance -= seller.sell(quantity);
	}

	/**
	 * 구매자 상태 출력
	 */
	public void printStatus() {
		System.out.println("===== 구매자의 정보 =====");
		System.out.println("현재 잔고\t: " + this.balance);
		System.out.println("장바구니\t: " + this.cart);
	}
}
