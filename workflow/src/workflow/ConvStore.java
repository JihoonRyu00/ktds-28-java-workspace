package workflow;

public class ConvStore {
	public static void main(String[] args) {
		/*
		 * A 편의점은 한 종류의 음료수만 판매합니다. 음료수 하나의 가격은 3000원입니다.(상수) 손님이 가지고 있는 돈, 구매량(변수)
		 * 5000원을 가진 손님이 음료수 3개를 구매하려 합니다. 구매할 수 있다면 (음료수 가격 * 구매량)을 출력하고, 구매할 수 없다면,
		 * "금액이 부족합니다."를 출력합니다.
		 */
		final int PRICE = 3000;
		int money = 5000;
		int quantity = 3;
		if (PRICE * quantity <= money) {
			System.out.println(PRICE * quantity);
		} else {
			System.out.println("금액이 부족합니다.");
		}
		/*
		 * B 편의점은 한 종류의 음료수만 판매합니다. 총 5개의 음료수가 있으며 하나의 가격은 4500원입니다.(상수) 손님이 가지고 있는 돈,
		 * 구매량(변수) 30000원을 가진 손님이 음료수 n개를 구매하려 합니다. 음료수를 하나라도 구매할 수 있다면 (음료수 가격 * 구매량)을
		 * 출력하고, 음료수를 하나라도 구매할 수 없다면 "금액이 부족합니다."를 출력합니다. 음료수를 6개 이상 구매하려 한다면
		 * "재고 수가 충분하지 않습니다."를 출력합니다.
		 */
		final int PRICE2 = 4500;
		int stock = 5;
		int money2 = 30000;
		int quantity2 = 3;
		if (quantity2 > stock) {
			System.out.println("재고 수가 충분하지 않습니다.");
		} else if (PRICE2 * quantity2 <= money2) {
			System.out.println(PRICE2 * quantity2);
		} else {
			System.out.println("금액이 부족합니다.");
		}
	}
}
