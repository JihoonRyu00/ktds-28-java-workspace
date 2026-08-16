package com.ktdsuniversity.edu.hw.second;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.ktdsuniversity.edu.hw.first.Program;

public class Main {

	public static List<Program> makeRandSche(int start, int end) {
		List<Program> programList = new ArrayList<>();
		int currStart = start;
		int currEnd = 0;
		int num = 1;
		while (currStart < end) {
			currEnd = currStart + ((int) (Math.random() * 10) + 1) * 30; // 방송은 최소 30분 최대 5시간
			if (currEnd > end) {
				currEnd = end;
			}
			programList.add(new Program("프로그램 %d".formatted(num++), currStart, currEnd - 1));
			currStart = currEnd;
		}
		return programList;
	}

	public static void main(String[] args) {
		List<BroadcastingSystem> channels = new ArrayList<>();
		channels.add(new BroadcastingSystem("SBS", makeRandSche(3 * 60, 24 * 60)));
		channels.add(new BroadcastingSystem("KBS 1", makeRandSche(1 * 60, 24 * 60)));
		channels.add(new BroadcastingSystem("KBS 2", makeRandSche(5 * 60, 22 * 60)));
		channels.add(new BroadcastingSystem("MBC", makeRandSche(3 * 60, 22 * 60)));
		channels.add(new BroadcastingSystem("TVN", makeRandSche(4 * 60, 24 * 60)));
//		System.out.println(channels);

		LocalTime now = LocalTime.now();
		System.out.println("현재 시간 " + now.format(DateTimeFormatter.ofPattern("HH:mm")));
		for (BroadcastingSystem bs : channels) {
			System.out.println(bs.getName() + " " + bs.nowAirProgram(now));
		}
	}
}
