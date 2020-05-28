package generic.type;

public class GClassEx01 {
	private Object t;

	public Object get() {
		return t;
	}

	public void set(Object t) {
		this.t = t;
	}

	public static void main(String[] args) {
		GClassEx01 type = new GClassEx01();
		type.set("Hello");
		type.set(1);
		String str = (String) type.get();
		System.out.println(str);
	}
}