package com.ktdsuniversity.edu.oop.collection.list;

import com.ktdsuniversity.edu.oop.interfaces.mart.Product;

public interface CustomerInterface {

	void addProduct(Product product);

	int calcTotalPrice();

	void buyRequest(Mart mart);
}
