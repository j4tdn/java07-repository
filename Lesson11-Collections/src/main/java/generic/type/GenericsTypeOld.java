package generic.type;

public class GenericsTypeOld {
	private Object o;

	public Object getO() {
		return o;
	}

	public void setO(Object o) {
		this.o = o;
	}
	
	public static void main(String[] args) {
		GenericsTypeOld typeOld = new GenericsTypeOld();
		typeOld.setO("aaaaa");
		typeOld.setO(3);
		
		String str = typeOld.getO().toString();
		System.out.println(str);
	}

}
