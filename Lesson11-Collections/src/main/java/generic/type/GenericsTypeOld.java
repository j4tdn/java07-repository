package generic.type;

public class GenericsTypeOld {
private Object t;
public Object get() {
	return t;
	
}
public void set(Object t) {
	this.t=t;
	
}
public static void main(String[] args) {
	GenericsTypeOld type=new GenericsTypeOld();
	type.set("hello");
	//type.set(1);
	String str=(String) type.get();
	System.out.println(str);
}
}
