package workflow;

import java.util.*;

public class MethodHW2 {
	// 1. 정수형 변수 2개를 파라미터로 받아, 값을 출력하는 메소드.
	public static void printTwoIntegers(int a, int b) {
		System.out.println("a: " + a + ", b: " + b);
	}

	// 2. 정수형 변수 2개를 파라미터로 받아, 합계를 출력하는 메소드.
	public static void printSumOfTwoIntegers(int a, int b) {
		System.out.println(a + " + " + b + " = " + (a + b));
	}

	// 3. 정수형 변수 3개를 파라미터로 받아, 합계를 반환하는 메소드.
	public static int returnSumOfThreeIntegers(int a, int b, int c) {
		return (a + b + c);
	}

	// 4-1. 정수형 변수 2개를 파라미터로 받아, 나누기의 결과(실수)를 출력하는 메소드.
	public static void printDivideResult(int a, int b) {
		if (b == 0) {
			System.out.println("Divide by 0.");
			return;
		}
		System.out.println(a + " / " + b + " = " + (a / b));
	}

	// 4-2. 정수형 변수 2개를 파라미터로 받아, 나누기의 결과(실수)를 반환하는 메소드.
	public static float returnDivideResult(int a, int b) {
		return (float) a / b;
	}

	// 5. 실수형 변수 1개와 정수형 파라미터 1개를 받아 소수점 이하 자리수를 변경하여 반환하는 메소드.
	//
	// -> 예> 소수점 변경(10.33333333, 2) ==> 10.33
	//
	// -> 예> 소수점 변경(10.33333333, 3) ==> 10.333
	//
	// -> 예> 소수점 변경(10.33333333, 1) ==> 10.3
	//
	// -> 예> 소수점 변경(10.33333333, 0) ==> 10.0
	public static float returnRevisedFloat(float f, int i) {
		return (int) (f * Math.pow(10, i)) / (float) Math.pow(10, i);
	}

	// 6. 실수형 변수 2개를 파라미터로 받아, 가장 큰 수만 반환하는 메소드.
	public static float returnLargestFloat(float a, float b) {
		if (a > b) {
			return a;
		}
		return b;
	}

	// 7. 실수형 변수 4개를 파라미터로 받아, 가장 작은 수만 반환하는 메소드.
	public static float returnLeastFloat(float a, float b, float c, float d) {
		float ans = a;
		ans = Math.min(ans, b);
		ans = Math.min(ans, c);
		return Math.min(ans, d);
	}

	// 8. 정수 배열을 파라미터로 받아, 2,5,8 배수인 숫자만 출력하는 메소드.
	public static void printMultiples(int[] arr) {
		for (int a : arr) {
			if (a % 2 == 0 || a % 5 == 0) {
				System.out.print(a);
			}
		}
	}

	// 9. 문자열 1개와 정수형 변수 1개를 파라미터로 받아, 문자열을 정수형 변수만큼 반복 출력하는 메소드.
	public static void printStringRepeat(String s, int n) {
		for (int i = n; i > 0; --i) {
			System.out.print(s);
		}
	}

	// 10. 정수형 변수 1개를 파라미터로 받아, 해당 정수의 구구단을 출력하는 메소드.
	public static void printGugudan(int n) {
		for (int i = 1; i < 10; ++i) {
			System.out.println(n + " * " + i + " = " + (n * i));
		}
	}

	// 11. 정수형 변수 1개를 파라미터로 받아, 4부터 정수형 변수까지의 범위 중 소수(Prime Number)만 출력하는 메소드.
	public static void printPrimeNumber(int n) { // n은 4 이상의 정수
		boolean[] isPrime = new boolean[n + 1];
		Arrays.fill(isPrime, true);
		isPrime[0] = false;
		isPrime[1] = false;
		for (int i = 2; i * i <= n; ++i) {
			if (isPrime[i]) {
				for (int j = i * i; j <= n; j += i) {
					isPrime[j] = false;
				}
			}
		}
		for (int i = 4; i <= n; ++i) {
			if (isPrime[i]) {
				System.out.print(i);
			}
		}
	}

	// 12. 정수형 배열 변수 1개와 정수형 변수 1개를 파라미터로 받아, 해당 배열의 정수형변수 인덱스에 의 값을 반환하는 메소드.
	//
	// -> 예> 값(길이가 5인 배열, 2) ==> 배열의 2번 인덱스의 값
	//
	// -> 예> 값(길이가 5인 배열, 4) ==> 배열의 4번 인덱스의 값
	//
	// -> 예> 값(길이가 5인 배열, 5) ==> 0
	//
	// -> 예> 값(길이가 5인 배열, -1) ==> 0
	//
	// -> 예> 값(길이가 5인 배열, 1) ==> 배열의 1번 인덱스의 값
	//
	// -> 예> 값(길이가 5인 배열, 0) ==> 배열의 0번 인덱스의 값
	//
	// -> 예> 값(길이가 5인 배열, 3) ==> 배열의 3번 인덱스의 값
	//
	// -> 예> 값(길이가 5인 배열, 7) ==> 0
	public static int returnValueOfIndex(int[] arr, int i) {
		if (i < 0 || i > arr.length - 1) {
			return 0;
		}
		return arr[i];
	}

