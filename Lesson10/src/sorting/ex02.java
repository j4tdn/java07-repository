package sorting;

import java.util.Arrays;
import java.util.Comparator;
import static java.util.Comparator.comparing;

import beans.Student;

public class ex02 {
	public static void main(String[] args) {
		Student[] students = mock();

		Comparator<Student> idComparator = (s1, s2) -> s1.getId().compareTo(s2.getId());
		Comparator<Student> avgComparator = (s1, s2) -> Double.compare(s1.getAvg(), s2.getAvg());
		Arrays.sort(students, new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				return o1.getId().compareTo(o2.getId());
			}
		});

		// method reference
		Comparator<Student> comparator = comparing(Student::getId)
				.thenComparing(comparing(Student::getAvg));

		//Arrays.sort(students, comparator);
		

		Arrays.stream(students).forEach(student -> System.out.println(student));
	}

	private static Student[] mock() {
		return new Student[] { new Student("sv01", "Le Van Na", 6.8, true), new Student("sv19", "Hoang Nam", 5.8, true),
				new Student("sv03", "Nguyen Teo", 3.8, false), new Student("sv01", "Dang Van Ngoc", 9.8, true),
				new Student("sv01", "Van Van", 7.2, false) };
	}
}
