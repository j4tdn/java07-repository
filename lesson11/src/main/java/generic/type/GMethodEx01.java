package generic.type;

import java.util.Arrays;
import java.util.List;

import javax.sound.midi.Sequence;

public class GMethodEx01 {
	public static void main(String[] args) {
		List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
		List<String> strings = Arrays.asList("1", "2", "3", "4", "5");
		List<Double> doubles = Arrays.asList(1d, 2d, 3d, 4d, 5d);
		List<Object> objects = Arrays.asList(1, "b", 3, "d", 5);
		//print(integers);
		//print(objects);
		print(strings);

	}
//number cha của integer,double.....
	private static<E extends CharSequence/*number*/> void print(List<E> objects) {//gerenic, ko sử dụng đc list<object> vì list<integer> ko phải con của .... 
		for (Object object : objects) {
			System.out.println(object + "");
		}
		System.out.println();
	}
}