	// 13. 정수형 배열 변수 1개를 파라미터로 받아, 가장 처음 나오는 3의 배수만 반환하는 메소드 - 정수형 배열 변수내부에 3의 배수가
	// 없을 경우 -1 을 반환.
	public static int returnTheFirstMultipleOfThree(int[] arr) {
		for (int a : arr) {
			if (a % 3 == 0) {
				return a;
			}
		}
		return -1;
	}

	// 14. 정수형 배열 변수 2개를 파라미터로 받아, 각 배열에 중복값만 출력하는 메소드.
	//
	// -> 중복([1,2,3,4,5], [9,7,454,1,2,3]) ==> 1 2 3
	public static void printDuplicates(int[] arr1, int[] arr2) {
		for (int a : arr1) {
			for (int b : arr2) {
				if (a == b) {
					System.out.print(a);
					break;
				}
			}
		}
	}

	// 15. 정수형 배열 변수 2개를 파라미터로 받아, 각 배열에 중복되지 않는 값만 출력하는 메소드.
	//
	// -> 고유([1,2,3,4,5], [9,7,454,1,2,3]) ==> 4, 5, 9. 7, 454
	public static void printNotDuplicates(int[] arr1, int[] arr2) {
		int dupI = 0;
		int[] dups = new int[Math.max(arr1.length, arr2.length)];
		for (int a : arr1) {
			for (int b : arr2) {
				if (a == b) {
					dups[dupI] = a;
					dupI++;
					break;
				}
			}
		}
		for (int a : arr1) {
			boolean isDup = false;
			for (int i = 0; i < dupI; ++i) {
				if (a == dups[i]) {
					isDup = true;
					break;
				}
			}
			if (!isDup) {
				System.out.print(a);
			}
		}
		for (int a : arr2) {
			boolean isDup = false;
			for (int i = 0; i < dupI; ++i) {
				if (a == dups[i]) {
					isDup = true;
					break;
				}
			}
			if (!isDup) {
				System.out.print(a);
			}
		}
	}

	// 16. 정수형 배열 변수 1개를 파라미터로 받아, 모든 값들을 배수로 만드는(반환X) 메소드.
	//
	// -> 호출 이후에 main 메소드 내부에서 배열 내부의 값들을 모두 출력.
	public static void doubleArray(int[] arr) {
		for (int i = 0; i < arr.length; ++i) {
			arr[i] *= 2;
		}
	}

	public static void main(String[] args) {
		// 1
		printTwoIntegers(10, 20);

		// 2
		printSumOfTwoIntegers(15, 30);

		// 3
		int sum3 = returnSumOfThreeIntegers(5, 10, 15);
		System.out.println("3번 결과: " + sum3);

		// 4-1
		printDivideResult(5, 2);

		// 4-2
		float divResult = returnDivideResult(5, 2);
		System.out.println("4-2번 결과: " + divResult);

		// 5
		System.out.println("5번 결과: " + returnRevisedFloat(10.33333333f, 2));

		// 6
		float maxFloat = returnLargestFloat(5.5f, 7.7f);
		System.out.println("6번 결과: " + maxFloat);

		// 7
		float minFloat = returnLeastFloat(4.4f, 2.2f, 9.9f, 1.1f);
		System.out.println("7번 결과: " + minFloat);

		// 8
		System.out.print("8번 결과: ");
		int[] sampleArr1 = { 2, 3, 5, 7, 8, 11 };
		printMultiples(sampleArr1);
		System.out.println();

		// 9
		System.out.print("9번 결과: ");
		printStringRepeat("자바", 3);
		System.out.println();

		// 10
		System.out.println("10번 결과: ");
		printGugudan(3);

		// 11
		System.out.print("11번 결과: ");
		printPrimeNumber(15);
		System.out.println();

		// 12
		int[] sampleArr2 = { 10, 20, 30, 40, 50 };
		System.out.println("12번 결과(정상 인덱스): " + returnValueOfIndex(sampleArr2, 2));
		System.out.println("12번 결과(벗어난 인덱스): " + returnValueOfIndex(sampleArr2, 5));

		// 13
		int[] sampleArr3 = { 1, 2, 6, 4, 9 };
		System.out.println("13번 결과: " + returnTheFirstMultipleOfThree(sampleArr3));

		// 14
		System.out.print("14번 결과: ");
		int[] dupArr1 = { 1, 2, 3, 4, 5 };
		int[] dupArr2 = { 9, 7, 454, 1, 2, 3 };
		printDuplicates(dupArr1, dupArr2);
		System.out.println();

		// 15
		System.out.print("15번 결과: ");
		printNotDuplicates(dupArr1, dupArr2);
		System.out.println();

		// 16
		System.out.print("16번 결과(변경 전): ");
		int[] sampleArr4 = { 1, 2, 3, 4, 5 };
		for (int n : sampleArr4) {
			System.out.print(n + " ");
		}
		System.out.println();

		doubleArray(sampleArr4);

		System.out.print("16번 결과(변경 후): ");
		for (int n : sampleArr4) {
			System.out.print(n + " ");
		}
		System.out.println();
	}
}
