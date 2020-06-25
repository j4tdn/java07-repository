package stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.swing.text.StyledEditorKit.BoldAction;

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

		List<Transaction> trans = transactions.stream().filter(a -> a.getYear() == 2011)
				.sorted(Comparator.comparing(Transaction::getValue)).collect(Collectors.toList());
		trans.forEach(System.out::println);

		System.out.println("==================");
		Set<String> trader = traders.stream().map(a -> a.getCity()).collect(Collectors.toSet());
		trader.forEach(System.out::println);

		System.out.println("==================");
		List<Trader> q3 = traders.stream().filter(a -> "Cambridge".equals(a.getCity()))
				.sorted(Comparator.comparing(Trader::getName)).collect(Collectors.toList());
		q3.forEach(System.out::println);

		System.out.println("==================");

		List<String> name = traders.stream().map(a -> a.getName()).sorted().collect(Collectors.toList());
		name.forEach(System.out::println);

		System.out.println("==================");
		Boolean q5 = traders.stream().anyMatch(a -> "Milan".equals(a.getCity()));
		System.out.println(q5);

		System.out.println("==================");
		List<Integer> q6 = transactions.stream().filter(t -> "Cambridge".equals(t.getTrader().getCity()))
				.map(Transaction::getValue).collect(Collectors.toList());
		q6.forEach(System.out::println);
		
		System.out.println("==================");
		Optional<Integer> optional=transactions.stream().map(Transaction::getValue).reduce(Integer::max);
	//	Optional<Integer> optional=transactions.stream().map(Transaction::getValue).reduce((a, b) -> a > b ? a : b);
	//IntStream tra ve Int nen ho tro ham max
		transactions.stream().mapToInt(Transaction::getValue).min();
		System.out.println(optional.get());
		System.out.println("==================");
		System.out.println(transactions.stream().mapToInt(Transaction::getValue).min());
		
	}
}
