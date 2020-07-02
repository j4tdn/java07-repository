package view;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Ex01 {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 5, 5, 3, 1);
		// cac phan tu chi xuat hien mot lan duy nhat trong day
		Set<Integer> nonDuplicated = numbers.stream().filter(n -> numbers.stream().filter(x -> x == n).count() == 1)
				.collect(Collectors.toSet());
		System.out.println("Xuat hien 1 lan");
		nonDuplicated.forEach(s -> System.out.println(s));

		// cac phan tu xuat hien nhieu lan
		List<Integer> numbers2 = Arrays.asList(5, 7, 9, 10, 20, 9, 7, 11);
		Set<Integer> duplicated = numbers2.stream().filter(n -> numbers2.stream().filter(x -> x == n).count() > 1)
				.collect(Collectors.toSet());
		System.out.println("Xuat hien 1 lan");
		duplicated.forEach(s -> System.out.println(s));
	}

}
