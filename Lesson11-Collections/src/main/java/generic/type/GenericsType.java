package generic.type;

public class GenericsType<T> {
	private T t;

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}
	
	
	public static void main(String[] args) {
		GenericsType<String> type = new GenericsType<String>();
		type.setT("aaa");
		//type.setT(1);
		
		System.out.println(type.getT());
	}

}
