package date02;

public class Card<T, R> {
	private T type;
	private R thutu;

	public Card(T type, R thutu) {
		this.type = type;
		this.thutu = thutu;
	}

	public R getThutu() {
		return thutu;
	}

	public void setThutu(R thutu) {
		this.thutu = thutu;
	}

	public T getType() {
		return type;
	}

	public void setType(T type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return type + "-" + thutu;
	}

}
