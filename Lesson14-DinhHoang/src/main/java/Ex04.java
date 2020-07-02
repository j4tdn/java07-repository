import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import beans.Student;

public class Ex04 {

	public static void main(String[] args) throws Exception {
		File file = new File("student.txt");
		if (!file.exists()) {
			file.createNewFile();
		}
		List<Student> students = new ArrayList<>();
		readFile(file, students);
		System.out.println("Danh sách sinh viên:");
		students.forEach(System.out::println);
		System.out.println("=================");
		System.out.println("SV có điểm TB > 8:");
		score(students);
		System.out.println("=================");
		System.out.println("SV là nữ:");
		isFemale(students);
		System.out.println("=================");
		System.out.println("Sắp xếp DSSV:");
		sorted(students);
	}

	private static void readFile(File file, List<Student> students) throws Exception {
		FileReader fr = null;
		BufferedReader br = null;

		String result = "";
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);

			String dataRow = "";
			while ((dataRow = br.readLine()) != null) {
				result = dataRow;
				String[] s = result.split(", ");
				Student student = new Student(s[0], s[1], Float.parseFloat(s[2]), s[3]);
				students.add(student);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
				if (fr != null)
					fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static void score(List<Student> students) {
		List<Student> result = students.stream().filter(s -> s.getScore() > 8.0f).collect(Collectors.toList());
		result.forEach(System.out::println);
	}

	private static void isFemale(List<Student> students) {
		List<Student> result = students.stream().filter(s -> "Nu".equals(s.isSex())).collect(Collectors.toList());
		result.forEach(System.out::println);
	}

	private static void sorted(List<Student> students) {
		students.sort(Comparator.comparing(Student::isSex)
				.thenComparing((s1, s2) -> String.valueOf(s2.getScore()).compareTo(String.valueOf(s1.getScore()))));
		students.forEach(System.out::println);
	}
}
