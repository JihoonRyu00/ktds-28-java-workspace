package workflow;

public class ReserveSeat {
	public static void main(String[] args) {
		final int SEAT_NUM = 50;
		int[] seats = new int[SEAT_NUM];
		// 랜덤하게 좌석을 배정
		// 0: 예약 가능, 1: 예약 불가
		int availableSeatNum = 0;
		for (int i = 0; i < SEAT_NUM; ++i) {
			seats[i] = (int) (Math.random() * 2);
			if (seats[i] == 0) {
				availableSeatNum++;
			}
		}
		// 배열의 모든 요소 출력
		System.out.print("\\ ");
		for (int i = 0; i < 10; ++i) {
			System.out.print(i + 1 + " ");
		}
		System.out.println();
		char row = 'A';
		for (int i = 0; i < SEAT_NUM; ++i) {
			if (i % 10 == 0) {
				System.out.print(row);
				row++;
				System.out.print(" ");
			}
			System.out.print(seats[i] + " ");
			if (i % 10 == 9) {
				System.out.println();
			}
		}
		System.out.println();

		// 예약 가능한 좌석 수 출력
		System.out.println(availableSeatNum + "개의 좌석을 예약할 수 있습니다.");
		// 예약 불가한 좌석 수 출력
		System.out.println(SEAT_NUM - availableSeatNum + "개의 좌석이 이미 예약되어 있습니다.");

		// longText 문자열 변수에 's'가 몇 개 있는지 구하시오
		String longText = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since 1966, when designers at Letraset and James Mosley, the librarian at St Bride Printing Library in London, took a 1914 Cicero translation and scrambled it to make dummy text for Letraset's Body Type sheets. It has survived not only many decades, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised thanks to these sheets and more recently with desktop publishing software like Aldus PageMaker and Microsoft Word including versions of Lorem Ipsum.";

		char[] letters = longText.toCharArray();
		int sumS = 0;
		for (int i = 0; i < letters.length; ++i) {
			if (letters[i] == 's') {
				sumS++;
			}
		}
		System.out.println("There are " + sumS + " in longText.");
		System.out.print(letters[letters.length - 1]);

	}
}
