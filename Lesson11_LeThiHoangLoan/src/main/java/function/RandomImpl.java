package function;

import java.util.List;
import java.util.Random;

public class RandomImpl implements RandomFunction<List<String>, String> {
	Random rd = new Random();

	@Override
	public String random(List<String> t) {
		int rand = rd.nextInt();
		return t.get(rand);
	}
}
