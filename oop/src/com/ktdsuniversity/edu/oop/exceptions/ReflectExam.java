package com.ktdsuniversity.edu.oop.exceptions;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectExam {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException,
			InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		// Reflection: 다이나믹 로딩
		// 클래스, 멤버변수, 생성자, 메소드
		// 동적 로딩 ==> 클래스의 도움 없이 인스턴스를 생성하거나 호출하는 방법
		try {
			Class holderClass = Class.forName("com.ktdsuniversity.edu.oop.exceptions.GoodsHolder");
			Constructor cons = holderClass.getDeclaredConstructor(int.class);
			Object gh = cons.newInstance(4);
			System.out.println(gh);
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		} catch (NoSuchMethodException nsme) {
			nsme.printStackTrace();
		} catch (SecurityException se) {
			se.printStackTrace();
		} catch (InstantiationException ie) {
			ie.printStackTrace();
		} catch (IllegalAccessException iae) {
			iae.printStackTrace();
		} catch (IllegalArgumentException iae) {
			iae.printStackTrace();
		} catch (InvocationTargetException ite) {
			ite.printStackTrace();
		} finally {

		}
	}
}
