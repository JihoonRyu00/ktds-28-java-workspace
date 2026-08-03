package com.ktdsuniversity.edu.oop.dashboard;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Dashboard dashboard = new Dashboard(sc);
		int cmd = 0;
		while (true) {
			System.out.print(
					"1: 게시글 작성하기\t\t2: 모든 게시글 출력하기\t\t\t3: 게시글 정보 출력하기\n4: 게시글 수정하기\t\t5: 게시글 삭제하기\t\t\t6: 게시글의 개수 출력하기\n7: 게시글에 댓글 작성하기\t8: 게시글에 등록된 댓글 삭제하기\t9: 게시글에 등록된 댓글 추천하기\n10: 게시글 제목으로 검색하기\t11: 게시글 목록 전체 삭제하기\t\t12: 게시글의 모든 댓글 삭제하기\n다음 행동을 선택하세요. (0: 종료) >> ");
			try {
				cmd = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException nfe) {
				nfe.printStackTrace();
			}
			if (cmd == 0) {
				System.out.println("대시보드 서비스를 종료합니다.");
				break;
			} else if (cmd == 1) {
				dashboard.writeArticle();
			} else if (cmd == 2) {
				dashboard.printAllArticles();
			} else if (cmd == 3) {
				System.out.print("게시글 번호를 입력하세요. >> ");
				int articleNumber = Integer.parseInt(sc.nextLine());
				System.out.println();
				dashboard.printArticle(articleNumber);
			} else if (cmd == 4) {
				System.out.print("게시글 번호를 입력하세요. >> ");
				dashboard.updateArticle(Integer.parseInt(sc.nextLine()));
			} else if (cmd == 5) {
				System.out.print("게시글 번호를 입력하세요. >> ");
				dashboard.deleteArticle(Integer.parseInt(sc.nextLine()));
			} else if (cmd == 6) {
				dashboard.printArticleCount();
			} else if (cmd == 7) {
				System.out.print("게시글 번호를 입력하세요. >> ");
				dashboard.addReplyOnArticle(Integer.parseInt(sc.nextLine()));
			} else if (cmd == 8) {
				System.out.print("게시글 번호를 입력하세요. >> ");
				int articleNumber = Integer.parseInt(sc.nextLine());
				System.out.print("댓글 번호를 입력하세요. >> ");
				int replyNumber = Integer.parseInt(sc.nextLine());
				dashboard.deleteReplyOnArticle(articleNumber, replyNumber);
			} else if (cmd == 9) {
				System.out.print("게시글 번호를 입력하세요. >> ");
				int articleNumber = Integer.parseInt(sc.nextLine());
				System.out.print("댓글 번호를 입력하세요. >> ");
				int replyNumber = Integer.parseInt(sc.nextLine());
				dashboard.likeReplyOnArticle(articleNumber, replyNumber);
			} else if (cmd == 10) {
				System.out.print("검색어를 입력하세요. >> ");
				dashboard.searchArticleByName(sc.nextLine());
			} else if (cmd == 11) {
				dashboard.deleteAllArticles();
			} else if (cmd == 12) {
				System.out.print("게시글 번호를 입력하세요. >> ");
				dashboard.deleteAllRepliesOnArticle(Integer.parseInt(sc.nextLine()));
			} else {
				System.out.println("올바른 번호를 입력하세요.");
			}
			System.out.println();
		}
		sc.close();
	}
}
