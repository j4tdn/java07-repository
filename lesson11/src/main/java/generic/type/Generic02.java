package generic.type;

public class Generic02<T> {
	private T t;

	public T get() {
		return this.t;
	}

	public void set(T t1) {

		this.t = t1;

	}

	public static void main(String[] args) {
		Generic02<String> type = new Generic02<>();
		type.set("hoang ga");
		type.set("ngu");
		Generic02 type1 = new Generic02();
		type1.set("hoang ga1");
		type1.set(10);
		System.out.println(type1.get());

	}
}
