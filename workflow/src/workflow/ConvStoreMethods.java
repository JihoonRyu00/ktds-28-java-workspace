package workflow;

public class ConvStoreMethods {
	// 편의점 drwa.io 기반
	public static int getTotalItemPrices(int ITEM_NUM, int[] itemPrices, float[] dc) {
		int totalItemPrice = 0;
		for (int i = 0; i < ITEM_NUM; ++i) {
			totalItemPrice += itemPrices[i] * (1 - dc[i]);
		}
		return totalItemPrice;
	}

	public static int getPointToBeEarned(int price, float epr) {
		return (int) (price * (1 - epr));
	}

	public static void printBalanceState(int cashBalance, int expectedCashAmount, int CARD_LIMIT, int checkCardBalance,
			int expectedCreditCardAmount, int pointAmoumt, int expectedPointAmount) {
		// 재화 현황
		System.out.println("------ 재화 현황 ------");
		System.out.println("현금:\t\t " + (cashBalance - expectedCashAmount));
		System.out.println("신용 카드 한도:\t " + CARD_LIMIT);
		System.out.println("체크 카드 잔액:\t " + (checkCardBalance - expectedCreditCardAmount));
		System.out.println("포인트:\t\t " + (pointAmoumt - expectedPointAmount));
		System.out.println("----------------------");
	}

