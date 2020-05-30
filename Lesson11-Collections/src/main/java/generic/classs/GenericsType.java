package generic.classs;

public class GenericsType<T> {
	T t;

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}
	
	public static void main(String[] args) {
		GenericsType<String> type = new GenericsType();
		type.setT("Hello");
		//type.setT(1);
		String str = (String) type.getT();
		System.out.println(str);
	}
}
