package generic.willcard;

import java.util.Arrays;
import java.util.List;

public class Ex01 {
	public static void main(String[] args) {
		List<Integer> integer = Arrays.asList(1,2,3,4,5);
		List<String> strings = Arrays.asList("1", "2", "3","4");
		List<Double> doubles = Arrays.asList(1d,2d,3d,4d);
		List<Object> objects = Arrays.asList(1,"a",2,"b");
		List<Number>  numbers =Arrays.asList(1,2d,3f,4,5);
		
		print(numbers);
		show(numbers);
		
	}
	private static void print(List<? extends Number> list ) {// nó và con của nó
		list.forEach(item -> System.out.print(item+" "));
	}
	private static void show(List<? super Integer> list ) {// nó và cha của nó
		list.forEach(item -> System.out.print(item+" "));
	}
	
	// giống nhau: 
	
	// khac nhau : GNR chỉ hổ trợ giới hạn trên exten
	//           :  WILLC vừa hỗ trợ giói hạn trên và giới hạn dưới
	

}
