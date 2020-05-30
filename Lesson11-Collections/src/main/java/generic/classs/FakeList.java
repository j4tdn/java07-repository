package generic.classs;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class FakeList<E> {
	private E[] es;

	@SuppressWarnings("unchecked")
	public FakeList() {
		es = (E[]) Array.newInstance(Object.class, 0);
	}

	@SuppressWarnings("unchecked")
	public boolean add(E e) {
		E[] newEs = (E[]) Array.newInstance(Object.class, es.length + 1);
		for (int i = 0; i < es.length; i++) {
			newEs[i] = es[i];
		}
		newEs[es.length] = e;
		es = newEs;
		return true;
	}

	public void set(int index, E e) {
		es[index] = e;
	}

	public int size() {
		return es.length;
	}

	public E get(int index) {
		return es[index];
	}

	// forEach();
	@SuppressWarnings("unused")
	public void forEach(Consumer<E> action) {
//		if (action == null) {
//			throw new NullPointerException();
//		}
//		int size = this.size();
//		for (int i = 0; i < size; i++) {
//			action.accept(elementAt(es, i));
//		}
		for (E e : es) {
			action.accept(e);
		}
	}

//	@SuppressWarnings("unchecked")
//	static <E> E elementAt(Object[] es, int index) {
//		return (E) es[index];
//	}
	
	// add(int index, E e);
	@SuppressWarnings("unchecked")
	public boolean add(int index, E e) {
		if (index < 0 || index > es.length) {
			throw new ArrayIndexOutOfBoundsException();
		}
		E[] newEs = (E[]) Array.newInstance(Object.class, es.length + 1);
		for (int i = 0; i < newEs.length; i++) {
			if (i < index) {
				newEs[i] = es[i];
			} else if (index == i) {
				newEs[i] = e;
			} else {
				newEs[i] = es[i - 1];
			}
		}
		es = newEs;
		return true;
	}
	
	// remove(int i);
	@SuppressWarnings("unchecked")
	public boolean remove(int index) {
		if (index < 0 || index > es.length) {
			throw new ArrayIndexOutOfBoundsException();
		}
		E[] newEs = (E[]) Array.newInstance(Object.class, es.length - 1);
		for (int i = 0; i < newEs.length; i++) {
			if (i < index) {
				newEs[i] = es[i];
			} else {
				newEs[i] = es[i + 1];
			}
		}
		es = newEs;
		return true;
	}

	// remove(E e)
	public boolean remove(E e) {
		for (int i = 0; i < es.length; i++) {
			if (es[i].equals(e)) {
				remove(i);
			}
		}
		return true;
	}
}
