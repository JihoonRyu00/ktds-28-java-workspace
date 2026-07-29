package com.ktdsuniversity.edu.oop.exceptions;

public class GoodsMain {

	public static void main(String[] args) {

		GoodsHolder gh = new GoodsHolder(10);

		gh.addGoods("1111", "1_111");
		gh.addGoods("\t\t\t\t\t\t\t\t\t\t", "-2_222");
		gh.addGoods("", "3_333_333_333_333");
		gh.addGoods("4444", "");
		gh.addGoods("5555", "5_555");

		gh.printGoodsAt(0);
		gh.printGoodsAt(1);
		gh.printGoodsAt(2);
		gh.printGoodsAt(3);
		gh.printGoodsAt(-1);
		gh.printGoodsAt(100);

		gh.removeGoods(0);
		gh.removeGoods(1);
		gh.removeGoods(2);
		gh.removeGoods(3);
		gh.removeGoods(-1);
		gh.removeGoods(100);
	}
}
