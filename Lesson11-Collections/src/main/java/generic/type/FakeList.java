package generic.type;

import java.lang.reflect.Array;
import java.util.Arrays;

public class FakeList<E> {
	private E[] es;

	@SuppressWarnings("unchecked")
	public FakeList() {
		es = (E[]) Array.newInstance(Object.class, 0);
	}

	public int size() {

		return es.length;

	}

	public E get(int index) {
		return es[index];

	}

	public void set(int index, E e) {
		es[index] = e;
	}

	public boolean add(E e) {
		@SuppressWarnings("unchecked")
		E[] newEs = (E[]) Array.newInstance(Object.class, es.length + 1);
		
		//newEs=Array.CopyOfRange(es,0,es.length):wrong length after copy
		for (int i = 0; i < es.length; i++) {
			newEs[i] = es[i];
		}
		newEs[es.length] = e;
		es = newEs;
		return true;

	}
}
