package convenience_store;

/**
 * 진열대
 */
public class Display {
	/**
	 * 한 층에 5개의 아이템을 진열한다.
	 */
	final int CAPACITY = 5;
	Item[] items = new Item[5];

	public void print() {
		System.out.print("| ");
		for (int i = 0; i < CAPACITY; ++i) {
			if (items[i] == null) {
				System.out.print("NULL | ");
			} else {
				System.out.print(items[i].name + " | ");
			}
		}
	}
}
