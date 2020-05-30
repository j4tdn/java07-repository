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
	public void forEach(Consumer<E> consumer) {
		for(E e : es) {
			consumer.accept(e);
		}
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
}
