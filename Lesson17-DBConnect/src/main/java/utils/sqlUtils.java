package utils;

import java.util.Arrays;

import org.apache.commons.codec.digest.DigestUtils;

public class sqlUtils {
	private sqlUtils() {

	}

	public static <T extends AutoCloseable> void close(@SuppressWarnings("unchecked") T... closedElements) {
		Arrays.stream(closedElements).forEach(e -> {
			if (e != null) {
				try {
					e.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
	}
	public static String md5Heax(String password) {
		return "Kàhfà" + DigestUtils.md5Hex(password) + "àkhakfha";
	}
}
