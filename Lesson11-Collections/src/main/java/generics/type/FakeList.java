package generics.type;

import java.lang.reflect.Array;
import java.util.function.Consumer;

public class FakeList<E> {
	private E[] es;

	@SuppressWarnings("unchecked")
	public FakeList() {
		es = (E[]) Array.newInstance(Object.class, 0);
	}

	public E get(int index) {
		return es[index];
	}

	public void forEach(Consumer<E> consumer) {
		for (E e : es) {
			consumer.accept(e);
		}
	}

	public boolean remove(int index) {
		if (index < 0 || index > es.length) {
			System.out.println("xoa khong thanh cong");
			return false;
		}
		@SuppressWarnings("unchecked")
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

	public int size() {
		return es.length;
	}

	public void set(int index, E e) {
		es[index] = e;
	}

	public boolean add(E e, int index) {
		if (index < 0 || index > es.length) {
			System.out.println("add khong thanh cong");
			return false;
		}
		@SuppressWarnings("unchecked")
		E[] newEs = (E[]) Array.newInstance(Object.class, es.length + 1);
		for (int i = 0; i < newEs.length; i++) {
			if (i < index) {
				newEs[i] = es[i];
			} else if (i == index) {
				newEs[i] = e;
			} else {
				newEs[i] = es[i - 1];
			}
		}
		es = newEs;
		return true;
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
}