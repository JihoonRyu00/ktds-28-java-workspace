package com.ktdsuniversity.edu.oop.restaurant;

import java.util.Scanner;

public class Restaurant {

	private final int MENU_COUNT = 20;

	private FoodOrAlcohol[] menus;

	Restaurant() {
		this.menus = new FoodOrAlcohol[MENU_COUNT];
	}

	public int getMenuCount() {
		return this.MENU_COUNT;
	}

	public FoodOrAlcohol[] getMenus() {
		return this.menus;
	}

	public void printMenus() {
		System.out.println("============ 메뉴 정보 ============");
		System.out.println("인덱스\t메뉴명\t포만감\t취기");
		for (int i = 0; i < MENU_COUNT; ++i) {
			FoodOrAlcohol menu = menus[i];
			if (menu != null) {
				System.out.println(i + "\t" + menu.getName() + "\t" + menu.getSatiety() + "\t" + menu.getInebriation());
			}
		}
		System.out.println("================================");

	}

	public void addMenu(FoodOrAlcohol menu, int index) {
		if (!isValidIndex(index)) {
			System.out.println("유효한 인덱스를 입력하시오. (0 ~ " + this.getMenuCount());
			return;
		}
		if (this.menus[index] != null) {
			System.out.println("해당 인덱스에는 이미 메뉴가 있습니다.");
			return;
		}
		this.getMenus()[index] = menu;
	}

	public boolean isValidIndex(int index) {
		return index >= 0 && index < this.getMenuCount();
	}

	public static void main(String[] args) {

		Restaurant restaurant = new Restaurant();

		restaurant.addMenu(new FoodOrAlcohol(25, 0, true, "meat"), 0);
		restaurant.addMenu(new FoodOrAlcohol(13, -5, true, "vege"), 1);
		restaurant.addMenu(new FoodOrAlcohol(13, -5, true, "fruit"), 2);
		restaurant.addMenu(new FoodOrAlcohol(7, 0, true, "fish"), 3);
		restaurant.addMenu(new FoodOrAlcohol(-7, 17, false, "soju"), 4);
		restaurant.addMenu(new FoodOrAlcohol(8, 6, false, "beer"), 5);
		restaurant.addMenu(new FoodOrAlcohol(-7, 40, false, "whisky"), 6);
		restaurant.addMenu(new FoodOrAlcohol(-7, 40, false, "cognac"), 7);

//		Customer customer = new Customer(22, 0, 0, "Yee Yee");
		Customer customer = new Customer(12, 0, 0, "Il Yee");

		Scanner sc = new Scanner(System.in);
		int index = -1;
		while (true) {
			restaurant.printMenus();
			System.out.println();
			customer.printStatus();
			System.out.println();
			System.out.print("먹을 음식이나 마실 술의 인덱스를 입력하시오. >> ");
			index = sc.nextInt();
			if (restaurant.isValidIndex(index)) {
				customer.eatOrDrink(restaurant.getMenus()[index]);
			} else {
				System.out.println("유효한 인덱스를 입력하시오. (0 ~ " + restaurant.getMenuCount());
				return;
			}
			System.out.println();
		}
	}
}
