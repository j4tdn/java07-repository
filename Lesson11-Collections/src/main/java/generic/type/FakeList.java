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

	public boolean add(E e) {
		@SuppressWarnings("unchecked")
		E[] newEs = (E[]) Array.newInstance(Object.class, es.length + 1);

		// newEs=Array.CopyOfRange(es,0,es.length):wrong length after copy
		for (int i = 0; i < es.length; i++) {
			newEs[i] = es[i];
		}
		newEs[es.length] = e;
		es = newEs;
		return true;

	}

	public void addIndex(int index, E e) {
		@SuppressWarnings("unchecked")
		E[] newEs = (E[]) Array.newInstance(Object.class, es.length + 1);

		for (int i = 0; i < newEs.length; i++) {
			if (i < index) {

				newEs[i] = es[i];

			} else if (i == index) {
				System.out.println(es[i]);
				newEs[i] = e;
			} else if (i > index) {
				newEs[i] = es[i - 1];
			}

		}
		es = newEs;
	}

	@SuppressWarnings("unchecked")
	public void remove(int index) {
		E[] newEs = (E[]) Array.newInstance(Object.class, es.length - 1);
		for (int i = 0; i < newEs.length; i++) {
			if (i < index) {

				newEs[i] = es[i];

			} else {
				newEs[i] = es[i + 1];
			}
		}
		es = newEs;
	}

	@SuppressWarnings("unchecked")
	public void remove2(E e) {
		for (int i = 0; i < es.length; i++) {
			if (contains(e)) {
				E[] newEs = (E[]) Array.newInstance(Object.class, es.length - 1);
				for (int j = 0; j < newEs.length; j++) {
					if (j < i) {

						newEs[j] = es[j];

					} else {
						newEs[j] = es[j + 1];
					}

				}
				es = newEs;
			}
		}

	}

	private boolean contains(E e) {
		for (int i = 0; i < es.length; i++) {
			if (e == es[i])
				return true;
		}
		return false;
	}

	public void forEach(Consumer<E> consumer) {
		for (E e : es) {
			consumer.accept(e);
		}
	}
	
}
