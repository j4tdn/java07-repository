package stream;

import java.io.ObjectInputStream.GetField;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;

import javax.sound.midi.Track;

import beans.Trader;
import beans.Transaction;
import functions.StrategyPredicate;

public class Ex05_TraderDemo {
	public static void main(String[] args) {
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");
		List<Trader> traders = Arrays.asList(raoul, mario, alan, brian);
		List<Transaction> transactions = Arrays.asList(new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000), new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710), new Transaction(mario, 2012, 700), 
				new Transaction(alan, 2012, 950));

		//List<Transaction> tran =tran.stream().filter(tran -> tran.getYear() == 2011).sorted(Comparator.comparing(Transaction::value));

		List<String> city = traders.stream().map(tran -> tran.getLiveCity()).distinct().collect(Collectors.toList());
		//List<Trader> trader = traders.stream().filter(t -> "Cambridge".equals(t.getLiveCity())).sorted(Comparator.comparing(t::value)).collec(Collectors.toList());
		//boolean stder = trader.stream().anyMatch(t -> "Milan".equals(t.getLiveCity()));
		transactions.stream().filter(t -> "Cambrdge".equals(t.getTrader())).map(Transaction::getValue);
		Optional<Integer> tranSum = transactions.stream().map(Transaction::getValue).reduce((a, b) -> a > b ? a : b);
		OptionalInt tranSum3 = transactions.stream().mapToInt(Transaction::getValue).max();
	}

}
