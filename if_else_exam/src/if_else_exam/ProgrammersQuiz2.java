package if_else_exam;

public class ProgrammersQuiz2 {
	public static void main(String[] args) {
		int answer = 0;
		final int LAMB_PRICE = 12_000;
		final int DRINK_PRICE = 2_000;
		int lamb = 32;
		int drink = 5;

		answer += (lamb * LAMB_PRICE) + (drink * DRINK_PRICE);
		int service = lamb / 10;
		if (service >= drink) {
			answer -= drink * DRINK_PRICE;
		} else {
			answer -= service * DRINK_PRICE;
		}

		System.out.println(answer);
	}
}
