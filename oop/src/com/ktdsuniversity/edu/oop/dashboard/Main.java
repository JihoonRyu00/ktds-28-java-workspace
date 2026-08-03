package com.ktdsuniversity.edu.oop.dashboard;

import java.util.Scanner;

public class Main {

	public static enum Cmd {
		QUIT("종료하기", 0), WRITE_ARTICLE("게시글 작성하기", 1), PRINT_ALL_ARTICLES("모든 게시글 출력하기", 2),
		PRINT_ARTICLE("게시글 정보 출력하기", 3), UPDATE_ARTICLE("게시글 수정하기", 4), DELETE_ARTICLE("게시글 삭제하기", 5),
		PRINT_ARTICLE_COUNT("게시글의 개수 출력하기", 6), ADD_REPLY("게시글에 댓글 작성하기", 7), DELETE_REPLY("게시글에 등록된 댓글 삭제하기", 8),
		LIKE_REPLY("게시글에 등록된 댓글 추천하기", 9), SEARCH_ARTICLE("게시글 제목으로 검색하기", 10),
		DELETE_ALL_ARTICLES("게시글 목록 전체 삭제하기", 11), DELETE_ALL_REPLIES("게시글의 모든 댓글 삭제하기", 12);

		private final String name;
		private final int number;

		Cmd(String name, int number) {
			this.name = name;
			this.number = number;
		}

		public String getName() {
			return name;
		}

		public int getNumber() {
			return number;
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Dashboard dashboard = new Dashboard(sc);
		int articleNumber = 0;
		int replyNumber = 0;
		int cmd = 0;
		while (true) {
			System.out.print(
					"1: 게시글 작성하기\t\t2: 모든 게시글 출력하기\t\t\t3: 게시글 정보 출력하기\n4: 게시글 수정하기\t\t5: 게시글 삭제하기\t\t\t6: 게시글의 개수 출력하기\n7: 게시글에 댓글 작성하기\t8: 게시글에 등록된 댓글 삭제하기\t9: 게시글에 등록된 댓글 추천하기\n10: 게시글 제목으로 검색하기\t11: 게시글 목록 전체 삭제하기\t\t12: 게시글의 모든 댓글 삭제하기\n다음 행동을 선택하세요. (0: 종료) >> ");
			try {
				cmd = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException nfe) {
				nfe.printStackTrace();
			}
			if (cmd == Cmd.QUIT.getNumber()) {
				System.out.println("대시보드 서비스를 종료합니다.");
				break;
			} else if (cmd == Cmd.WRITE_ARTICLE.getNumber()) {
				dashboard.writeArticle();
			} else if (cmd == Cmd.PRINT_ALL_ARTICLES.getNumber()) {
				dashboard.printAllArticles();
			} else if (cmd == Cmd.PRINT_ARTICLE.getNumber()) {
				System.out.print("게시글 번호를 입력하세요. >> ");
				articleNumber = Integer.parseInt(sc.nextLine());
				System.out.println();
				dashboard.printArticle(articleNumber);
			} else if (cmd == Cmd.UPDATE_ARTICLE.getNumber()) {
				System.out.print("게시글 번호를 입력하세요. >> ");
				dashboard.updateArticle(Integer.parseInt(sc.nextLine()));
			} else if (cmd == Cmd.DELETE_ARTICLE.getNumber()) {
				System.out.print("게시글 번호를 입력하세요. >> ");
				dashboard.deleteArticle(Integer.parseInt(sc.nextLine()));
			} else if (cmd == Cmd.PRINT_ARTICLE_COUNT.getNumber()) {
				dashboard.printArticleCount();
			} else if (cmd == Cmd.ADD_REPLY.getNumber()) {
				System.out.print("게시글 번호를 입력하세요. >> ");
				dashboard.addReplyOnArticle(Integer.parseInt(sc.nextLine()));
			} else if (cmd == Cmd.DELETE_REPLY.getNumber()) {
				System.out.print("게시글 번호를 입력하세요. >> ");
				articleNumber = Integer.parseInt(sc.nextLine());
				System.out.print("댓글 번호를 입력하세요. >> ");
				replyNumber = Integer.parseInt(sc.nextLine());
				dashboard.deleteReplyOnArticle(articleNumber, replyNumber);
			} else if (cmd == Cmd.LIKE_REPLY.getNumber()) {
				System.out.print("게시글 번호를 입력하세요. >> ");
				articleNumber = Integer.parseInt(sc.nextLine());
				System.out.print("댓글 번호를 입력하세요. >> ");
				replyNumber = Integer.parseInt(sc.nextLine());
				dashboard.likeReplyOnArticle(articleNumber, replyNumber);
			} else if (cmd == Cmd.SEARCH_ARTICLE.getNumber()) {
				System.out.print("검색어를 입력하세요. >> ");
				dashboard.searchArticleByName(sc.nextLine());
			} else if (cmd == Cmd.DELETE_ALL_ARTICLES.getNumber()) {
				dashboard.deleteAllArticles();
			} else if (cmd == Cmd.DELETE_ALL_REPLIES.getNumber()) {
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
