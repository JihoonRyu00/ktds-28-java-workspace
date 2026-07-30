package com.ktdsuniversity.edu.oop.dashboard;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dashboard implements DashboardInterface {

	private static int nextArticleId;
	private List<Article> articleList;

	public Dashboard() {
		this.articleList = new ArrayList<>();
		nextArticleId = 1;
	}

	public static int getNextArticleId() {
		return nextArticleId;
	}

	public List<Article> getArticleList() {
		return articleList;
	}

	@Override
	public void writeArticle() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter article title. >> ");
		String title = sc.next();
		System.out.print("Enter yout name. >> ");
		String userName = sc.next();
		// ====================================
		String date = "2099-09-19";
		// ====================================
		System.out.print("Enter article content. >> ");
		String content = sc.next();
		articleList.add(new Article(nextArticleId++, title, userName, date, content));
	}

	@Override
	public void printAllArticles() {
		if (this.articleList.isEmpty()) {
			System.out.println("아직 등록된 게시글이 없습니다.");
			return;
		}
		System.out.println("=====================Articles=====================");
		int i = 1;
		for (Article a : this.articleList) {
			System.out.println(i + ". " + a.getTitle() + " (" + a.getReplyCount());
		}
		System.out.println("==================================================");

	}

	@Override
	public void printArticle(int articleIndex) {
		if (!isValidAlticleNumber(articleIndex)) {
			return;
		}
		Article curArticle = this.articleList.get(articleIndex - 1);
		System.out.println("게시물 번호: " + (articleIndex - 1));
		System.out.println(curArticle);
		curArticle.increaseViews();
	}

	@Override
	public void updateArticle(int articleIndex) {
		if (!isValidAlticleNumber(articleIndex)) {
			return;
		}
		Article articleToUpdate = this.articleList.get(articleIndex - 1);
		Scanner sc = new Scanner(System.in);
		int cmd = sc.nextInt();
		while (cmd != 3) {
			System.out.println();
			cmd = sc.nextInt();
			if (cmd == 1) {

			} else if (cmd == 2) {

			} else if (cmd == 3) {
				System.out.println("게시물 수정을 종료합니다.");
				break;
			} else {
				System.out.println("올바른 번호를 입력하세요.");
			}
		}
	}

	@Override
	public void deleteArticle(int articleIndex) {
		// TODO Auto-generated method stub

	}

	@Override
	public void printArticleCount() {
		// TODO Auto-generated method stub

	}

	@Override
	public void addReplyOnArticle(int articleIndex) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteReplyOnArticle(int articleIndex, int replyIndex) {
		// TODO Auto-generated method stub

	}

	@Override
	public void likeReplyOnArticle(int articleIndex, int replyIndex) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllArticles() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllRepliesOnArticle(int articleIndex) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isValidAlticleNumber(int articleIndex) {
		if (articleIndex < 1 || articleIndex > this.articleList.size()) {
			System.out.println("잘못된 게시글 번호입니다.");
			return false;
		}
		return true;
	}

}
