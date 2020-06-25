package stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collector;
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
		List<Transaction> transactions = Arrays.asList(
				new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000), 
				new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710), 
				new Transaction(mario, 2012, 700), 
				new Transaction(alan, 2012, 950));
		List<Transaction> year2011 = transactions.stream().filter(tran -> tran.getYear() == 2011)
				.sorted(Comparator.comparing(Transaction::getValue)).collect(Collectors.toList());
		year2011.stream().forEach(System.out::println);

		List<String> cities = traders.stream().map(Trader::getCity).distinct().collect(Collectors.toList());
		cities.stream().forEach(System.out::println);

		List<Trader> fromCambridge = traders.stream().filter(trader -> "Cambridge".equals(trader.getCity()))
				.sorted(Comparator.comparing(Trader::getName)).collect(Collectors.toList());
		fromCambridge.stream().forEach(System.out::println);

		String names = traders.stream().map(Trader::getName).sorted().collect(Collectors.joining(", "));
		System.out.println(names);

		boolean result = traders.stream().anyMatch(trader -> "Milan".equals(trader.getCity()));
		System.out.println(result);

		List<Integer> values = transactions.stream().filter(tran -> "Cambridge".equals(tran.getTrader().getCity()))
				.map(Transaction::getValue).collect(Collectors.toList());
		values.stream().forEach(System.out::println);

		Optional<Integer> optional = transactions.stream().map(Transaction::getValue).reduce(Integer::max); // reduce((a,b) -> a > b ? a : b)
		OptionalInt highest = transactions.stream().mapToInt(Transaction::getValue).max();
		System.out.println("highest: " + optional.get() + "cach khac: " + highest.getAsInt());
	}
}
