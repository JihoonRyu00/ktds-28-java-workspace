package workflow;

import java.util.Scanner;

public class DiceGame2 {

	final static int DESTINATION = 127;
	final static int PLAYER_NUM = 4;
	final static int DICE_NUM = 2;

	static int[] playerPositions = new int[PLAYER_NUM];
	static String[] playerNames = new String[PLAYER_NUM];
	static int[] diceValues = new int[DICE_NUM];

	public static int roleDice() {
		int steps = 0;
		for (int j = 0; j < DICE_NUM; ++j) {
			diceValues[j] = (int) (Math.random() * 20) + 1;
			steps += diceValues[j];
		}
		if (steps % 3 == 0) {
			return -steps;
		} else if (diceValues[0] == diceValues[1]) {
			return steps * 2;
		} else {
			return steps;
		}
	}

	public static boolean isAnyArrived(int[] positions) {
		for (int i = 0; i < PLAYER_NUM; ++i) {
			if (positions[i] >= DESTINATION) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int turn = 1;
		int currSteps = 0;
		try (Scanner sc = new Scanner(System.in)) {
			for (int i = 0; i < PLAYER_NUM; ++i) {
				System.out.print("Enter Player " + (i + 1) + "'s name >> ");
				playerNames[i] = sc.next();
			}
		}
		System.out.print("\n-----GAME START-----\n\n");
		while (true) {
			System.out.println("**TURN " + turn + "**");
			System.out.println("=".repeat(60));

			for (int i = 0; i < PLAYER_NUM; ++i) {
				currSteps = roleDice();
				System.out.println("Player [" + playerNames[i] + "]'s turn.\t\tPos: " + playerPositions[i]);
				for (int d = 0; d < DICE_NUM; ++d) {
					System.out.print("Dice " + (d + 1) + ": " + diceValues[d] + "\t");
				}
				System.out.println("Steps to go: " + currSteps);
				System.out.println("-".repeat(60));
				playerPositions[i] += currSteps;
				if (playerPositions[i] < 0) {
					playerPositions[i] = 0;
				} else if (playerPositions[i] > DESTINATION) {
					playerPositions[i] = DESTINATION;
				}
				for (int p = 0; p < PLAYER_NUM; ++p) {
					System.out.print("[" + playerNames[p] + "]:\t" + playerPositions[p] + "\t\t");
					if (p % 2 == 1 || p == PLAYER_NUM - 1) {
						System.out.println();
					}
				}
				System.out.println("=".repeat(60));
			}

			System.out.println();
			System.out.println();
			turn++;

			if (isAnyArrived(playerPositions)) {
				break;
			}
		}
		System.out.print("*****WINNERS*****\n");
		for (int i = 0; i < PLAYER_NUM; ++i) {
			if (playerPositions[i] == 127) {
				System.out.println("> " + playerNames[i]);
			}
		}
	}
}
