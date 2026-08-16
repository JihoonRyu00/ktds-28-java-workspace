package com.ktdsuniversity.edu.hw.second;

import java.time.LocalTime;
import java.util.List;

import com.ktdsuniversity.edu.hw.first.Program;

public class BroadcastingSystem {

	private String name;
	private List<Program> programList;

	public BroadcastingSystem(String name, List<Program> programList) {
		this.name = name;
		this.programList = programList;
	}

	public String nowAirProgram(LocalTime now) {
		for (Program p : programList) {
			if (p.isAirTime(now)) {
				return "\"" + p.getName() + "\"이(가) 방영중입니다.";
			}
		}
		return "방영중인 시간이 아닙니다.";
	}

	public String getName() {
		return this.name;
	}

	public List<Program> getProgramList() {
		return this.programList;
	}

	@Override
	public String toString() {
		return this.name + " 편성표" + //
				this.programList.stream() // Stream<Program>
						.map(Program::toString) // String
						.reduce("", (accumulated, curr) -> accumulated + "\n" + curr) // String
		;
	}
}
