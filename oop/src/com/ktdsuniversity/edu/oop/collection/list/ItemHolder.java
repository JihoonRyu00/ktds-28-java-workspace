package com.ktdsuniversity.edu.oop.collection.list;

import java.util.ArrayList;
import java.util.List;

import com.ktdsuniversity.edu.oop.vendingmachine.Item;

/**
 * 자판기에 상품을 고정시키기 위한 홀더
 */
public class ItemHolder {

//	final int N;
	/**
	 * 
	 */
	List<Item> items;

	/**
	 * 생성자
	 */
//	public ItemHolder() {
//		this.items = new Item[5];
//	}
	public ItemHolder() {
		this.items = new ArrayList<>();
	}
}
