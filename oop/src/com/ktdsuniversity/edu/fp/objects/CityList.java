package com.ktdsuniversity.edu.fp.objects;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CityList {

	public static Stream<City> loadCityStream(String directory, String filename) {
		try {
			return Files.lines(new File(directory, filename).toPath()) // Stream<String>
						.skip(1) // Stream<String>
						.parallel() // 병렬로 처리 시작.
						.map(City::new); // Stream<City>
		} catch (IOException e) {
			e.printStackTrace();
			return Stream.empty();
		}
	}
	
	public static List<City> loadCityData(String directory, String filename) {
		return CityList.loadCityStream(directory, filename)
					   .collect(Collectors.toList());
	}
	
}
