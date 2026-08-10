package com.ktdsuniversity.edu.fp.objects.utils;

import java.util.Arrays;
import java.util.function.Function;

public abstract class ArrayUtil {

	private ArrayUtil() {}

	public static <T> T getValue(String[] array, int index, Function<String, T> function) {
		if (index >= 0 && array.length > index) {
			String value = array[index];
			if (value != null) {
				value = value.replace("\"", "");
			}
			return function.apply(value);
		}
		return null;
	}
	
	public static String getValue(String[] array, int index) {
		return getValue(array, index, (str) -> str);
	}
	
	public static int getInt(String[] array, int index) {
		String value = getValue(array, index);
		if (value == null) {
			return 0;
		}
		return StringUtil.toInt(value);
	}
}
