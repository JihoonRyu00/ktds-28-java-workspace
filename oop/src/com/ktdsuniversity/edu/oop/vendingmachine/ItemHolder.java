package com.ktdsuniversity.edu.oop.vendingmachine;

/**
 * 자판기에 상품을 고정시키기 위한 홀더
 */
public class ItemHolder {

//	final int N;
	/**
	 * 
	 */
	Item[] items;

	/**
	 * 생성자
	 */
//	public ItemHolder() {
//		this.items = new Item[5];
//	}
	public ItemHolder(Item[] items) {
		this.items = new Item[5];
	}
}
