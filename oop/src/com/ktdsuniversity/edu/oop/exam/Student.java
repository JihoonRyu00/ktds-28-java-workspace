package com.ktdsuniversity.edu.oop.exam;

/**
 * 학생 평균 및 학점 구하기 실습
 */
public class Student {
	/**
	 * Java 점수
	 */
	private int java;
	/**
	 * Python 점수
	 */
	private int python;
	/**
	 * C++ 점수
	 */
	private int cpp;
	/**
	 * C# 점수
	 */
	private int csharp;

	/**
	 * 생성자
	 * 
	 * @param java
	 * @param python
	 * @param cpp
	 * @param csharp
	 */
	public Student(int java, int python, int cpp, int csharp) {
		this.java = java;
		this.python = python;
		this.cpp = cpp;
		this.csharp = csharp;
	}

	/**
	 * 모든 과목 점수의 합계 반환
	 * 
	 * @return
	 */
	public int getSumAllScores() {
		return java + python + cpp + csharp;
	}

	/**
	 * 과목 평균 점수 반환
	 * 
	 * @return
	 */
	public double getAverage() {
		return this.getSumAllScores() / 4d;
	}

	/**
	 * (평균점수 – 55) / 10의 결과를 소수점 아래 두 자리 까지만 반환
	 * 
	 * @return
	 */
	public double getCourseCredit() {
		double averageScore = this.getAverage();
		if (averageScore < 55) {
			return 0d;
		}
		return (int) ((averageScore - 55) / 10 * 100) / 100d;
	}

	/**
	 * 학점 반환
	 * 
	 * @return
	 */
	public String getABCDF() {
		double courseCredit = this.getCourseCredit();
		if (courseCredit >= 4.1) {
			return "A+";
		} else if (courseCredit >= 3.6) {
			return "A";
		} else if (courseCredit >= 3.1) {
			return "B+";
		} else if (courseCredit >= 2.6) {
			return "B";
		} else if (courseCredit >= 1.6) {
			return "C";
		} else if (courseCredit >= 0.6) {
			return "D";
		} else {
			return "F";
		}
	}

	public static void main(String[] args) {
		Student student = new Student(100, 90, 80, 70);
		System.out.println("Java\t: " + student.java + "\nPython\t: " + student.python + "\nC++\t: " + student.cpp
				+ "\nC#\t: " + student.csharp);
		System.out.println("Average Score\t: " + student.getAverage());
		System.out.println("Course Credit\t: " + student.getCourseCredit());
		System.out.println("Grade\t: " + student.getABCDF());
	}
}
