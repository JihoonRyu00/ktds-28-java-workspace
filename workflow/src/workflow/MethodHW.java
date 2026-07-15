package workflow;

import java.util.*;

public class MethodHW {

	// 정수 두 개를 받아서 사칙연산(+, -, *, /) 의 결과를 출력하는 메소드를 만들고 호출해보세요.
	public static void printCalc(int a, int b) {
		System.out.println("-----결과-----");
		System.out.println(a + " + " + b + " = " + (a + b));
		System.out.println(a + " - " + b + " = " + (a - b));
		System.out.println(a + " * " + b + " = " + (a * b));
		if (b == 0) {
			System.out.println("WARN: / by zero");
		} else {
			System.out.println(a + " / " + b + " = " + (a / (double) b));
		}
	}

	// 2. 정수 한 개를 받아서 짝수라면 true를, 홀수라면 false를 반환하는 메소드를 만들고 호출해보세요.
	public static boolean isEven(int n) {
		return (n % 2 == 0);
	}

	// 3. 정수 세 개를 받아서 가장 큰 수를 출력하는 메소드를 만들고 호출해보세요.
	public static void printMax(int[] numArr) {
		int ans = Integer.MIN_VALUE;
		for (int num : numArr) {
			if (num > ans) {
				ans = num;
			}
		}
		System.out.println(ans);
	}

	// 4. 정수 한 개를 받아서 소수(prime number)라면 true를 아니라면 false를 반환하는 메소드를 만들고 호출해 보세요.
	public static boolean isPrime(int num) {
		boolean[] sieve = new boolean[num + 1];
		Arrays.fill(sieve, true);
		sieve[2] = false;
		sieve[3] = false;
		for (int curr = 4; curr <= num; ++curr) {
			for (int i = 2; i <= Math.sqrt(num); ++i) {
				if (curr % i == 0) {
					sieve[curr] = false;
					break;
				}
			}
		}
//		for (int i = 0; i <= num; ++i) {
//			System.out.print(i + ": " + sieve[i] + "\n");
//		}
		return sieve[num];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 1
		System.out.print("1. 사칙연산을 할 정수 a, b 를 입력하시오.\na >> ");
		int a = sc.nextInt();
		System.out.print("b >> ");
		int b = sc.nextInt();
		printCalc(a, b);
		System.out.println();

		// 2
		System.out.print("2. 짝수/홀수를 판별할 정수를 입력하시오. >> ");
		int n = sc.nextInt();
		if (isEven(n)) {
			System.out.println(n + " is EVEN.");
		} else {
			System.out.println(n + " is ODD.");
		}
		System.out.println();

		// 3
		System.out.print("3. 가장 큰 수를 반환\n배열의 크기를 입력하시오. >> ");
		int arrSize = sc.nextInt();
		int[] numArr = new int[arrSize];
		System.out.print("배열의 요소를 입력하시오. >> ");
		for (int i = 0; i < arrSize; ++i) {
			numArr[i] = sc.nextInt();
		}
		printMax(numArr);
		System.out.println();

		// 4
		System.out.print("4. 소수인지 판별할 정수를 입력하시오. >> ");
		int m = sc.nextInt();
		if (isPrime(m)) {
			System.out.println(m + " is a Prime number.");
		} else {
			System.out.println(m + " is NOT a Prime number.");
		}
		System.out.println();

	}
}
