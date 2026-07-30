package com.ktdsuniversity.edu.oop.generics;

import com.ktdsuniversity.edu.oop.exceptions.Goods;

public class PrinterTest {

	public static void main(String[] args) {
		Printer<Integer, String> intStrPrinter = new Printer<>(3, "asas");
		intStrPrinter.print();

		Printer<Float, Boolean> floatBoolPrinter = new Printer<>(3f, intStrPrinter == null);
		floatBoolPrinter.print();

		Printer<Printer<Integer, String>, Printer<Float, Boolean>> printerPrinter = new Printer<>(intStrPrinter,
				floatBoolPrinter);
		printerPrinter.print();

		Printer<Goods, Goods> goodsGoodsPrinter = new Printer<>(new Goods("Fold 8", 300), new Goods("Flip 8", 150));
		goodsGoodsPrinter.print();

//		Printer<Object, Object>[] ggpArr = new Printer<Object, Object>[10];
	}
}
