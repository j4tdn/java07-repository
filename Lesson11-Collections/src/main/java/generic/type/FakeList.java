package generic.type;

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

	public int size() {
		return es.length;
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
		newEs[es.length] = e;
		es = newEs;
		return true;
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
	public E remove(int index) {
		E[] newEs = (E[]) Array.newInstance(Object.class, es.length - 1);

		for (int i = 0; i < index; i++) {
			newEs[i] = es[i];
		}
		for (int i = index; i < newEs.length; i++) {
			newEs[i] = es[i + 1];
		}
		es = newEs;
		return (E) newEs;
	}

	@SuppressWarnings("unchecked")
	public boolean remove(E e) {
		int indexes = 0;
		int index = 0;

		for (int i = 0; i < es.length; i++) {
			if (es[i] == e) {
				indexes++;
			}
		}

		E[] newEs = (E[]) Array.newInstance(Object.class, es.length - indexes);

		for (int i = 0; i < es.length; i++) {
			if (es[i] != e) {
				newEs[index++] = es[i];
			}
		}
		es = newEs;
		return true;
	}

	public void forEach(Consumer<E> consumer) {
		for (E e : es) {
			consumer.accept(e);
		}
	}
}
