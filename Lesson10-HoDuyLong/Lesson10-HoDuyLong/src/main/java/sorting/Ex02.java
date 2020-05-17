package sorting;

import java.util.Arrays;
import java.util.Comparator;
import static java.util.Comparator.comparing;

import beans.Student;

public class Ex02 {
	public static void main(String[] args) {
		Student[] students = mock();
		
//		Comparator<Student> idComparator = (s1, s2) -> s1.getId().compareTo(s2.getId());
//		Comparator<Student> avgComparator = (s1, s2) -> Double.compare(s2.getAvg(), s1.getAvg());
		Comparator<Student> comparator = comparing(Student::getId).thenComparing(comparing(Student::getAvg));
		
		Arrays.sort(students, comparator);
		
		Arrays.stream(students).forEach(student -> System.out.println(student));
	}
	
	private static Student[] mock() {
		return new Student[] {
			new Student("sv10", "Le Van A", 6.8, true),
			new Student("sv32", "Le Van B", 7.8, false),
			new Student("sv10", "Nguyen Van C", 8.8, false),
			new Student("sv01", "Ho Thi D", 9.8, true),
			new Student("sv10", "Lee Song Jun", 5.8, true),
		};
	}
}
