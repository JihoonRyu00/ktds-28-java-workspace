package workflow;

import java.util.Scanner;

public class UpDownGame {
	public static void main(String[] args) {
		// 키보드에서 값을 받아와 할당할 변수를 생성한다.
		Scanner keyboard = new Scanner(System.in);
		// "업다운 게임 시작" 출력
		System.out.println("업다운 게임 시작");
		// 0 ~ 99 의 숫자를 임의로 생성
		int answer = (int) (Math.random() * 100);
		// 사용자로부터 값을 입력받는다.
		// 임의의 숫자 == 사용자 입력 값일 때, "정답"을 출력
		// 임의의 숫자 > 사용자 입력 값일 때, "UP"을 출력
		// 임의의 숫자 < 사용자 입력 값일 때, "DOWN"을 출력
		int guess=-1;
		while (guess!=answer) {
			System.out.print("숫자를 입력하세요. >> ");
			guess = keyboard.nextInt();
			if (guess == answer) {
				System.out.println("\t정답\n");
				keyboard.close();
//				break;
			} else if (guess < answer) {
				System.out.println("\tUP");
			} else {
				System.out.println("\tDOWN");
			}
		}
	}
}
