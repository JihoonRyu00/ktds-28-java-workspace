package com.ktdsuniversity.edu.oop.exam;

public class Car {

//	final int MAX_SPEED = 240;

	// 멤버 변수
	// 클래스의 인스턴스가 독립적으로 가지고 있는 정보들
	boolean isEngineStart;
	int speed;
	int zero100Seconds;

	/**
	 * 기본 생성자
	 */
	public Car() {
		System.out.println("생성자가 호출됨.\n" + this);
		this.pressEngineStartButton();
	}
	
	public Car(int zero100Seconds) {
//		Car();
		this.zero100Seconds=zero100Seconds;
		System.out.println("생성자가 호출됨.\n" + this);
		this.pressEngineStartButton();
	}
	
	// 인스턴스 메서드 (메서드) 정의
	// 엔진 켜기 / 끄기
	public void pressEngineStartButton() {
		// 이 메서드를 호출하는 인스턴스의 isEngineStart가 false일 때 true, true일 때 false로
//		isEngineStart = !isEngineStart;
		if (isEngineStart) {
			isEngineStart = false;
			speed = 0;
		} else {
			isEngineStart = true;
			speed = 10;
		}
	}

	// 가속 페달을 밟는다. 페달을 밟는 압력만큼 속도가 증가한다.
	public void pressGasolinPedal(int pressure) {
		if (isEngineStart) {
			speed += pressure;
//			if (speed > MAX_SPEED) {
//				speed = MAX_SPEED;
//			}
		}
	}

	// 브레이크 페달을 밟는다. 페달을 밟는 압력만큼 속도가 감소한다.
	public void pressBrakePedal(int pressure) {
		if (isEngineStart) {
			speed -= pressure;
		}
	}

	public static void main(String[] args) {

		// Car 클래스를 이용해 다음을 생성

		// Car 타입의 kona 인스턴스를 생성
		Car kona = new Car();
		System.out.println(kona);
		// Car 타입의 carnival 인스턴스를 생성.
		Car carnival = new Car(6);
		System.out.println(carnival);

		// 인스턴스는 자신의 멤버변수의 값을 할당하거나 출력할 수 있다.
//		kona.isEngineStart = true;
//		kona.speed = 100;
//		carnival.isEngineStart = false;
//		carnival.speed = 70;

		// kona의 시동을 켠다.
		kona.pressEngineStartButton();
		// 브레이크 페달을 약하게 몇 차례 밟는다.
		kona.pressBrakePedal(3);
		kona.pressBrakePedal(3);
		// 가속 페달을 3회 강하게 밟는다.
		kona.pressGasolinPedal(150);
		kona.pressGasolinPedal(150);
		kona.pressGasolinPedal(150);
		// 브레이크 페달을 아주 강하게 밟는다.
		kona.pressBrakePedal(300);
		// kona의 시동을 끈다.
		kona.pressEngineStartButton();

		carnival.pressEngineStartButton();
		carnival.pressBrakePedal(50);
		carnival.pressGasolinPedal(150);
		carnival.pressBrakePedal(3);
		carnival.pressGasolinPedal(150);
		carnival.pressGasolinPedal(150);
		carnival.pressBrakePedal(300);
		carnival.pressEngineStartButton();

		System.out.println(kona.isEngineStart);
		System.out.println(kona.speed);
		System.out.println(carnival.isEngineStart);
		System.out.println(carnival.speed);
	}
}
