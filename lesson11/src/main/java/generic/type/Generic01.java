package generic.type;

public class Generic01 {
	private Object t;

	public Object get()

	{

		return t;
	}

	public void set(Object t) {
		this.t = t;

	}

	public static void main(String[] args) {
		Generic01 type = new Generic01();
		type.set("Hello");
		type.set(1);
		String str = (String) type.get();
		System.out.println(str);
	}

}
