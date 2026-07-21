package oop;

/**
 * 인형뽑기 게임 흉내내기 실습
 */
public class CraneGameMachine {
	/**
	 * 코인 투입 여부
	 */
	boolean isInsertCoin;
	/**
	 * 인형의 수
	 */
	int dolls;

	/**
	 * 인형뽑기 기계에 동전을 넣습니다
	 */
	void insertCoin() {
		// isInsertCoin = dolls > 0;
		if (isInsertCoin) {
			System.out.println("이미 동전이 투입되어있습니다.");
			return;
		}
		if (dolls <= 0) {
			System.out.println("인형이 없습니다.");
			return;
		}
		System.out.println("동전이 투입되었습니다.");
		isInsertCoin = true;
	}

	/**
	 * 게임을 진행합니다
	 * 
	 * @return
	 */
	int doGame() {
		if (!isInsertCoin) {
			System.out.println("먼저 동전을 투입해 주십시오.");
			return -1;
		}
		int success = (int) (Math.random() * 2);
		// dolls-=success;
		if (success == 1) {
			System.out.println("뽑기 성공!");
			dolls -= 1;
		} else {
			System.out.println("뽑기 실패!");
		}
		isInsertCoin = false;
		return success;
	}

	public static void main(String[] args) {
		CraneGameMachine cgm = new CraneGameMachine();
		cgm.dolls = 5;
		System.out.println("인형의 수\t: " + cgm.dolls);
		System.out.println("Coin Inserted?\t: " + cgm.isInsertCoin);
		cgm.insertCoin();
		cgm.insertCoin();
		while (cgm.dolls > 0) {
			cgm.insertCoin();
			cgm.doGame();
			System.out.println("인형의 수\t: " + cgm.dolls);
			System.out.println(	);
		}
	}
}
