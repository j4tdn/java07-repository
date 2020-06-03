package generic.type;

public class GClassEx02<T> {
	private T t;

	public T get() {
		return t;
	}

	public void set(T t) {
		this.t = t;
	}

	public static void main(String[] args) {
		GClassEx02<String> type = new GClassEx02<>();
		type.set("Hello");
//		type.set(1);

		GClassEx02 type2 = new GClassEx02();
		type2.set("Hello");
		type2.set(10);
		System.out.println(type.get());
	}
}
