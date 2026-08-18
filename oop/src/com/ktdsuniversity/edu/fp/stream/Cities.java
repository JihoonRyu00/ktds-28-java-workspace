package com.ktdsuniversity.edu.fp.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.ktdsuniversity.edu.fp.objects.City;
import com.ktdsuniversity.edu.fp.objects.CityList;

public class Cities {

	// 1. 모든 도시 이름만 출력
	public static void printAllCityNames(String path, String fileName) {
		Stream<City> cityList = CityList.loadCityStream(path, fileName);
		cityList.map(City::getName) // Stream<String>
				.forEach(System.out::println); // void
		;
	}

	// 2. countryName이 "South Korea"인 데이터의 Native를 중복 없이 출력
	public static void printDistinctNativesOfSouthKorea(String path, String fileName) {
		Stream<City> cityList = CityList.loadCityStream(path, fileName);
		cityList.filter(city -> city.getCountryName().equals("South Korea")) // Stream<City>
				.map(City::getNativeStr) // Stream<String>
				.distinct() // Stream<String>
				.forEach(System.out::println); // void
		;
	}

	// 3. 모든 도시의 population을 출력
	public static void printPopulations(String path, String fileName) {
		Stream<City> cityList = CityList.loadCityStream(path, fileName);
		cityList.map(City::getPopulation) // Stream<Integer>
				.forEach(System.out::println); // void
		;
	}

	// 4. 모든 도시의 population을 출력 (0 이상만)
	public static void printPopulationsGTZero(String path, String fileName) {
		Stream<City> cityList = CityList.loadCityStream(path, fileName);
		cityList.map(City::getPopulation) // Stream<Integer>
				.filter(population -> population > 0) // Stream<Integer>
				.forEach(System.out::println); // void
		;
	}

	// 5. countryName이 "A"로 시작하는 국가의 도시들의 TimeZone을 중복없이 출력해본다.
	public static void printTimeZoneWhichCountryNameStartsWith(String path, String fileName, String s) {
		Stream<City> cityList = CityList.loadCityStream(path, fileName);
		cityList.filter(city -> city.getCountryName().startsWith(s)) // Stream<City>
				.map(City::getTimezone) // Stream<String>
				.distinct() // Stream<String>
				.forEach(System.out::println) // void
		;
	}

	// 6. countryId가 10 이상인 국가들의 도시명을 출력해본다.
	public static void printCountryNamesWhichCountryIdGETen(String path, String fileName) {
		Stream<City> cityList = CityList.loadCityStream(path, fileName);
		cityList.filter(city -> city.getCountryId() >= 10) // Stream<City>
				.map(City::getName) // Stream<String>
				.forEach(System.out::println);
		;
	}

	// 7. countryName이 "South Korea"인 도시의 population 총 합을 출력해본다.
	public static void printSumOfPopulationsWhichCountryNameIs(String path, String fileName, String countryName) {
		Stream<City> cityList = CityList.loadCityStream(path, fileName);
		System.out.println( //
				cityList.filter(city -> city.getCountryName().equals(countryName)) // Stream<City>
//						.map(City::getPopulation) // Stream<Integer>
//						.reduce(0, (sum, curr) -> sum + curr) // Integer
						.collect(Collectors.summingInt(City::getPopulation)) // Integer
		);
	}

	// 8. population 기준으로 내림차순 정렬해 10개 도시의 이름과 population을 출력해본다.
	public static void printTopTenCityNamesAndPopulationsDescendingPopulation(String path, String fileName) {
		Stream<City> cityList = CityList.loadCityStream(path, fileName);
		cityList.sequential() // Stream<City>
				.sorted((a, b) -> b.getPopulation() - a.getPopulation()) // Stream<City>
				.limit(10) // Stream<City>
				.forEach(city -> System.out.println("도시 이름: " + city.getName() + " 인구: " + city.getPopulation())) // void
		;
	}

	// 9. type이 "special self-governing province" 인 도시의 이름과 countryName을 출력해본다.
	public static void printCityNamesAndCountryNamesWhichTypeIs(String path, String fileName, String type) {
		Stream<City> cityList = CityList.loadCityStream(path, fileName);
		cityList.filter(city -> city.getType().equals(type)) // Stream<City>
				.forEach(city -> System.out.println("도시 이름: " + city.getName() + " 나라 이름: " + city.getCountryName()) // void
				);
	}

	// 10. 모든 도시들을 id 별로 오름차순 정렬해 출력해본다.
	public static void printCitiesAscending(String path, String fileName) {
		Stream<City> cityList = CityList.loadCityStream(path, fileName);
		cityList.sequential() // Stream<City>
				.sorted((a, b) -> a.getId() - b.getId()) // Stream<City>
				.forEach(System.out::println) // void
		;
	}

	// 11. iso2 값이 숫자 형태인 것만 출력해본다.
	public static void printCitiesWhichIso2IsNumeric(String path, String fileName) {
		Stream<City> cityList = CityList.loadCityStream(path, fileName);
		cityList.filter(city -> city.getIso2().matches("[0-9]+")) // Stream<City>
				.forEach(System.out::println) // void
		;
	}

