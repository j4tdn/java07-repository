package stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
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

		List<Transaction> result = transactions.stream().filter(a -> a.getYear() == 2011)
				.sorted(Comparator.comparing(Transaction::getValue)).collect(Collectors.toList());
		
		result.forEach(System.out::println);
		
		
		List<Trader> trader = traders.stream().filter(a -> "Cambridge".equals(a.getCity()))
				.sorted(Comparator.comparing(Trader::getName)).collect(Collectors.toList());
		
		
		List<String> tradersName = traders.stream().sorted(Comparator.comparing(Trader::getName)).map(Trader::getName).collect(Collectors.toList());
		
		List<String> tradersNameV2 = traders.stream().map(Trader::getName).sorted().collect(Collectors.toList());
		
		boolean isTraderBasedinMilan = traders.stream().anyMatch(t -> "Milan".equals(t.getCity()));
		
		transactions.stream().filter(t ->"Cambridge".equals(t.getTrader().getCity())).map(Transaction::getValue).collect(Collectors.toList());
		
		
		Optional<Integer> highestOptional = transactions.stream().map(Transaction::getValue).reduce(Integer::max);
		transactions.stream().mapToInt(Transaction::getValue).max();
		Integer highestValue = highestOptional.get();
		
		Optional<Integer> smallestOptional = transactions.stream().map(Transaction::getValue).reduce(Integer::min);
		transactions.stream().mapToInt(Transaction::getValue).min();
		
		Integer smallestValue = smallestOptional.get();
		
		transactions.stream().map(Transaction::getValue).reduce((a, b) -> a > b ? a : b);

}
}