package com.ktdsuniversity.edu.hw.lottery;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

	public static int[] createDistinctRandomSixNumbers() {
		int[] lottoNumbers = new int[6];
		Map<Integer, Boolean> visit = new HashMap<>();
		int num = 0;
		for (int i = 0; i < 6; ++i) {
			num = (int) (Math.random() * 45) + 1;
			while (visit.get(num) != null) {
				num = (int) (Math.random() * 45) + 1;
			}
			lottoNumbers[i] = num;
			visit.put(num, null);
		}
		return lottoNumbers;
	}

	public static void main(String[] args) {
		List<int[]> lottoNumbersList=new ArrayList<>();
		for (int i=0;i<10;++i) {
			lottoNumbersList.add(createDistinctRandomSixNumbers());
		}
		for (int i=0;i<lottoNumbersList.size();++i) {
			System.out.print((i+1)+"회차 ==> ");
			for (int n:lottoNumbersList.get(i)) {
				System.out.print(n+" ");
			}
			System.out.println();
		}
	}
}
