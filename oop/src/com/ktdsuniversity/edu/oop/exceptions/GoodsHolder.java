package com.ktdsuniversity.edu.oop.exceptions;

import java.beans.IntrospectionException;

public class GoodsHolder {

	private Goods[] goods;
	private int goodsIndex;

	public GoodsHolder(int goodsCount) {
		if (goodsCount < 0) {
			goodsCount = 0;
		}
		this.goods = new Goods[goodsCount];
	}

	private void extendGoodsList() {
		Goods[] newGoods = new Goods[goods.length * 2];
		System.arraycopy(goods, 0, newGoods, 0, goods.length);
		this.goods = newGoods;
	}

	public void addGoods(String name, int price) {
		if (name == null || name.isBlank()) {
			return;
		}
		if (this.goodsIndex == this.goods.length) {
			return;
//			extendGoodsList();
		}
		this.goods[this.goodsIndex++] = new Goods(name, price);
	}

	public void addGoods(String name, String price) {
		if (price == null) {
			return;
		}
		price = price.replaceAll("[^0-9]", "");
		if (price.isBlank()) {
			return;
		}
		long tempPrice = Long.parseLong(price);
		if (tempPrice < Integer.MIN_VALUE || tempPrice > Integer.MAX_VALUE) {
			return;
		}
		int intPrice = (int) tempPrice;
		this.addGoods(name, intPrice);
	}

	public void removeGoods(int goodsIndex) {
		if (goodsIndex >= 0 && goodsIndex < this.goods.length) {
			this.goods[goodsIndex] = null;
		}
	}

	public void printGoodsAt(int index) {
		Goods goods = null;
		if (index >= 0 && index < this.goods.length) {
			goods = this.goods[index];
		}
		if (goods != null) {
			String message = "%d. %s(%d)".formatted(index + 1, goods.getName(), goods.getPrice());
			System.out.println(message);
		}
	}

	public void printGoods() {
		for (int i = 0; i < this.goods.length; i++) {
			this.printGoodsAt(i);
		}
	}

}