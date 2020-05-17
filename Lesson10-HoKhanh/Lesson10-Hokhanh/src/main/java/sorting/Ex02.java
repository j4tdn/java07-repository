package sorting;

import java.util.Arrays;
import java.util.Comparator;
import static java.util.Comparator.comparing;


import bean.Student;

public class Ex02 {
	public static void main(String[] args) {
		Student[] students = mock();
//		Comparator<Student> idComparator=(s1, s2)->s1.getId().compareTo(s2.getId());
//		Comparator<Student> avgComparator=(s1,s2)->Double.compare(s1.getAvg(), s2.getAvg());
		
//		Comparator<Student> idComparator = Comparator.comparing(new Function<Student, String>() {
//
//			@Override
//			public String apply(Student t) {
//				return t.getId();
//			}
//			
//		});
		
		Comparator<Student> comparator = comparing(Student::getId).
				thenComparing(comparing(Student::getAvg));
		
//		Arrays.sort(students,idComparator.thenComparing(avgComparator));
		Arrays.sort(students,comparator);
		Arrays.stream(students).forEach(student->System.out.println(student));
	}
	private static Student[] mock() {
		return new Student[] {
				new Student("sv7","le van teo",3.1,true),
				new Student("sv7","le van te",5.6,true),
				new Student("sv3","le van to",8.0,false),
				new Student("sv4","le van eo",3.4,true)
		};
	}
}
