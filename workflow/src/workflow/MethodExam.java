package workflow;

public class MethodExam {
	public static void print() {
		System.out.println();
	}

	public static void powerAndPrint(int n) {
		System.out.println(n + " ^ 2 = " + (n * n));
	}

	public static void printNameAndAge(String name, int age) {
		System.out.println("My name is " + name + " and " + age + " years old.");
	}

	public static double devideAndReturn(int a, int b) {
		try {
			return ((double) a / b);
		} catch (Exception e) {
			System.out.println(e);
			return -1;
		}
	}

	public static void main(String[] args) {
		// 단순 출력 메소드 생성 & 호출
		print();
		// 파라미터가 있는 메소드 생성 & 호출
		powerAndPrint(4);
		powerAndPrint(6);
		powerAndPrint(7);
		// 파라미터가 여러개 있는 메소드 생성 & 호출
		printNameAndAge("Gee", 88);
		// 리턴값이 있는 메소드 생성 & 호출
		double divResult1=devideAndReturn(1, 3);
		System.out.println(divResult1);
		double divResult2=devideAndReturn(1, 0);
		System.out.println(divResult2);
	}
}
