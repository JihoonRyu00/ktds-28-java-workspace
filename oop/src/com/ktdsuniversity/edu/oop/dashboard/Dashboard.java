package com.ktdsuniversity.edu.oop.dashboard;

import java.util.ArrayList;
import java.util.Date;
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
		title = title.strip();
		if (title.length() == 0 || title.length() > 30) {
			ArticleException ae = new ArticleException("제목은 1글자 이상 30글자 이하로 작성해야만 합니다.");
			throw ae;
		}
		System.out.print("Enter your name. >> ");
		String userName = sc.next();
		userName = userName.strip();
		if (userName.length() == 0) {
			ArticleWriterException awe = new ArticleWriterException("작성자명은 반드시 입력해야합니다.");
			throw awe;
		}
		// ====================================
		Date date = new Date();
		// ====================================
		System.out.print("Enter article content. >> ");
		String content = sc.next();
		articleList.add(new Article(nextArticleId++, title, userName, date, content));
		System.out.println("게시글 작성이 완료되었습니다.");
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
		while (true) {
			System.out.print("수정할 항목을 선택하세요. (1: 제목 수정, 2: 내용 수정, 3: 수정 종료) >> ");
			cmd = sc.nextInt();
			if (cmd == 1) {
				System.out.println("<기존 제목> " + articleToUpdate.getTitle() + "\n수정 >>");
				String newTitle = sc.next();
				newTitle = newTitle.strip();
				if (newTitle.length() == 0 || newTitle.length() > 30) {
					ArticleException ae = new ArticleException("제목은 1글자 이상 30글자 이하로 작성해야만 합니다.");
					throw ae;
				}
				articleToUpdate.updateTitle(newTitle);
				System.out.println("게시글 제목 수정이 완료되었습니다.");
			} else if (cmd == 2) {
				System.out.println("<기존 내용>\n" + articleToUpdate.getContent() + "\n수정 >>");
				String newContent = sc.next();
				articleToUpdate.updateContent(newContent);
				System.out.println("게시글 내용 수정이 완료되었습니다.");
			} else if (cmd == 3) {
				System.out.println("게시물 수정을 종료합니다.");
				break;
			} else {
				System.out.println("올바른 번호를 입력하세요.");
			}
		}
		sc.close();
	}

	@Override
	public void deleteArticle(int articleIndex) {
		if (!isValidAlticleNumber(articleIndex)) {
			return;
		}
		this.articleList.remove(articleIndex);
		System.out.println("게시글 삭제가 완료되었습니다.");
	}

	@Override
	public void printArticleCount() {
		int articleCount = this.articleList.size();
		if (articleCount == 0) {
			System.out.println("등록된 게시글이 없습니다.");
			return;
		}
		System.out.println("%d개의 게시글이 등록되어 있습니다.".formatted(articleCount));
	}

	@Override
	public void addReplyOnArticle(int articleIndex) {
		if (!isValidAlticleNumber(articleIndex)) {
			return;
		}
		Article articleToUpdate = this.articleList.get(articleIndex - 1);
		if (articleToUpdate.getReplyCount() == 10) {
			System.out.println("댓글을 더 이상 등록할 수 없습니다.");
			return;
		}
		Scanner sc = new Scanner(System.in);
		articleToUpdate.addReply(sc);
		sc.close();
		System.out.println("댓글 작성이 완료되었습니다.");
	}

	@Override
	public void deleteReplyOnArticle(int articleIndex, int replyIndex) {
		if (!isValidAlticleNumber(articleIndex)) {
			return;
		}
	}

	@Override
	public void likeReplyOnArticle(int articleIndex, int replyIndex) {
		if (!isValidAlticleNumber(articleIndex)) {
			return;
		}
	}

	@Override
	public void deleteAllArticles() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllRepliesOnArticle(int articleIndex) {
		if (!isValidAlticleNumber(articleIndex)) {
			return;
		}
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
