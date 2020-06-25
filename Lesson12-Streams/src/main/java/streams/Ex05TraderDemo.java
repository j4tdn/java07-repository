package streams;

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
		List<Transaction> tra = transactions.stream().filter(a -> a.getYear() == 2012)
				.sorted(Comparator.comparing(Transaction::getValue)).collect(Collectors.toList());
		tra.forEach(System.out::println);

		List<String> trader = traders.stream().map(t -> t.getCity()).distinct().collect(Collectors.toList());
		trader.forEach(System.out::println);
		System.out.println("=========================================");

		List<Trader> trad = traders.stream().filter(t -> t.getCity().equals("Cambridge")).sorted(Comparator.comparing(Trader::getName))
				.collect(Collectors.toList());
		trad.forEach(System.out::println);
		System.out.println("=========================================");
		List<String> trad1=traders.stream().map(t->t.getName()).sorted().collect(Collectors.toList());
		trad1.forEach(System.out::println);
		System.out.println("=========================================");
		boolean trade2 = traders.stream().anyMatch(t->t.getCity().equals("Milan"));
		System.out.println(trade2);
		System.out.println("=========================================");
		
		List<Integer> tran = transactions.stream().filter(t->t.getTrader().getCity().equals("Cambridge")).map(t->t.getValue()).collect(Collectors.toList());
		tran.forEach(System.out::println);
		System.out.println("=========================================");
		List<Integer> tmax= transactions.stream().sorted((s1,s2)->s2.getValue()-s1.getValue()).map(t->t.getValue()).limit(1).collect(Collectors.toList());
		tmax.forEach(System.out::println);
		System.out.println("=========================================");
		List<Integer> tmin= transactions.stream().sorted((s1,s2)->s1.getValue()-s2.getValue()).map(t->t.getValue()).limit(1).collect(Collectors.toList());
		tmin.forEach(System.out::println);
		System.out.println("=========================================");
		Integer max = transactions.stream().map(t->t.getValue()).reduce((a,b)->a>b?a:b).get();
		System.out.println(max);
		System.out.println("=========================================");
		int a =transactions.stream().mapToInt(t->t.getValue()).max().getAsInt();
		System.out.println(a);
	}

}
