package sorting;

import java.util.Arrays;
import java.util.Comparator;
import static java.util.Comparator.comparing;

import beans.Student;

public class Ex02 {
	public static void main(String[] args) {
		Student[] students = mock();
		
		// Comparator<Student> idComparator = (s1, s2) -> s1.getId().compareTo(s2.getId());
		// Comparator<Student> avgComparator = (s1, s2) -> Double.compare(s2.getAvg(), s1.getAvg());
		
		
		// method reference
		// Comparator<Student> idComparator = Comparator.comparing(student -> student.getId());
		Comparator<Student> comparator = comparing(Student::getId)
				.thenComparing(comparing(Student::getAvg));
		
		// Comparator, Comparable
		// Arrays.sort(students, comparator);
		Arrays.sort(students);
		
		Arrays.stream(students).forEach(student -> System.out.println(student));
	}
	
	private static Student[] mock() {
		return new Student[]{
				new Student("sv01", "Le Van Na", 6.8, true),
				new Student("sv31", "Hoang Nam", 5.8, true),
				new Student("sv01", "Nguyen Teo", 3.8, false),
				new Student("sv28", "Dang Van Ngoc", 9.8, true),
				new Student("sv01", "Van Van", 7.2, false),
				
		};
	}
}
