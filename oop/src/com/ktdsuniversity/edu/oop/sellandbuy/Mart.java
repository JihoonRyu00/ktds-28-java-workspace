package com.ktdsuniversity.edu.oop.sellandbuy;

/**
 * 
 */
public class Mart {

	public static void main(String[] args) {

		Seller musinsa = new Seller(10, 2000, 0, 0);
		Seller kream = new Seller(20, 500, 3, 3 * 500);

		Buyer buyer = new Buyer(10000, 0);

		buyer.buy(musinsa, 3);

		buyer.printStatus();
		musinsa.printStatus();

		buyer.buy(kream, 2);

		buyer.printStatus();
		kream.printStatus();
	}
}
