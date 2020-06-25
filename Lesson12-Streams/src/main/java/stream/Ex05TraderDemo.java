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
		List<Trader> traders = Arrays.asList(raoul, mario, alan, brian);
		List<Transaction> transactions = Arrays.asList(new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000), new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710), new Transaction(mario, 2012, 700), new Transaction(alan, 2012, 950));

		List<Transaction> year = transactions.stream().filter(transaction -> transaction.getYear() == 2011)
				.sorted(Comparator.comparing(Transaction::getValue)).collect(Collectors.toList());
		year.forEach(System.out::println);
		System.out.println("====================");

		List<String> city = traders.stream().map(Trader::getCity).distinct().collect(Collectors.toList());
		city.forEach(System.out::println);
		System.out.println("====================");

		List<Trader> name = transactions.stream().map(Transaction::getTrader)
				.sorted(Comparator.comparing(Trader::getName)).distinct().collect(Collectors.toList());
		name.forEach(System.out::println);
		System.out.println("====================");

		List<String> sortTraders = traders.stream().map(Trader::getName).sorted().collect(Collectors.toList());
		sortTraders.forEach(System.out::println);
		System.out.println("====================");

		boolean milan = traders.stream().anyMatch(t -> "Milan".equals(t.getCity()));
		System.out.println("- " + milan);
		System.out.println("====================");

		List<Integer> value = transactions.stream().filter(t -> "Cambridge".equals(t.getTrader().getCity()))
				.map(t -> t.getValue()).collect(Collectors.toList());
		value.forEach(System.out::println);
		System.out.println("====================");

		int maxValue = transactions.stream().map(Transaction::getValue).reduce(Integer::max).get();
		System.out.println("- " + maxValue);
		System.out.println("====================");

		int minValue = transactions.stream().map(Transaction::getValue).reduce(Integer::min).get();
		System.out.println("- " + minValue);
		System.out.println("====================");

		int minValueC2 = transactions.stream().mapToInt(Transaction::getValue).min().getAsInt();
		System.out.println("- " + minValueC2);
		System.out.println("====================");
	}
}