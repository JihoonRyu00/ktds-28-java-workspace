package com.ktdsuniversity.edu.oop.exam.string;

import java.util.Scanner;

public class 끝말잇기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int score = 0;
		String lastWord = "자전거";
		String currWord = "";
		while (true) {
			System.out.print("다음 단어를 입력하시오. (마지막 단어: " + lastWord + ") >> ");
			currWord = sc.nextLine();
//			currWord = currWord.strip();
			currWord = currWord.replaceAll("[ \t]+","");
			System.out.println("입력한 단어: " + currWord);

			// case 1
//			if (!currWord.matches("[가-힣]{3,}")
//					|| !currWord.startsWith(lastWord.toCharArray()[lastWord.length() - 1] + "")) {

			// case 2
//			if (!currWord.matches("[가-힣]{3,}") || !currWord.startsWith(lastWord.charAt(lastWord.length() - 1) + "")) {

			// case3
			if (!currWord.matches("[가-힣]{3,}") || !currWord.startsWith(lastWord.substring(lastWord.length() - 1))) {
				System.out.print("\n틀렸습니다. ");
				break;
			}
			score++;
			lastWord = currWord;
			System.out.println();
		}
		sc.close();
		System.out.println("최종 점수: " + score);
	}
}
