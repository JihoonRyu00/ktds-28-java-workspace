package workflow;

public class CU {

	public static int payWithPoints(int point, int amount) {
		System.out.println("포인트 선결제 선택");
		// 포인트 선결제 했을 때 포인트를 최종 결제 금액만큼 차감.
		int pointToUse = point;
		if (point >= amount) {
			pointToUse = amount;
		}
		point -= pointToUse;
		amount -= pointToUse;
		
		System.out.println("차감 포인트: " + pointToUse);
		System.out.println("잔여 포인트: " + point);
		System.out.println("잔여 결제 금액: " + amount);
		
		return amount;
	}
	
	public static int payDebitCard(int remainAccount, int amount) {
		System.out.println("체크 카드 결제 선택");
		if (remainAccount < amount) {
			System.out.println("잔액이 부족합니다.");
		} else {
			remainAccount -= amount;
			System.out.println("체크카드 결제 완료");
			System.out.println("계좌 잔액: " + remainAccount);
			amount = 0;
		}
		
		return amount;
	}
	
	public static void installmentPayment(int amount) {
		System.out.println("서명하세요.");
		System.out.println("할부 / 일시불?");
		// 할부 == 0, 일시불 == 1
		int payType = (int)(Math.random() * 2);
		if (payType == 0) {
			System.out.println("할부를 선택했습니다.");
			int duration = (int)(Math.random() * 4) + 2;
			System.out.println(duration + "개월 할부 결제 합니다.");
			System.out.println(duration + "개월 동안 월 " + 
								(amount / duration) + "원 결제 합니다.");
		} else {
			System.out.println("일시불을 선택했습니다.");
		}
	}
	
	public static int payCreditCard(
			int CARD_LIMIT, int cardPaidMoney, int amount) {
		System.out.println("신용 카드 결제 선택");
		if (amount >= 50_000) {
			installmentPayment(amount);
		}
		
		if (CARD_LIMIT < amount + cardPaidMoney) {
			System.out.println("한도 초과!");
		} else {
			// 신용카드로 결제했을 때 카드 결제금액을 최종 결제 금액만큼 증가.
			cardPaidMoney += amount;
			System.out.println("신용카드 결제 완료");
			System.out.println("현재 사용금액: " + cardPaidMoney);
			amount = 0;
		}
		
		return amount;
	}
	
	public static int payCash(int cash, int amount) {
		System.out.println("현금 결제 선택");
		System.out.println("현재 잔액: " + cash + "원");
		if (cash >= amount) {
			cash -= amount;
			System.out.println("남은 잔액: " + cash + "원");
			amount = 0;
		} else {
			System.out.println("현금이 부족합니다.");
		}
		
		return amount;
	}
	
	public static int pay(
			int amount, int cash, int CARD_LIMIT, int cardPaidMoney,
			int remainAccount, int point) {
		// 결제 수단 선택
		int payment = (int) (Math.random() * 5);
		
		System.out.println("결제를 시작합니다.");
		System.out.println("결제 금액: " + amount);
		System.out.println();
		
		if (payment == 0) {
			amount = payCash(cash, amount);
		} else if (payment == 1) {
			amount = payCreditCard(CARD_LIMIT, cardPaidMoney, amount);
		} else if (payment == 2) {
			amount = payDebitCard(remainAccount, amount);
		} else if (payment == 3) {
			amount = payWithPoints(point, amount);
		} else {
			System.out.println("결제 포기 선택");
			amount = 0;
		}
		
		// 잔여 결제 금액
		return amount;
	}
	
	public static int calculateEarnPoints(int amount) {
		int earnPoint = (int)(amount * 0.1f);
		return earnPoint;
	}
	
	public static int buyItems(int[] items, float[] dc) {
		int amount = 0;
		for (int i = 0; i < items.length; i++) {
			int itemPrice = (int) (items[i] * (1 - dc[i]));
			amount += itemPrice;
		}
		return amount;
	}
	
	public static int buyPlasticBag(int[] items, int SPLIT_COUNT, int BAG_PRICE) {
		int bagCount = items.length / SPLIT_COUNT;
		if (items.length % SPLIT_COUNT > 0) {
			bagCount++;
		}
//		int bagCount = (int) Math.ceil(items.length / (double) SPLIT_COUNT);
		
		System.out.println("봉투 " + bagCount + "개 구매");
		System.out.println("봉투가격: " + bagCount * BAG_PRICE + "원");
		return bagCount * BAG_PRICE;
	}
	
	public static void main(String[] args) {
		// 편의점.drawio 파일을 토대로 작성한 코드.
		
		// 시작.
		// 손님이 바구니에 담아온 상품의 가격 정보.
		int[] items = new int[5];
		items[0] = 5000;
		items[1] = 1800;
		items[2] = 3200;
		items[3] = 30000;
		items[4] = 1300;
		
		// 손님이 바구니에 담아온 상품의 할인 정보
		float[] dc = new float[5];
		dc[0] = 0;
		dc[1] = 0.1f; // 1800원 상품을 10% 할인.
		dc[2] = 0.2f; // 3200원 상품을 20% 할인.
		dc[3] = 1; // 30000원 상품을 100% 할인.
		dc[4] = 0;
		
		// 봉투가격
		final int BAG_PRICE = 100;
		// 한 봉투에 넣을 수 있는 상품의 수
		final int SPLIT_COUNT = 2;
		
		// 고객의 자금 상황
		// 카드 한도
		final int CARD_LIMIT = 1_000_000;
		
		// 현재까지 사용한 카드 결제 금액
		int cardPaidMoney = 150_000;
		
		// 체크 카드 계좌 잔액
		int remainAccount = 4000;
		
		// 보유한 현금
		int cash = 30_000;
		
		// 보유한 포인트
		int point = 1_750;
		
		// 최종 결제 금액
		int amount = 0;
		
		// 봉투 필요여부(필요 == 0, 불필요 == 1)
		int needBag = (int) (Math.random() * 2);
		if (needBag == 0) {
			amount += buyPlasticBag(items, SPLIT_COUNT, BAG_PRICE);
		}
		
		// 손님이 가져온 상품 목록의 결제 금액 계산해서 amount에 할당.
		amount += buyItems(items, dc);
		System.out.println("결제 금액: " + amount + "원");
		System.out.println();
		
		// 포인트 적립 (0 ==> 적립, 1 ==> 적립 안함)
		int addPoint = (int) (Math.random() * 2);
		if (addPoint == 0) {
			int earnPoint = calculateEarnPoints(amount);
			point += earnPoint;
			System.out.println("적립 포인트: " + earnPoint + "점");
			System.out.println("누적 포인트: " + point + "점");
			System.out.println();
		}
		
		// 결제 수단 선택 (0 ==> 현금, 1 ==> 신용카드, 2 ==> 체크카드, 3 ==> 포인트 선결제, 4 ==> 포기)
		while (amount > 0) {
			amount = pay(amount, cash, CARD_LIMIT, cardPaidMoney, remainAccount, point);
		}
		System.out.println(point);
	}
	
}