package workflow;

public class DiceGame {
	public static void main(String[] args) {
		/*
		 * 주사위를 굴려 최종 목적지에 먼거 도착하는 플레이어가 승리하는 게임
		 * 
		 * 위치값이 0인 4명의 플레이어
		 * 
		 * 각 플레이어들은 매 턴 주사위 두 개를 굴려 나온 수의 합만큼 이동
		 * 
		 * 도착지의 위치 값은 127
		 * 
		 * =====규칙=====
		 * 
		 * 1. 두 값의 합이 3의 배수일 때, 그만큼 위치값 감소
		 * 
		 * 2. 두 값의 합이 3의 배수가 아니면서 같은 숫자일 때, 합의 두 배 만큼 이동
		 * 
		 * 3. 나머지 경우일 때, 합만큼 이동
		 * 
		 * 플레이어의 위치 값은 항상 0 이상
		 * 
		 * 주사위를 굴릴 때마다 주사위의 값, 이동할 칸의 수, 현재 위치값 표시
		 */ 
		final int DESTINATION = 127;
		int turn = 1;
		int p1Pos = 0;
		int p2Pos = 0;
		int p3Pos = 0;
		int p4Pos = 0;
		int dice1Val = 0;
		int dice2Val = 0;
		int sumVal = 0;
		int steps = 0;
		while (p1Pos < DESTINATION && p2Pos < DESTINATION && p3Pos < DESTINATION && p4Pos < DESTINATION) {
			System.out.println("**TURN " + turn + "**");
			System.out.println("=".repeat(60));

			// P1's turn
			dice1Val = (int) (Math.random() * 20) + 1;
			dice2Val = (int) (Math.random() * 20) + 1;
			sumVal = dice1Val + dice2Val;
			if (sumVal % 3 == 0) {
				steps = -sumVal;
			} else if (dice1Val == dice2Val) {
				steps = sumVal * 2;
			} else {
				steps = sumVal;
			}
			System.out.println("P1's turn. Pos: " + p1Pos);
			System.out.println("Dice 1: " + dice1Val + "\tDice 2: " + dice2Val);
			System.out.println("Steps to go: " + steps);
			System.out.println("-".repeat(60));
			p1Pos += steps;
			if (p1Pos < 0) {
				p1Pos = 0;
			} else if (p1Pos > DESTINATION) {
				p1Pos = DESTINATION;
			}
			System.out.println("P1:\t" + p1Pos + "\t\tP2:\t" + p2Pos + "\nP3:\t" + p3Pos + "\t\tP4:\t" + p4Pos);
			System.out.println("=".repeat(60));

			// P2's turn
			dice1Val = (int) (Math.random() * 20) + 1;
			dice2Val = (int) (Math.random() * 20) + 1;
			sumVal = dice1Val + dice2Val;
			if (sumVal % 3 == 0) {
				steps = -sumVal;
			} else if (dice1Val == dice2Val) {
				steps = sumVal * 2;
			} else {
				steps = sumVal;
			}
			System.out.println("P2's turn. Pos: " + p2Pos);
			System.out.println("Dice 1: " + dice1Val + "\tDice 2: " + dice2Val);
			System.out.println("Steps to go: " + steps);
			System.out.println("-".repeat(60));
			p2Pos += steps;
			if (p2Pos < 0) {
				p2Pos = 0;
			} else if (p2Pos > DESTINATION) {
				p2Pos = DESTINATION;
			}
			System.out.println("P1:\t" + p1Pos + "\t\tP2:\t" + p2Pos + "\nP3:\t" + p3Pos + "\t\tP4:\t" + p4Pos);
			System.out.println("=".repeat(60));

			// P3's turn
			dice1Val = (int) (Math.random() * 20) + 1;
			dice2Val = (int) (Math.random() * 20) + 1;
			sumVal = dice1Val + dice2Val;
			if (sumVal % 3 == 0) {
				steps = -sumVal;
			} else if (dice1Val == dice2Val) {
				steps = sumVal * 2;
			} else {
				steps = sumVal;
			}
			System.out.println("P3's turn. Pos: " + p3Pos);
			System.out.println("Dice 1: " + dice1Val + "\tDice 2: " + dice2Val);
			System.out.println("Steps to go: " + steps);
			System.out.println("-".repeat(60));
			p3Pos += steps;
			if (p3Pos < 0) {
				p3Pos = 0;
			} else if (p3Pos > DESTINATION) {
				p3Pos = DESTINATION;
			}
			System.out.println("P1:\t" + p1Pos + "\t\tP2:\t" + p2Pos + "\nP3:\t" + p3Pos + "\t\tP4:\t" + p4Pos);
			System.out.println("=".repeat(60));

			// P4's turn
			dice1Val = (int) (Math.random() * 20) + 1;
			dice2Val = (int) (Math.random() * 20) + 1;
			sumVal = dice1Val + dice2Val;
			if (sumVal % 3 == 0) {
				steps = -sumVal;
			} else if (dice1Val == dice2Val) {
				steps = sumVal * 2;
			} else {
				steps = sumVal;
			}
			System.out.println("P4's turn. Pos: " + p4Pos);
			System.out.println("Dice 1: " + dice1Val + "\tDice 2: " + dice2Val);
			System.out.println("Steps to go: " + steps);
			System.out.println("-".repeat(60));
			p4Pos += steps;
			if (p4Pos < 0) {
				p4Pos = 0;
			} else if (p4Pos > DESTINATION) {
				p4Pos = DESTINATION;
			}
			System.out.println("P1:\t" + p1Pos + "\t\tP2:\t" + p2Pos + "\nP3:\t" + p3Pos + "\t\tP4:\t" + p4Pos);
			System.out.println("=".repeat(60));

			System.out.println();
			System.out.println();
			turn++;
		}
		System.out.print("WINNER IS ");
		if (p1Pos == 127) {
			System.out.print("P1\t");
		}
		if (p2Pos == 127) {
			System.out.print("P2\t");
		}
		if (p3Pos == 127) {
			System.out.print("P3\t");
		}
		if (p4Pos == 127) {
			System.out.print("P4\t");
		}
	}
}
