package view;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Ex04 {
	public static void main(String[] args) throws IOException {

		File file = new File("student.txt");

		if (!file.exists()) {
			try {
				file.createNewFile();

			} catch (IOException e) {

				e.printStackTrace();
			}
		}

		List<String> result = Files.readAllLines(file.toPath());
		List<Student> students = new ArrayList<>();
		for (String st : result) {
			String[] student = st.split(", ");
			Student s = new Student(student[0], student[1], Float.parseFloat(student[2]), student[3]);
			students.add(s);
		}

		search(students).forEach(s -> System.out.println(s));
		System.out.println("===============================");
		searchFemaleStudent(students).forEach(s -> System.out.println(s));
		System.out.println("===============================");
		searchNonDulicateName(students).forEach(s -> System.out.println(s));
		System.out.println("===============================");
		sort(students);
		students.forEach(s -> System.out.println(s));

	}

	private static List<Student> search(List<Student> students) {
		return students.stream().filter(s -> s.getAvg() > 8).collect(Collectors.toList());
	}

	private static List<Student> searchFemaleStudent(List<Student> students) {
		return students.stream().filter(s -> "Nu".equals(s.getGender())).collect(Collectors.toList());
	}

	private static List<Student> searchNonDulicateName(List<Student> students) {

		return students.stream().filter(s -> students.stream().filter(s2 -> s2.getId().equals(s.getId())).count() == 1)
				.collect(Collectors.toList());
	}

	private static void sort(List<Student> students) {

		students.sort(Comparator.comparing(Student::getGender)
				.thenComparing(Comparator.comparing(Student::getAvg, Comparator.reverseOrder())));
	}

}
