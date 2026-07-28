package com.ktdsuniversity.edu.oop.interfaces.mart;

public class Main {

	public static void main(String[] args) {
		Mart mart = new Mart();
		Product icecream = new FrozenProduct("screwbar", 2000, "2026-01-01", -20);
		Product soju = new AlcoholProduct("soju", 2000, 17);

		CustomerInterface c1 = new VipCustomer("vip", 10000, 21);
		c1.addProduct(soju);
		c1.addProduct(icecream);
		c1.buyRequest(mart);

		CustomerInterface c2 = new NewCustomer("new", 10000, 22);
		c2.addProduct(soju);
		c2.addProduct(icecream);
		c2.buyRequest(mart);
	}
}
