package sorting;

import java.util.Arrays;
import java.util.Comparator;

import static java.util.Comparator.comparing;

import beans.Students;

public class Ex02 {
	public static void main(String[] args) {
		Students[] students = mock();

//		Comparator<Students> idComparator = (o1, o2) -> o1.getId().compareTo(o2.getId());
//		Comparator<Students> avgPointComparator = (o1, o2) -> Double.compare(o1.getAveragePoint(),
//				o2.getAveragePoint());

		// Comparator<Students> idComparator = Comparator.comparing(student ->
		// student.getId());
		// Comparator<Students> avgPointComparator = Comparator.comparing(student ->
		// student.getAveragePoint());

		// method reference
		Comparator<Students> comparator = comparing(Students::getId).thenComparing(comparing(Students::getAveragePoint));

		Arrays.sort(students, comparator);

		Arrays.stream(students).forEach(student -> System.out.println(student));
	}

	private static Students[] mock() {
		return new Students[] { new Students("Sv01", "Nguyen Van A", 8.8, false),
				new Students("Sv02", "Nguyen Van B", 8.0, true), new Students("Sv01", "Nguyen Van D", 8.1, false),
				new Students("Sv01", "Nguyen Van C", 8.2, true) };
	}
}