	public static void main(String[] args) {

		final int ITEM_NUM = 5; // 상품 종류의 수
		final int BAG_PRICE = 100; // 봉투 가격
		final int BAG_STORAGE = 2; // 봉투의 상품 가용 수
		final int CARD_LIMIT = 1_000_000; // 카드 한도
		final int SIGN_INST_THRESHOLD = 50_000; // 서명 & 할부 기준점
		final String[] PAY_METHOD = { "현금", "신용 카드", "체크 카드", "포기" };
		final float EARNING_POINT_RATIO = 0.1f;

		int bagCount = 0; // 봉투 수
		boolean isBagNeeded = false;
		int expectedCreditCardAmount = 0; // 예상 신용 카드 결제 금액
		boolean isCreditCardUsed = false; // 신용 카드 사용 여부
		int instDuration = 0; // 할부 개월 수
		int checkCardBalance = 4_000; // 체크 잔액
		int expectedCheckCardAmount = 0; // 예상 체크 카드 결제 금액
		int cashBalance = 30_000; // 현금 잔액
		int expectedCashAmount = 0; // 예상 현금 결제 금액
		int pointAmoumt = 1_750; // 포인트 잔액
		int expectedPointAmount = 0; // 예상 포인트 차감 금액
		int totalPrice = 0; // 최종 결제 금액
		boolean isPointEarned = false; // 포인트 적립 여부
		boolean isPointPayEnabled = false; // 포인트 결제 여부
		int payment = -1; // 결제 수단
		boolean paySuccess = true; // 결제 성공 여부

		// 각 상품들의 가격
		int[] itemPrices = new int[ITEM_NUM];
		itemPrices[0] = 5000;
		itemPrices[1] = 1800;
		itemPrices[2] = 3200;
		itemPrices[3] = 30000;
		itemPrices[4] = 1300;

		// 각 상품들의 할인율
		float[] dc = new float[ITEM_NUM];
		dc[0] = 0;
		dc[1] = 0.1f;
		dc[2] = 0.2f;
		dc[3] = 1;
		dc[4] = 0;

		// 전 상품 계산하여 최종결제 금액 업데이트
		for (int i = 0; i < ITEM_NUM; ++i) {
			totalPrice += itemPrices[i] * (1 - dc[i]);
		}
		totalPrice += getTotalItemPrices(ITEM_NUM, itemPrices, dc);
		System.out.println("상품 총 금액:\t " + totalPrice);

		// 봉투 필요 여부 (0 => 불필요, 1 => 필요)
		isBagNeeded = ((int) (Math.random() * 2) != 0);
		if (isBagNeeded) {
			bagCount = (ITEM_NUM - 1) / BAG_STORAGE + 1;
			totalPrice += bagCount * BAG_PRICE;
			System.out.println("봉투 " + bagCount + "개 필요\n봉투 금액:\t " + (bagCount * BAG_PRICE));
		} else {
			System.out.println("봉투 불필요");
		}

		// 남은 결제 금액 업데이트
		int remainedTotalPrice = totalPrice;
		System.out.println("총 결제 금액:\t " + remainedTotalPrice);

		// 재화 현황
		printBalanceState(cashBalance, expectedCashAmount, CARD_LIMIT, checkCardBalance, expectedCreditCardAmount,
				pointAmoumt, expectedPointAmount);

		// 포인트 적립 여부 랜덤 선택 (0 => 적립 안 함, 1 => 적립)
		isPointEarned = ((int) (Math.random() * 2) != 0);

		// 포인트 선결제 여부 랜덤 선택
		isPointPayEnabled = ((int) (Math.random() * 2) != 0);

		// 포인트 선결제
		if (isPointPayEnabled) {
			System.out.println("포인트 선결제 여부: O");
			if (pointAmoumt > 0) {
				expectedPointAmount = pointAmoumt;
				remainedTotalPrice -= expectedPointAmount;
			} else {
				System.out.println("포인트 없음!");
			}
		} else {
			System.out.println("포인트 선결제 여부: X");
		}
		System.out.println();

		// 결제 수단 계산
		while (remainedTotalPrice > 0) {
			System.out.println("남은 결제 금액:\t " + remainedTotalPrice);

			// 재화 현황
			printBalanceState(cashBalance, expectedCashAmount, CARD_LIMIT, checkCardBalance, expectedCreditCardAmount,
					pointAmoumt, expectedPointAmount);

			// 결제 수단 랜덤 선택 (0 => 현금, 1 => 신용 카드, 2 => 체크 카드, 3 => 포기)
			payment = (int) (Math.random() * 4);////////////////////////////////
			System.out.print("결제 수단 선택됨. >> ");
			System.out.println(PAY_METHOD[payment]);

			if (payment == 3) { // 포기
				paySuccess = false;////////////////////////////////
				break;////////////////////////////////
			} else if (payment == 0) { // 현금
				// 현금 잔액이 0 이하인 경우
				if (cashBalance <= 0) {
					System.out.println("현금 잔액 없음!");
				} else {
					if (cashBalance < remainedTotalPrice) {
						expectedCashAmount = cashBalance;////////////////////////////////
						System.out.println("현금 잔액 부족!");
					} else {
						expectedCashAmount = remainedTotalPrice;////////////////////////////////
					}
				}

				System.out.println("예상 현금 결제 금액: " + expectedCashAmount);
				remainedTotalPrice -= expectedCashAmount;////////////////////////////////
			} else if (payment == 1) { // 신용 카드
				// 신용 카드 한도 확인
				if (CARD_LIMIT <= remainedTotalPrice) {
					System.out.println("신용 카드 한도 초과!");
				} else {
					expectedCreditCardAmount = remainedTotalPrice;////////////////////////////////
					remainedTotalPrice -= expectedCreditCardAmount;////////////////////////////////
					System.out.println("예상 신용 카드 결제 금액: " + expectedCreditCardAmount);
					// 할부 여부 & 기간
					if (expectedCreditCardAmount >= SIGN_INST_THRESHOLD) {
						instDuration = (int) (Math.random() * 12) + 1;////////////////////////////////
						System.out.println("할부 기간: " + instDuration);
					}
					isCreditCardUsed = true;
				}
			} else if (payment == 2) { // 체크 카드
				// 체크 카드 잔액 확인
				if (checkCardBalance <= remainedTotalPrice) {
					System.out.println("체크 카드 잔액 부족!");
				} else {
					expectedCreditCardAmount = remainedTotalPrice;////////////////////////////////
					remainedTotalPrice -= expectedCreditCardAmount;////////////////////////////////
					System.out.println("예상 체크 카드 결제 금액: " + expectedCheckCardAmount);
				}
			}
			System.out.println();
		}
		System.out.println();

		// 최종 결제 진행
		if (remainedTotalPrice > 0) {
			paySuccess = false;
		}
		if (paySuccess) {
			pointAmoumt -= expectedPointAmount;
			cashBalance -= expectedCashAmount;
			checkCardBalance -= expectedCheckCardAmount;
			if (isPointEarned) {
				pointAmoumt += getPointToBeEarned((totalPrice - expectedPointAmount), EARNING_POINT_RATIO);
			}
			if (isCreditCardUsed && expectedCreditCardAmount >= SIGN_INST_THRESHOLD) {
				System.out.println("서명해주세요.");
			}
			System.out.println("====== 영수증 ======");
			System.out.println("상품명\t수량\t금액");
			for (int i = 0; i < ITEM_NUM; ++i) {
				System.out.println("상품 " + (i + 1) + "\t" + 1 + "\t" + itemPrices[i]);
			}
			if (isBagNeeded) {
				System.out.println("봉투 \t" + bagCount + "\t" + (bagCount * BAG_PRICE));
			}
			System.out.println("총 결제 금액: " + totalPrice);
			System.out.println();

			System.out.println("결제 수단\t\t결제 금액");
			System.out.println("포인트\t\t" + expectedPointAmount);
			System.out.println(PAY_METHOD[0] + "\t\t" + expectedCashAmount);
			System.out.println(PAY_METHOD[1] + "\t\t" + expectedCreditCardAmount);
			System.out.println(PAY_METHOD[2] + "\t\t" + expectedCheckCardAmount);
			if (isPointEarned) {
				System.out.print(((totalPrice - expectedPointAmount) * 0.1) + " 포인트 적립됨.");
			}

		} else {
			System.out.println("다음 기회에...");
		}
	}
}
