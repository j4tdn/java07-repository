package generic.type;

public class GenericsType<T> {
	private T t;

	public T get() {
		return t;

	}

	public void set(T t1) {
		this.t = t;

	}

	public static void main(String[] args) {
		GenericsType<String> type = new GenericsType<String>();
		type.set("Pankaj");
		//type.set(1); lỗi tại complie
		GenericsType type1 = new GenericsType();
		type.set("Pankaj");
		type1.set(10);
		System.out.println(type1.get());
	}
}