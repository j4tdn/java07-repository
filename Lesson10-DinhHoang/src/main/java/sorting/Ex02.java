package sorting;

import java.util.Arrays;
import java.util.Comparator;

import static java.util.Comparator.comparing;

import beans.Student;

public class Ex02 {
	public static void main(String[] args) {
		Student[] students = sort();

//		Comparator<Student> idComparator = (s1, s2) -> s1.getId().compareTo(s2.getId());
//		Comparator<Student> avgComparator = (s1, s2) -> Double.compare(s1.getAvg(), s2.getAvg());
//		Arrays.sort(students, idComparator);
//		Arrays.sort(students, avgComparator);
//		Arrays.sort(students, idComparator.thenComparing(avgComparator));

		// Student::getId <=> student -> student.getId
		Comparator<Student> Comparator = comparing(Student::getId).thenComparing(comparing(Student::getAvg));
		Arrays.sort(students, Comparator);

		Arrays.stream(students).forEach(student -> System.out.println(student));
	}

	private static Student[] sort() {
		return new Student[] { new Student("sv01", "Nguyễn Văn A", true, 7.5f),
				new Student("sv02", "Đặng Thị H", false, 8.0f), new Student("sv01", "Lê Đình T", true, 7.0f),
				new Student("sv01", "Phan Ngoc Q", true, 7.8f), new Student("sv03", "Đinh Thị L", false, 7.2f) };
	}
}
