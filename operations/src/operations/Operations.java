package operations;

public class Operations {
	public static void main(String[] args) {
		// 정수 변수 두 개 만들어서 다른 정수 변수에 연산의 결과를 저장한 후 출력
		int firstNum = 10;
		int secondNum = 30;
		// firstNum + secondNum
		int addResult = firstNum + secondNum;
		System.out.println(addResult);
		// firstNum - secondNum
		int subResult = firstNum - secondNum;
		System.out.println(subResult);
		// firstNum * secondNum
		int mulResult = firstNum * secondNum;
		System.out.println(mulResult);
		// firstNum / secondNum
		float divResult = (float) firstNum / secondNum;
		System.out.println(divResult);
		// firstNum % secondNum
		int modResult = firstNum % secondNum;
		System.out.println(modResult);
		//
		float firstFloatNum = 10.0f;
		float secondFloatNum = 5.0f;
		//
		float divFloatResult = firstFloatNum / secondFloatNum;
		System.out.println(divFloatResult);
		//
		final float SUBJECT_COUNT = 3f;
		int a = 80;
		int b = 90;
		int c = 87;
		float avg = (a + b + c) / SUBJECT_COUNT; // 변수를 명시적으로 형변환하기 x
		System.out.println(avg);
		//
		int maxIntVal = Integer.MAX_VALUE;
		int minIntVal = Integer.MIN_VALUE;
		System.out.println(maxIntVal + 1 == minIntVal);
		//
		int bigInt = 1_000_000_000;
		int powerResult = bigInt * bigInt;
		System.out.println(powerResult);
		//
		int num1=10;
		int num2=3;
		//
		int mod=num1%num2;
		System.out.println(mod);
		System.out.println(num1++);
		System.out.println(num1);
		System.out.println(++num1);
		//			
	}
}
