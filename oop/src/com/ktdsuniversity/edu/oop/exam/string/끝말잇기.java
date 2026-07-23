package com.ktdsuniversity.edu.oop.exam.string;

import java.util.Scanner;

public class 끝말잇기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String lastWord = "자전거";
		String currWord = "";
		while (true) {
			System.out.print("다음 단어를 입력하시오. (마지막 단어: " + lastWord + ") >> ");
			currWord = sc.nextLine();
			currWord = currWord.strip();
			System.out.println("입력한 단어: " + currWord);
			if (!currWord.matches("[가-힣]{3,}")
					|| !currWord.startsWith(lastWord.toCharArray()[lastWord.length() - 1] + "")) {
				System.out.println("틀렸습니다.");
				break;
			}
			lastWord = currWord;
		}
		sc.close();
	}
}
