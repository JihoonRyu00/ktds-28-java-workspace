package com.ktdsuniversity.edu.oop.collection.list;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import com.ktdsuniversity.edu.oop.exceptions.Goods;

public class GoodsHolder {

	private List<Goods> goods;

	public GoodsHolder() {
		this.goods = new ArrayList<>();
		this.loadGoods();
	}

	private void loadGoods() {
		File db = new File("C:\\Java Exam", "goods.txt");
		if (db.exists() && db.isFile()) {

			List<String> goodsList = null;
			try {
				goodsList = Files.readAllLines(db.toPath());
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
			if (goodsList != null) {
				for (String s : goodsList) {
					String[] temp = s.split(",");
					this.addGoods(temp[0], temp[1]);
				}
			}
		}
	}

	public void addGoods(String name, int price) {
		if (name == null || name.isBlank()) {
			return;
		}
		this.goods.add(new Goods(name, price));
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

	public void addGoods(String name, int price, boolean fileWrite) {
		this.addGoods(name, price);
		if (fileWrite) {
			File db = new File("C:\\Java Exam", "goods.txt");
			if (!db.getParentFile().exists()) {
				db.getParentFile().mkdirs();
			}
			List<String> data = new ArrayList<>();
			data.add("%s,%d".formatted(name, price));
			try {
				Files.write(db.toPath(), data, StandardOpenOption.APPEND);
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
	}

	public void removeGoods(int goodsIndex) {
		if (goodsIndex >= 0 && goodsIndex < this.goods.size()) {
			this.goods.remove(goodsIndex);
		}
	}

	public void printGoodsAt(int index) {
		Goods goods = null;
		if (index >= 0 && index < this.goods.size()) {
			goods = this.goods.get(index);
		}
		if (goods != null) {
			String message = "%d. %s(%d)".formatted(index + 1, goods.getName(), goods.getPrice());
			System.out.println(message);
		}
	}

	public void printGoods() {
		for (int i = 0; i < this.goods.size(); i++) {
			this.printGoodsAt(i);
		}
	}

	public static void main(String[] args) {
		GoodsHolder gh = new GoodsHolder();
		gh.printGoods();
		gh.addGoods("이클립스", 2000, true);
		gh.addGoods("이클립스2", 5000, true);
		gh.addGoods("이클립스3", 3000, true);
		gh.addGoods("이클립스4", 2000, true);

		gh.printGoods();
	}
}