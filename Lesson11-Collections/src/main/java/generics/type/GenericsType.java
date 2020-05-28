package generics.type;

public class GenericsType<T> {
	private T t;

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}
	public static void main(String[] args) {
		GenericsType<String> type =new GenericsType<>();
		type.setT("panda");
		type.setT(1);
		GenericsType type1=new GenericsType();
		type1.setT("panda");
		type1.setT(1);
		System.out.println(type1.getT());
	}

}
