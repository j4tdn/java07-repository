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

		List<Transaction> request1 = transactions.stream().filter(t -> t.getYear() == 2011)
				.sorted(Comparator.comparing(Transaction::getValue)).collect(Collectors.toList());

		request1.forEach(System.out::println);

		System.out.println("=======================");
		List<String> request2 = traders.stream().map(Trader::getCity).distinct().collect(Collectors.toList());
		request2.forEach(System.out::println);

		System.out.println("=======================");
		List<Trader> request3 = traders.stream().filter(trader -> trader.getCity() == "Cambridge")
				.sorted(Comparator.comparing(Trader::getName)).collect(Collectors.toList());
		request3.forEach(System.out::println);

		System.out.println("=======================");
		List<String> request4 = traders.stream().sorted(Comparator.comparing(Trader::getName)).map(Trader::getName)
				.collect(Collectors.toList());
		request4.forEach(System.out::println);

		System.out.println("=======================");
		boolean request5 = traders.stream().anyMatch(trader -> trader.getCity().equals("Milan"));
		System.out.println(request5);

		System.out.println("=======================");
		List<Integer> request6 = transactions.stream().filter(tran -> tran.getTrader().getCity().equals("Cambridge"))
				.map(Transaction::getValue).collect(Collectors.toList());
		request6.forEach(System.out::println);

		System.out.println("=======================");
		Transaction request7 = transactions.stream().sorted(Comparator.comparing(Transaction::getValue).reversed())
				.findFirst().get();
		System.out.println(request7.getValue());

		System.out.println("=======================");
		Integer request8 = transactions.stream().reduce((tr1, tr2) -> tr1.getValue() < tr2.getValue() ? tr1 : tr2).get()
				.getValue();
		System.out.println(request8);
	}
}
