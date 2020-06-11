package view;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

import beans.Apple;
import predivate.ApplePredivate;
import service.AppleService;
import service.AppleSeviceImpl;

public class Ex01_AppleView {
	private static AppleService sevice = new AppleSeviceImpl();
	public static void main(String[] args) {
		List<Apple> inventory = sevice.getAll();
		// bieeru thuwcs lamda
		
//		ApplePredivate test = (Apple a) ->{
//			return true;
//		};
//		
//		Runnable r = () ->{
//			
//		};
//		
//		Function<String , Apple> f = (String s) -> {
//			return null;
//		};
//		
//		Comparator<Float > c = (f1, f2) -> {
//			
//			return 0;
//		};
//		
//		inventory.forEach(a -> System.out.println(a);
//		
		
//anomymous class
		ApplePredivate pridicate =  a -> a.getWeight() > 100;
		List<Apple> greenApples = sevice.filter(inventory, pridicate);
		ApplePredivate pridicates = a -> "green".equals(a.getColor());
		List<Apple> expectedFreenApples = sevice.filter(inventory,pridicates );
				
		
		
		show(inventory);
	}
	private static void show(List<Apple> inventory){
		for(Apple app : inventory) {
			System.out.println(app);
		}
	}
	
}
