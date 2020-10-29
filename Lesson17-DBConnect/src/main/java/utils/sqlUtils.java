package utils;

import java.util.Arrays;

import org.apache.commons.codec.digest.DigestUtils;
import org.omg.CORBA.PUBLIC_MEMBER;

public class sqlUtils {
	public sqlUtils() {
		// TODO Auto-generated constructor stub
	}

	public static  <T extends AutoCloseable> void close(T... closedElements) {
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
		return "adsdad"+DigestUtils.md2Hex(password)+"hgdasjgd";
	}
}
