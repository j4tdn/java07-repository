package generics.type;

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

	public void set(int index, E es) {
		this.es[index] = es;
	}

	public boolean add(E e) {
		@SuppressWarnings("unchecked")
		E[] newes = (E[]) Array.newInstance(Object.class, es.length + 1);
		for (int i = 0; i < es.length; i++) {
			newes[i] = es[i];
		}
		newes[es.length] = e;
		es = newes;// chi tro den o nho newes.ko copy duoc
		return true;
	}

}
