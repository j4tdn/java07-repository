package sorting;

import java.util.Arrays;
import java.util.Comparator;
import static java.util.Comparator.comparing;

import beans.Student;

public class Ex02 {
	public static void main(String[] args) {

		Student[] students = mock();

		//Comparator<Student> idComparator = (s1, s2) -> s1.getId().compareTo(s2.getId());
		//Comparator<Student> avgComparator = (s1, s2) -> Double.compare(s1.getAvg(), s2.getAvg());

	//	Funtion<Student,String> key=new Funtion(Student,String);
		
		Comparator<Student> comparator = comparing(Student::getId).thenComparing(comparing(Student::getAvg));
		
		Arrays.sort(students,comparator);
		
		
		Arrays.stream(students).forEach(student -> System.out.println(student));

	}

	private static Student[] mock() {
		return new Student[] { new Student("sv01", "Le Linh", 6.8, true), new Student("sv04", "Le Loc", 7.8, true),
				new Student("sv02", "Le Luong", 8.2, true), new Student("sv09", "Le Lam", 2.8, false),
				new Student("sv06", "Le La", 6.8, true), new Student("sv10", "Le Ly", 6.0, true),

		};
	}
}
