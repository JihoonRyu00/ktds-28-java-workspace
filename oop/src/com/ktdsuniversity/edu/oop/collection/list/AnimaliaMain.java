package com.ktdsuniversity.edu.oop.collection.list;

import java.util.ArrayList;
import java.util.List;

import com.ktdsuniversity.edu.oop.inheritance.animalia.Animalia;
import com.ktdsuniversity.edu.oop.inheritance.animalia.Bird;

public class AnimaliaMain {
	public static void main(String[] args) {
		List<Animalia> ans = new ArrayList<>();
		ans.add(new Bird(0, 0, 0, 0, null, null, null, 0, null, false, null));
		ans.remove(0);
	}
}
