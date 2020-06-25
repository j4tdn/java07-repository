package stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import bean.Trader;
import bean.Transaction;

public class Ex05TradeDemo {
	public static void main(String[] args) {
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");
		List<Trader> traders = Arrays.asList(raoul, mario, alan, brian);
		List<Transaction> transactions = Arrays.asList(new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000), new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710), new Transaction(mario, 2012, 700), new Transaction(alan, 2012, 950));
		List<Transaction> transactions2 = transactions.stream().filter(t -> t.getYear() == 2011)
				.sorted(Comparator.comparing(Transaction::getValue)).collect(Collectors.toList());
		transactions2.forEach(System.out::println);
		System.out.println("====================================");
		List<String> strings = traders.stream().map(t -> t.getCity()).distinct().collect(Collectors.toList());
		strings.forEach(System.out::println);
		System.out.println("==========================");
		List<Trader> traders2 = traders.stream().filter(t -> t.getCity().equals("Cambridge"))
				.sorted(Comparator.comparing(Trader::getName)).collect(Collectors.toList());
		traders2.forEach(System.out::println);
		System.out.println("=========================");
		List<String> strings2 = traders.stream().map(t -> t.getName()).sorted().collect(Collectors.toList());
		strings2.forEach(System.out::println);
		System.out.println("===================");
		boolean anymatch = traders.stream().anyMatch(t -> t.getCity().equals("Milan"));
		System.out.println(anymatch);
		System.out.println("=====================");
		List<Integer> transactions3 = transactions.stream().filter(t -> t.getTrade().getCity().equals("Cambridge"))
				.map(t -> t.getValue()).collect(Collectors.toList());
		transactions3.forEach(System.out::println);
		System.out.println("=============================");
		Integer max = transactions.stream().map(t -> t.getValue()).reduce((a, b) -> a > b ? a : b).get();
		System.out.println(max);

		int max2= transactions.stream().mapToInt(t -> t.getValue()).max().getAsInt();

		System.out.println("================");

	}
}
