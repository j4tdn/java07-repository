
package generics.type;

public class GenericsType<T> {
	private T t;

	public T get() {
		return this.t;
	}

	public void set(T t1) {
		this.t = t1;
	}

	public static void main(String[] args) {
		GenericsType<String> type = new GenericsType<>();
		type.set("Pankaj"); // valid
		// type.set(1);

		GenericsType type1 = new GenericsType();
		type1.set("Pankaj");
		type1.set(10);

		System.out.println(type1.get());
	}
}
