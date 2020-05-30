package generic.type;

public class GenericTypeOld {
	private Object t;
	
	public Object get() {
		return t;
	}
	
	public void set(Object t) {
		this.t = t;
	}
	public static void main(String[] args) {
		GenericTypeOld type = new GenericTypeOld();
		type.set("hello");
		type.set(1);
		String str = (String) type.get();
		System.out.println(str);
	}
}
