package generic.type28;

import java.lang.reflect.Array;
import java.util.Arrays;

public class FakeList<E> {
	private E[] es;

	public int size() {
		return es.length;
	}

	public E get(int index) {
		return es[index];
	}

	public void set(int index, E e) {
		this.es[index] = e;
	}
	
	public FakeList() {
		es =(E[])Array.newInstance(Object.class,0);
	}
	public boolean add( E e ) {
		E[] newEs = (E[])Array.newInstance(Object.class,es.length + 1);
//		newEs = Arrays.copyOfRange(es, 0, es.length);waring 
		for(int i = 0; i < es.length;i++) {
			newEs[i] = es[i];
		}
		newEs[es.length] = e;
		es = newEs ;
		return true;
	}
	
	// kiểm tra tại lớp 
	//forEACH
	// add(int index,E e)
	//remove(int i)
	//remove(E e)
}
