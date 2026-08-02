package com.ktdsuniversity.edu.oop.dashboard;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Dashboard implements DashboardInterface {

	private final Scanner sc;

	private int nextArticleId;
	private List<Article> articleList;

	public Dashboard(Scanner sc) {
		this.sc = sc;
		this.articleList = new ArrayList<>();
		nextArticleId = 1;
	}

	public int getNextArticleId() {
		return nextArticleId;
	}

	public List<Article> getArticleList() {
		return articleList;
	}

	@Override
	public void writeArticle() {
		System.out.print("Enter article title. >> ");
		String title = sc.nextLine();
		title = title.strip();
		if (title.length() == 0 || title.length() > Article.TITLE_LIMIT) {
			ArticleException ae = new ArticleException("제목은 1글자 이상 30글자 이하로 작성해야만 합니다.");
			throw ae;
		}
		System.out.print("Enter your name. >> ");
		String userName = sc.nextLine();
		userName = userName.strip();
		if (userName.length() == 0) {
			ArticleWriterException awe = new ArticleWriterException("작성자명은 반드시 입력해야합니다.");
			throw awe;
		}
		// ====================================
		Date date = new Date();
		// ====================================
		System.out.print("Enter article content. >> ");
		String content = sc.nextLine();
		articleList.add(new Article(nextArticleId++, title, userName, date, content));
		System.out.println("게시글 작성이 완료되었습니다.");
	}

	@Override
	public void printAllArticles() {
		if (this.articleList.isEmpty()) {
			System.out.println("아직 등록된 게시글이 없습니다.");
			return;
		}
		System.out.println("==================== Articles ====================");
		int i = 1;
		for (Article a : this.articleList) {
			System.out.println(i++ + ". " + a.getTitle() + " (" + a.getReplyCount() + ")");
		}
		System.out.println("==================================================");

	}

	@Override
	public void printArticle(int articleNumber) {
		if (!isValidAlticleNumber(articleNumber)) {
			return;
		}
		Article curArticle = this.articleList.get(articleNumber - 1);
		curArticle.increaseViews();
		System.out.println("게시물 번호: " + (articleNumber - 1));
		System.out.println(curArticle);
	}

	@Override
	public void updateArticle(int articleNumber) {
		if (!isValidAlticleNumber(articleNumber)) {
			return;
		}
		Article articleToUpdate = this.articleList.get(articleNumber - 1);
		int cmd = 0;
		while (true) {
			System.out.print("수정할 항목을 선택하세요. (1: 제목 수정, 2: 내용 수정, 3: 수정 종료) >> ");
			cmd = Integer.parseInt(sc.nextLine());
			if (cmd == 1) {
				System.out.print("<기존 제목> " + articleToUpdate.getTitle() + "\n수정 >> ");
				String newTitle = sc.nextLine();
				newTitle = newTitle.strip();
				if (newTitle.length() == 0 || newTitle.length() > Article.TITLE_LIMIT) {
					ArticleException ae = new ArticleException("제목은 1글자 이상 30글자 이하로 작성해야만 합니다.");
					throw ae;
				}
				articleToUpdate.updateTitle(newTitle);
				System.out.println("게시글 제목 수정이 완료되었습니다.");
			} else if (cmd == 2) {
				System.out.println("<기존 내용>\n" + articleToUpdate.getContent() + "\n수정 >> ");
				String newContent = sc.nextLine();
				articleToUpdate.updateContent(newContent);
				System.out.println("게시글 내용 수정이 완료되었습니다.");
			} else if (cmd == 3) {
				System.out.println("게시물 수정을 종료합니다.");
				break;
			} else {
				System.out.println("올바른 번호를 입력하세요.");
			}
		}
	}

	@Override
	public void deleteArticle(int articleNumber) {
		if (!isValidAlticleNumber(articleNumber)) {
			return;
		}
		this.articleList.remove(articleNumber - 1);
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
	public void addReplyOnArticle(int articleNumber) {
		if (!isValidAlticleNumber(articleNumber)) {
			return;
		}
		Article articleToUpdate = this.articleList.get(articleNumber - 1);
		if (articleToUpdate.getReplyCount() == Article.REPLY_LIMIT) {
			System.out.println("댓글을 더 이상 등록할 수 없습니다.");
			return;
		}
		articleToUpdate.addReply(sc);
		System.out.println("댓글 작성이 완료되었습니다.");
	}

	@Override
	public void deleteReplyOnArticle(int articleNumber, int replyNumber) {
		if (!isValidAlticleNumber(articleNumber)) {
			return;
		}
		this.articleList.get(articleNumber - 1).deleteReply(replyNumber);
	}

	@Override
	public void likeReplyOnArticle(int articleNumber, int replyNumber) {
		if (!isValidAlticleNumber(articleNumber)) {
			return;
		}
		this.articleList.get(articleNumber - 1).likeReply(replyNumber);
	}

	@Override
	public void searchArticleByName(String query) {
		boolean found = false;
		if ((query = query.replaceAll("\\s", "")).isEmpty()) {
			System.out.println("공백으로는 검색할 수 없습니다");
			return;
		}
		Article curArticle = null;
		for (int i = 0; i < this.articleList.size(); ++i) {
			curArticle = this.articleList.get(i);
			if (curArticle.getTitle().replaceAll("\\s", "").contains(query)) {
				System.out.println((i + 1) + ". " + curArticle.getTitle() + " (" + curArticle.getReplyCount() + ")");
				found = true;
			}
		}
		if (!found) {
			System.out.println("검색된 게시글이 없습니다.");
		}
	}

	@Override
	public void deleteAllArticles() {
		int articleCount = this.articleList.size();
		if (articleCount == 0) {
			System.out.println("제거할 게시글이 없습니다.");
			return;
		}
		this.articleList.clear();
		System.out.println(articleCount + "개의 게시글을 삭제했습니다.");
	}

	@Override
	public void deleteAllRepliesOnArticle(int articleNumber) {
		if (!isValidAlticleNumber(articleNumber)) {
			return;
		}
		this.articleList.get(articleNumber - 1).deleteAllReplies();
	}

	@Override
	public boolean isValidAlticleNumber(int articleNumber) {
		if (articleNumber < 1 || articleNumber > this.articleList.size()) {
			System.out.println("잘못된 게시글 번호입니다.");
			return false;
		}
		return true;
	}

}
