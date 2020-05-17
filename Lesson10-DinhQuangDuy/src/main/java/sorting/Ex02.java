package sorting;

import java.util.Arrays;
import java.util.Comparator;
import static java.util.Comparator.comparing;
import java.util.function.Function;

import beans.Student;

public class Ex02 {
	public static void main(String[] args) {
		Student[] students = mock();
//		cach 1
//		Comparator<Student> idComparator =  (s1, s2) -> s1.getId().compareTo(s2.getId());
//		Comparator<Student> avgComparator = (s1, s2) -> Double.compare(s1.getAvg(), s2.getAvg());
//		
//		
//		Arrays.sort(students,idComparator.thenComparing(avgComparator));
		
//		Function<Student, String> keyExtractor = new Function<Student, String>() {
//
//			@Override
//			public String apply(Student t) {
//				
//				return t.getId();
//			}
//		};
		
		//cach 2, comparing la method static thuoc Comparator
		Comparator<Student> comparator =  comparing(Student::getId).thenComparing(comparing(Student::getAvg));
		
		// comparator, comparable
		Arrays.sort(students,comparator);
		
		Arrays.stream(students).forEach(student -> System.out.println(student));
	}

	private static Student[] mock() {
		return new Student[] {
				new Student ("sv01", "Le Van Na", 6.8, true),
				new Student ("sv31", "Le Van Teo", 7.6, false),
				new Student ("sv15", "Le Van Nam", 10, true),
				new Student ("sv01", "Tran Van Anh", 5.5, false),
				new Student ("sv31", "Hoang Van Thuong", 8.8, true),
				new Student ("sv01", "Nguyen Van Manh", 5.7, true),			
		};
	}
}
