package workflow;

public class Array {
	public static void main(String[] args) {
		/*
		 * 수 여러 개가 주어진다. 5, 6, 3, 11, ... 주어진 숫자들이 소수인지 확인한다.
		 */
		int num1 = 5;
		int num2 = 6;
		int num3 = 9;
		int num4 = 11;
		int num5 = 12;
		int num6 = 13;

		// num1이 소수이면 "소수입니다." 출력, 아니면 "소수가 아닙니다." 출력
		boolean isPrime = true;
		for (int i = 2; i <= Math.sqrt(num1); ++i) {
			if (num1 % i == 0) {
				System.out.println(num1 + " is NOT a Prime Number.");
				isPrime = false;
				break;
			}
		}
		if (isPrime) {
			System.out.println(num1 + " is a Prime Number.");
		}

		// num2가 소수이면 "소수입니다." 출력, 아니면 "소수가 아닙니다." 출력
		isPrime = true;
		for (int i = 2; i <= Math.sqrt(num2); ++i) {
			if (num2 % i == 0) {
				System.out.println(num2 + " is NOT a Prime Number.");
				isPrime = false;
				break;
			}
		}
		if (isPrime) {
			System.out.println(num2 + " is a Prime Number.");
		}

		/*
		 * 6개의 변수를 하나의 변수로 병합한다. ==> 배열 자료형[] 변수명 = new 자료형[크기]
		 */
		int[] numArray = new int[6];
		numArray[0] = 5;
		numArray[1] = 6;
		numArray[2] = 9;
		numArray[3] = 11;
		numArray[4] = 12;
		numArray[5] = 13;

		// numArray 출력
		System.out.println(numArray); // [I@4516af24 ==> Type@HashData
		
		// numArray 배열의 총 요소 개수 출력
		System.out.println(numArray.length);
		
		for (int i = 0; i < 6; i++) {
			isPrime = true;
			for (int j = 2; j <= Math.sqrt(numArray[i]); ++j) {
				if (numArray[i] % j == 0) {
					System.out.println(numArray[i] + " is NOT a Prime Number.");
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				System.out.println(numArray[i] + " is a Prime Number.");
			}
		}
	}
}
