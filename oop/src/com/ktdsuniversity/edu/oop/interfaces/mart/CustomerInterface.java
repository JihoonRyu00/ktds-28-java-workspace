package com.ktdsuniversity.edu.oop.interfaces.mart;

public interface CustomerInterface {

	void addProduct(Product product);

	int calcTotalPrice();

	void buyRequest(Mart mart);
}
