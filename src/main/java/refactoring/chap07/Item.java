package refactoring.chap07;

public class Item {
	private final ItemType typecode;
	private final String title;
	private final int price;

	public Item(ItemType typecode, String title, int price) {
		this.typecode = typecode;
		this.title = title;
		this.price = price;
	}

	public int getTypecode() {
		return typecode.getTypecode();
	}

	@Override
	public String toString() {
		return String.format("[%s, %s, %s]", getTypecode(), title, price);
	}

}
