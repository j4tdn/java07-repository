package generic.type;

import java.lang.reflect.Array;
import java.util.Arrays;

//những hàm và biến ko phụ thuộc vào đối tượng thì dùng static
public class FakeList<E> {
	private E[] es;

	@SuppressWarnings("unchecked")
	public FakeList() {
		es = (E[]) Array.newInstance(Object.class, 0);// TẠO 1 mảng object 0 phần tử
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

	public E get(int index) {
		return es[index];
	}

	public void set(int index, E e) {
		es[index] = e;
	}

	public int size() {

		return es.length;
	}

}
