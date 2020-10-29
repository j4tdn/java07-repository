package utils;

import java.util.Arrays;

import org.apache.commons.codec.digest.DigestUtils;

public class SqlUtils {
	private SqlUtils() {
		
	}
	
	public static <T extends AutoCloseable> void close(T ... closeElement) {
		Arrays.stream(closeElement).forEach(element -> {
			if (element != null) {
				try {
					element.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
	
	public static String md5Hex(String password) {
		return "(^-^)" + DigestUtils.md5Hex(password) + "(T-T)";
	}
}
