package arrays;

import java.util.Arrays;
import java.util.Comparator;
import static java.util.Comparator.comparing;
import java.util.function.Function;

public class Ex02 {
	public static void main(String[] args) {
		student[] students= mockS();
		
		//Comparator<student> idComparator =(s1,s2)->s1.getId().compareTo(s2.getId());
		//Comparator<student> avgComparator=(s1,s2)->Double.compare(s1.getAvg(), s2.getAvg());
		
//		Comparator<student> comparator = Comparator.comparing(student::getId)
//				.thenComparing(comparing(student::getAvg));
//		Arrays.sort(students,comparator);
		
		Arrays.sort(students);
		
//		Arrays.sort(students,new Comparator<student>() {
//
//			@Override
//			public int compare(student o1, student o2) {
//				// TODO Auto-generated method stub
//				return o1.getId().compareTo(o2.getId());
//			}
//		});
		Arrays.stream(students).forEach(student -> System.out.println(student + " "));
		
	}
	private static student[] mockS() {
		return new student[] {
				new student("sv01","le van teo",5.6,true),
				new student("sv02","quang van kha",5.7,true),
				new student("sv03","le van ttr",5.6,false),
				new student("sv01","ho van end",5.0,true),
				new student("sv05","le van bao",5.9,false)
				
		};
	}

}
