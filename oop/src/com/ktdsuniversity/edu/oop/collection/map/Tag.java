package com.ktdsuniversity.edu.oop.collection.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tag {
	public static void printTags(Map<String, Object> tags) {
		for (String key : tags.keySet()) {
			System.out.println("key: " + key + ", value: " + tags.get(key));
		}
	}
	
	public static void printMap(Map<String, Object> map) {
		for (String key : map.keySet()) {	
			System.out.println("key: " + key + ", value: " + map.get(key));
		}
	}

	public static void main(String[] args) {
		Map<String, Object> tags = new HashMap<>();
		tags.put("사이즈", 30);
		tags.put("소재", "면");
		tags.put("가격", 50_000);
		System.out.println(tags);
		System.out.println(tags.get("소재"));
		tags.put("가격", 60_000);
		System.out.println(tags);
		String 소재 = (String) tags.get("소재");
		System.out.println(소재);
		String 브랜드 = (String) tags.get("브랜드");
		System.out.println(브랜드);
		int 가격 = (Integer) tags.get("가격");
		System.out.println(가격);
//		int 할인가 = (Integer) tags.get("할인가"); // NullPointerException null->Integer
//		System.out.println(할인가);

		if (tags.containsKey("할인가")) {
			int 할인가 = (Integer) tags.get("할인가");
			System.out.println(할인가);
		}

		int 할인가 = (Integer) tags.getOrDefault("할인가", 0);
		System.out.println(할인가);

		List<Map<String, Object>> tagsList = new ArrayList<>();
		tagsList.add(tags);
		tagsList.add(tags);
		tagsList.add(tags);
		tagsList.add(tags);
		tagsList.add(tags);
		System.out.println(tagsList.get(0) == tagsList.get(1));
		for (Map<String, Object> t : tagsList) {
			printTags(t);
		}
		
		Map<String, Object> 의류 = new HashMap<>();
//		의류.put(new Map<String, Object> tags)
	}
}