	// 12. iso2 값이 숫자형태가 아닌 도시의 국가명(countryName)을 오름차순 정렬해 출력해본다.
	public static void printAscendingCountryNameWhichIso2IsNotNumeric(String path, String fileName) {
		Stream<City> cityList = CityList.loadCityStream(path, fileName);
		cityList.filter(city -> !city.getIso2().matches("[0-9]+")) // Stream<City>
				.map(city -> city.getCountryName()) // Stream<String>
				.distinct() // Stream<String>
				.sequential() // Stream<String>
				.filter(str -> !str.isBlank()) // Stream<String>
				.sorted((a, b) -> a.compareTo(b))
//				.sorted((a, b) -> {
//					int maxI = Math.max(a.length(), b.length());
//					System.out.println("m:%d alen:%d blen:%d".formatted(maxI, a.length(), b.length()));
//					int i = 0;
//					while ((int) a.charAt(i) == (int) b.charAt(i)) {
//						System.out.println("a%d:%s b%d:%s".formatted(i, a.charAt(i), i, b.charAt(i)));
//						if (i == maxI - 1) {
//							if (a.length() == b.length()) {
//								return 0;
//							}
//							return (a.length() > b.length()) ? 1 : -1;
//						}
//						i++;
//					}
//					return ((int) a.charAt(i) > (int) b.charAt(i)) ? 1 : -1;
//				}) // Stream<String>
				.forEach(System.out::println) // void
		;
	}

	// 13. 국가명(countryName) 별 도시의 목록을 그룹핑하여 출력해본다.
	public static void printGroupsByCountryName(String path, String fileName) {
		Stream<City> cityList = CityList.loadCityStream(path, fileName);
		Map<String, List<City>> cityMap = cityList.collect(Collectors.groupingBy(City::getCountryName)) // Map<String,List<City>>
		;
		for (String key : cityMap.keySet()) {
			System.out.println(key + ": " + cityMap.get(key));
		}
	}

	// 14. latitude와 longitude가 없는 도시들의 이름만 출력해본다.
	public static void printCityNamesWhichHasNoLatitudeAndLongitude(String path, String fileName) {
		Stream<City> cityList = CityList.loadCityStream(path, fileName);
		cityList.filter(city -> city.getLatitude() == null && city.getLongitude() == null) // Stream<City>
				.map(City::getName) // Strean<String>
				.forEach(System.out::println) // void
		;
	}

	// 15. 국가명(countryName)이 Canada인 도시 중 3개는 건너띄고 2개만 출력해본다.
	public static void prinTwoCitiesAfterThreeWhichCountryNameIsCanada(String path, String fileName) {
		Stream<City> cityList = CityList.loadCityStream(path, fileName);
		cityList.sequential() // Stream<City>
				.filter(city -> city.getCountryName().equals("Canada")) // Stream<City>
				.skip(3) // Stream<City>
				.limit(2) // Stream<City>
				.forEach(System.out::println) // void
		;
	}

	// 16. level과 parentId가 0보다 큰 도시만 출력해본다.
	public static void printCitiesWhichLevelAndParentIdGTZero(String path, String fileName) {
		Stream<City> cityList = CityList.loadCityStream(path, fileName);
		cityList.filter(city -> city.getLevel() > 0 && city.getParentId() > 0) // Stream<City>
				.forEach(System.out::println) // void
		;
	}

	public static void main(String[] args) {

		String path = "C:\\dev_programs\\java-stream-countries-states-cities-database-master\\csv";
		String fileName = "states.csv";
//		Stream<City> cityList = CityList.loadCityStream(path, fileName);
//		cityList.forEach(System.out::println);
//		printAllCityNames(path, fileName);
//		printDistinctNativesOfSouthKorea(path, fileName);
//		printPopulations(path, fileName);
//		printPopulationsGTZero(path, fileName);
//		printTimeZoneWhichCountryNameStartsWith(path, fileName, "S");
//		printCountryNamesWhichCountryIdGETen(path, fileName);
//		printSumOfPopulationsWhichCountryNameIs(path, fileName, "South Korea");
//		printTopTenCityNamesAndPopulationsDescendingPopulation(path, fileName);
//		printCityNamesAndCountryNamesWhichTypeIs(path, fileName, "special self-governing province");
//		printCitiesAscending(path, fileName);
//		printCitiesWhichIso2IsNumeric(path, fileName);
//		printAscendingCountryNameWhichIso2IsNotNumeric(path, fileName);
//		printGroupsByCountryName(path, fileName);
//		printCityNamesWhichHasNoLatitudeAndLongitude(path, fileName);
//		prinTwoCitiesAfterThreeWhichCountryNameIsCanada(path, fileName);
		printCitiesWhichLevelAndParentIdGTZero(path, fileName);
	}
}
