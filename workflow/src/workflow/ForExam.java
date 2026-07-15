package workflow;

public class ForExam {
	public static void main(String[] args) {
		for (int i = 2; i < 10; ++i) {
			System.out.println();
			for (int j = 1; j < 10; ++j) {
				System.out.println(i + " * " + j + " = " + (i * j));
			}
		}
		for (int i = 0; i < 11; ++i) {
//			System.out.println("*".repeat(i));
			for (int j = 0; j < i; ++j) {
				System.out.print("*");
			}
			for (int k = 10 - i; k > 0; --k) {
				System.out.print("-");
			}
			System.out.println();
		}
	}
}
