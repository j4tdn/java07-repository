package Utils;

import java.util.Arrays;

public class SQLUtils {
	private <T extends AutoCloseable> void close(T... closedElements) {
		Arrays.stream(closedElements).forEach(element -> {
			if (element != null) {
				try {
					element.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
