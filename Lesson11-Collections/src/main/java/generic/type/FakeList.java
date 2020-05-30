package generic.type;

import java.lang.reflect.Array;
import java.util.Arrays;
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

	public boolean add(E e, int index) {
		if (index < 0 || index > es.length) {
			System.err.println("index nhập vào không hợp lệ.");
		}
		E[] newEs = (E[]) Array.newInstance(Object.class, es.length + 1);
		for (int i = 0; i < es.length; i++) {
			if (i == index - 1) {
				continue;
			}
			newEs[i] = es[i];
		}
		newEs[index - 1] = e;
		es = newEs;
		return true;
	}

	public boolean remove(int index) {
		if (index < 0 || index > es.length) {
			System.err.println("index nhập vào không hợp lệ.");
		}
		for (int i = 0; i < es.length; i++) {
			if (i < index - 1) {
				continue;
			}
			es[i] = es[i+1];
		}
		return true;
	}
	public boolean remove(E e) {
		E[] newEs = (E[]) Array.newInstance(Object.class, es.length + 1);
		for (int i = 0; i < es.length; i++) {
			newEs[i] = es[i];
		}
		newEs[es.length] = e;
		es = newEs;
		return true;
	}
	
	public void forEach(Consumer<E> consumer) {
		for (E e : es) {
			consumer.accept(e);
		}
	}
	
	public void set(int index, E e) {
		es[index] = e;
	}

	public E get(int index) {
		return es[index];
	}

	public int size() {
		return es.length;
	}

}
