package stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import beans.Trader;
import beans.Transaction;

public class Ex05TraderDemo {
	public static void main(String[] args) {
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");
		java.util.List<Trader> traders = Arrays.asList(raoul, mario, alan, brian);
		List<Transaction> transactions = Arrays.asList(new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000), new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710), new Transaction(mario, 2012, 700), new Transaction(alan, 2012, 950));
		List<Transaction> list1 = question1(transactions);
		List<String> list2 = uniqueCities(traders);
		List<Trader> list3 = question3(traders);
		List<String> list4 = question4(traders);
		List<Integer> list6 = question6(transactions);

		show(list1);
		System.out.println("============");
		show(list2);
		System.out.println("============");
		show(list3);
		System.out.println("============");
		show(list4);
		System.out.println("============");
		System.out.println(question5(traders));
		System.out.println("============");
		show(list6);
		System.out.println("============");
		System.out.println(question7(transactions));
		System.out.println("============");
		System.out.println(question8(transactions));
	}

	private static <T> void show(List<T> list) {
		list.forEach(System.out::println);
	}

	private static List<Transaction> question1(List<Transaction> list) {
		return list.stream().filter(t -> t.getYear() == 2011).sorted(Comparator.comparing(Transaction::getValue))
				.collect(Collectors.toList());
	}

	private static List<String> uniqueCities(List<Trader> list) {
		return list.stream().map(t -> t.getCity()).distinct().collect(Collectors.toList());
	}

	private static List<Trader> question3(List<Trader> list) {
		return list.stream().filter(t -> "Cambridge".equals(t.getCity())).sorted(Comparator.comparing(Trader::getName))
				.collect(Collectors.toList());
	}

	private static List<String> question4(List<Trader> list) {
		return list.stream().sorted(Comparator.comparing(Trader::getName)).map(Trader::getName)
				.collect(Collectors.toList());
	}

	private static boolean question5(List<Trader> list) {
		return list.stream().anyMatch(t -> "Milan".equals(t.getCity()));
	}

	private static List<Integer> question6(List<Transaction> list) {
		return list.stream().filter(t -> "Cambridge".equals(t.getTrader().getCity())).map(Transaction::getValue)
				.collect(Collectors.toList());
	}

	private static int question7(List<Transaction> list) {
		return list.stream().reduce((a, b) -> a.getValue() > b.getValue() ? a : b).get().getValue();
	}

	private static int question8(List<Transaction> list) {
		return list.stream().reduce((a, b) -> a.getValue() < b.getValue() ? a : b).get().getValue();
	}
}
