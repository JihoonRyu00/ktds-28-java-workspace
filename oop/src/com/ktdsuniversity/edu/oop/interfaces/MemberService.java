package com.ktdsuniversity.edu.oop.interfaces;

/**
 * 어떤 시스템의 회원 관리 기능
 */
public interface MemberService {

	/** 회원 가입 */
	public void join();

	/** 회원 탈퇴 */
	public void deleteMe();

	/** 회원 로그인 */
	public void login();

	/** 회원 로그아웃 */
	public void logout();

}
