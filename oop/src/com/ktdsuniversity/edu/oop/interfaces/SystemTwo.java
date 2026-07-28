package com.ktdsuniversity.edu.oop.interfaces;

public class SystemTwo extends SystemOne implements VipMemberService {

	@Override
	public void addPoint(int point) {
		System.out.println("포인트 추가");
	}

}
