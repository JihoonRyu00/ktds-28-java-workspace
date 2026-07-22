package com.ktdsuniversity.edu.oop.restaurant;

public class Customer {

	private final int MAX_SATIETY = 100;
	private final int MAX_INEBRIATION = 65;

	private int age;
	private int satietyLevel;
	private int inebriationLevel;
	private String name;

	public Customer(int age, int satietyLevel, int inebriationLevel, String name) {
		this.age = age;
		this.satietyLevel = satietyLevel;
		this.inebriationLevel = inebriationLevel;
		this.name = name;
	}

	public int getMAX_SATIETY() {
		return this.MAX_SATIETY;
	}

	public int getMAX_INEBRIATION() {
		return this.MAX_INEBRIATION;
	}

	public int getAge() {
		return this.age;
	}

	public int getSatietyLevel() {
		return this.satietyLevel;
	}

	public int getInebriationLevel() {
		return this.inebriationLevel;
	}

	public String getName() {
		return this.name;
	}

	public boolean isAdult() {
		return this.getAge() >= 19;
	}

	public void printStatus() {
		System.out.println("====== 손님 정보 ======");
		System.out.println("이름:\t " + this.getName());
		System.out.println("나이:\t " + this.getAge());
		System.out.println("포만감:\t " + this.getSatietyLevel());
		System.out.println("취기:\t " + this.getInebriationLevel());
		System.out.println("====================");
	}

//	public void eatFood(Food food) {
//		if (this.satietyLevel >= 100) {
//			System.out.println("");
//			return;
//		}
//		this.satietyLevel += food.getSatiety();
//		this.inebriationLevel += food.getInebriation();
//	}
//
//	public void drinkAlcohol(Alcohol alcohol) {
//		if (!isAdult()) {
//			System.out.println("");
//			return;
//		}
//		if (this.inebriationLevel >= 68) {
//			System.out.println("");
//			return;
//		}
//		this.satietyLevel += alcohol.getSatiety();
//		this.inebriationLevel += alcohol.getInebriation();
//	}
	public void eatOrDrink(FoodOrAlcohol foa) {
		if (foa.getIsFood()) {
			if (this.satietyLevel >= 100) {
				System.out.println("포만도가 높아 더 이상 음식을 섭취할 수 없습니다.");
				return;
			}
			this.satietyLevel += foa.getSatiety();
			this.inebriationLevel += foa.getInebriation();
		} else {
			if (!isAdult()) {
				System.out.println("주류는 19세 미만의 미성년자에게 제공되지 않습니다.");
				return;
			}
			if (this.inebriationLevel >= 68) {
				System.out.println("취기가 높아 더 이상 음식을 섭취할 수 없습니다.");
				return;
			}
			this.satietyLevel += foa.getSatiety();
			this.inebriationLevel += foa.getInebriation();
		}
		if (this.getSatietyLevel() < 0) {
			this.satietyLevel = 0;
		}
		if (this.getInebriationLevel() < 0) {
			this.inebriationLevel = 0;
		}
	}

}
