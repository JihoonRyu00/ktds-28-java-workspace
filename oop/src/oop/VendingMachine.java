package oop;

/**
 * 자판기 음료가 들어있는 자판기에 돈을 넣고 음료의 번호를 입력하면 음료가 추출된다. 거스름돈이 남았을 경우, 사용자에게 돌려준다.
 */
public class VendingMachine {

	/**
	 * 아이템 홀더 클래스 멤버 변수
	 */
	ItemHolder holder;

	/**
	 * 생성자
	 */
//	public VendingMachine() {
//		this.holder = new ItemHolder();
//	}
	public VendingMachine(ItemHolder holder) {
		this.holder = holder;
	}

	// 자판기에 새로운 아이템을 추가한다.
	public void addNewItem(int index, Item newItem) {
		this.holder.items[index] = newItem;
	}

	public static void main(String[] args) {
		Item[] itemArr = new Item[10];
		itemArr[0] = new Item("0000", "상품A", 2000, 6);
		itemArr[1] = new Item("0001", "상품B", 5000, 7);
		itemArr[2] = new Item("0002", "상품C", 100, 3);
		itemArr[3] = new Item("0003", "상품D", 3000, 2);
		itemArr[4] = new Item("0004", "상품E", 1500, 99);
		ItemHolder ih = new ItemHolder(itemArr);
		VendingMachine vm = new VendingMachine(ih);
		vm.addNewItem(5, new Item("0005", "상품F", 500, 1));
	}
}
