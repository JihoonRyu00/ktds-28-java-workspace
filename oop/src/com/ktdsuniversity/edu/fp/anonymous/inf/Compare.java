package com.ktdsuniversity.edu.fp.anonymous.inf;

import com.ktdsuniversity.edu.fp.objects.Dish;

public interface Compare<T> {

	boolean compareType(Dish dish, T type);
}
