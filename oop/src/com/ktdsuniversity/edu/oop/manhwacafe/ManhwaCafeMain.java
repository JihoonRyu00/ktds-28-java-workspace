package com.ktdsuniversity.edu.oop.manhwacafe;

import java.util.Scanner;

public class ManhwaCafeMain {

	public static void main(String[] args) {

		ManhwaCafe manhwaCafe = new ManhwaCafe();
		manhwaCafe.addNewManhwa(0, new Manhwa("B0001", "Civil War", 27_000));
		manhwaCafe.addNewManhwa(1, new Manhwa("B0002", "Secret Wars", 34_000));
		manhwaCafe.addNewManhwa(2, new Manhwa("B0003", "Secret Invasion", 25_000));
		Customer kim = new Customer("0001", 100_000);

		System.out.println();
		manhwaCafe.printManhwaList();
		System.out.println();
		kim.printRentingManhwas();
		System.out.println();

		Scanner sc = new Scanner(System.in);
		int cmd = 0;
		while (true) {
			System.out.println("대여: 1, 반납: 2, 종료: 3 >> ");
			cmd = sc.nextInt();
			if (cmd == 1) {
				System.out.println("대여할 만화의 대여자 인덱스 >> ");
				int customerManhwaIndex = sc.nextInt();
				System.out.println("대여할 만화의 카페 인덱스 >> ");
				int cafeManhwaIndex = sc.nextInt();
				manhwaCafe.rentProcess(kim, customerManhwaIndex, cafeManhwaIndex);
			} else if (cmd == 2) {
				System.out.println("반납할 만화의 대여자 인덱스 >> ");
				int customerManhwaIndex = sc.nextInt();
				System.out.println("반납할 만화의 카페 인덱스 >> ");
				int cafeManhwaIndex = sc.nextInt();
				manhwaCafe.returnProcess(kim, customerManhwaIndex, cafeManhwaIndex);
			} else if (cmd == 3) {
				break;
			}

			System.out.println();
			manhwaCafe.printManhwaList();
			System.out.println();
			kim.printRentingManhwas();
			System.out.println();
		}
		sc.close();
	}
}
