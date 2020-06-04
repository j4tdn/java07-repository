package generic.type28;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.function.Consumer;

public class FakeList<E> {
	private E[] es;

	public int size() {
		return es.length;
	}

	public E get(int index) {
		return es[index];
	}

	public void set(int index, E e) {
		this.es[index] = e;
	}

	public FakeList() {
		es = (E[]) Array.newInstance(Object.class, 0);
	}

	public boolean add(E e) {
		E[] newEs = (E[]) Array.newInstance(Object.class, es.length + 1);
//		newEs = Arrays.copyOfRange(es, 0, es.length);waring 
		for (int i = 0; i < es.length; i++) {
			newEs[i] = es[i];
		}
		newEs[es.length] = e;
		es = newEs;
		return true;
	}

	// kiểm tra tại lớp
	// forEACH

	public void forEach1(Consumer<E> consumer) {
		for (E e : es) {
			consumer.accept(e);
		}
	}

	// add(int index,E e)

	public boolean add(int index, E e) {

		if (index < 0 || index > es.length) {
			throw new ArrayIndexOutOfBoundsException();
		}
		@SuppressWarnings("unchecked")
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

	// remove(int index )
	public boolean remove(int index) {
		if (index < 0 || index > es.length)
			throw new ArrayIndexOutOfBoundsException();

		E[] newEx = (E[]) Array.newInstance(Object.class, es.length + 1);
		for (int i = 0; i < newEx.length; i++) {
			if (i < index) {
				newEx[i] = es[i];
			}else newEx[i] = es[i + 1];
		}
		es = newEx;
		return true;
	}

	// remove(E e)
	public boolean removeI(E e) {
		for(int i = 0; i < es.length; i++) {
			if(es[i].equals(e)) {
				remove(i);
			}
		}
		return true;
	}
}
