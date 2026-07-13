package workflow;

public class IfCondition {
	public static void main(String[] args) {
		int num1 = 30;
		int num2 = 30;
		// num1과 num2중에 큰 수를 출력한다
		// num1이 num2보다 크다면 num1을 출력한다
		if (num1 > num2) {
			System.out.println(num1);
		}
		// num1이 num2보다 작다면 num2를 출력한다
		else if(num1<num2) {
			System.out.println(num2);
		}
		else {
			System.out.println("SAME");
		}
	}
}
