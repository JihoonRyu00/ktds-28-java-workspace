package if_else_exam;

public class ProgrammersQuiz1 {
	public static void main(String[] args) {
		int angle = 80;
		int answer = 0;
		if (angle < 90) {
			answer = 1;
		} else if (angle == 90) {
			answer = 2;
		} else if (angle < 180) {
			answer = 3;
		} else {
			answer = 4;
		}
		System.out.println(answer);
	}
}
