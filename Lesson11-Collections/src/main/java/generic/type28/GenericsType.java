package generic.type28;

public class GenericsType<T> {
	private T t;
	public T get() {
		return this.t;
	}
	public void set(T t1) {
		this.t = t1;
	}
	
	
	public static void main(String[] args) {
		GenericsType<String> type = new GenericsType<String>();
		type.set("Panka");
		//type.set(1);
		
		GenericsType type1 =  new GenericsType();
		type1.set("Panka2");
		type1.set(10);
		
		System.out.println(type1.get());
	}
}
