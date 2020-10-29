package utils;

import java.util.Arrays;

import org.apache.commons.codec.digest.DigestUtils;

public class SqlUtils {
	private SqlUtils() {

	}

	public static <T extends AutoCloseable> void close(T... closedElement) {
		Arrays.stream(closedElement).forEach(element -> {
			if (element != null) {
				try {
					element.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static String md5Hex(String password) {
		return "dfg$sd" + DigestUtils.md5Hex(password) + "aksj%dvh";
	}
}
