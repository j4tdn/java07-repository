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
	public boolean add(E e) {
		E[] newEs = (E[]) Array.newInstance(Object.class, es.length + 1);
		for (int i = 0; i < es.length; i++) {
			newEs[i] = es[i];
		}
		// newEs = Arrays.copyOfRange(es, 0, es.length); wrong length after copy
		newEs[es.length] = e;
		es = newEs;
		return true;
	}

	@SuppressWarnings("unchecked")
	public boolean add(int index, E e) {
		E[] newEs = (E[]) Array.newInstance(Object.class, es.length + 1);
		int j = 0;
		for (int i = 0; i < newEs.length; i++) {
			if (i == index) {
				newEs[i] = e;
				continue;
			}
			newEs[i] = es[j];
			j++;
		}
		es = newEs;
		return true;
	}

	public void forEach(Consumer<E> consumer) {
		for (E e : es) {
			consumer.accept(e);
		}
	}

	@SuppressWarnings("unchecked")
	public boolean remove(int index) {
		E[] newEs = (E[]) Array.newInstance(Object.class, es.length - 1);
		int j = 0;
		for (int i = 0; i < es.length; i++) {
			if (i == index) {
				continue;
			}
			newEs[j] = es[i];
			j++;
		}
		es = newEs;
		return true;
	}

	public boolean remove(E e) {
		E[] newEs = (E[]) Array.newInstance(Object.class, es.length - 1);
		int j = 0;
		for (int i = 0; i < es.length; i++) {
			if (es[i] == e) {
				continue;
			}
			newEs[j] = es[i];
			j++;
		}
		es = newEs;
		return true;
	}
	// viet ham for each
	// add(int index, E e)
	// remove(int i)
	// remove(E e)
}
