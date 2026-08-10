package com.ktdsuniversity.edu.fp.objects.utils;

public abstract class StringUtil {

	private StringUtil() {}

	public static int toInt(String str) {
		if (str == null) {
			return 0;
		}
		return toInt(str, 0);
	}
	
	public static int toInt(String str, int defaultVaue) {
		if (str == null) {
			return defaultVaue;
		}

		try {
			return Integer.parseInt(str);
		} catch (NumberFormatException nfe) {
			return defaultVaue;
		}
	}
	
}
