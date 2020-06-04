package generic.type;

import java.lang.reflect.Array;
import java.util.function.Consumer;

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

	@SuppressWarnings("unchecked")
	public boolean add(int index, E e) {
		E[] newEs = (E[]) Array.newInstance(Object.class, es.length + 1);
		for (int i = 0; i < index; i++) {
			newEs[i] = es[i];
		}
		newEs[index] = e;
		for (int i = index + 1; i < newEs.length; i++) {
			newEs[i] = es[i - 1];
		}
		es = newEs;
		return true;
	}

	@SuppressWarnings("unchecked")
	public boolean remove(int index) {
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

	public boolean remove(E e) {
		for (int i = 0; i < es.length; i++) {
			if (e.equals(es[i])) {
				remove(i);
				return true;
			}
		}
		return false;
	}

	public void forEach(Consumer<? super E> action) {
		for (E e : es) {
			action.accept(e);
		}
	}
}