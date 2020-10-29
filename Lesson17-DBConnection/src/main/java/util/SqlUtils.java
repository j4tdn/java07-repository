package util;

import java.util.Arrays;

import org.apache.commons.codec.digest.DigestUtils;

public class SqlUtils {
	private SqlUtils() {

	}

	public static <T extends AutoCloseable> void close(T... closedElements) {
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

	public static String md5Hex(String password) {
		return "as#@!a" + DigestUtils.md5Hex(password) + "qwe!@#";

	}
}
