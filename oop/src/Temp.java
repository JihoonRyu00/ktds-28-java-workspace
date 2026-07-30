import java.util.*;

public class Temp {
	public String solution(String[] participant, String[] completion) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String s : completion) {
			if (!map.containsKey(s)) {
				map.put(s, 1);
			} else {
				map.replace(s, map.get(s) + 1);
			}
		}
		for (String s : participant) {
			if (map.get(s) == 1) {
				return s;
			}
			map.replace(s, map.get(s) - 1);
		}
		return null;
	}

	public static void main(String[] args) {
		System.out.println();
	}
}
