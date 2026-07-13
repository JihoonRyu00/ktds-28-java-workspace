package variables;

public class FloatingNumberVariables {
	public static void main(String[] args) {
		// 실수 변수 생성
		float floatNumber1=3.444f;
		float floatNumber2=3.F;
		float floatNumber3=3;
		float floatNumber4=3.12345678901234567890f; // 언더플로우
		double doubleNumber=3.12345678901234567890; // 언더플로우

		
		System.out.println(floatNumber1);
		System.out.println(floatNumber2);
		System.out.println(floatNumber3);
		System.out.println(floatNumber4);
		System.out.println(doubleNumber);

	}
}
