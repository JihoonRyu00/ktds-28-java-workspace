package com.ktdsuniversity.edu.oop.dashboard;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Article implements ArticleInterface {
	
	private final int ID;
	private String title;
	private String userName;
	private Date date;
	private String content;
	private int views;
	private int nextReplyId;

	private List<Reply> replyList;

	public Article(int nextArticleId, String title, String userName, Date date, String content) {
		this.ID = nextArticleId;
		this.title = title;
		this.userName = userName;
		this.date = date;
		this.content = content;
		this.views = 0;
		this.replyList = new ArrayList<>();
		nextReplyId = 1;
	}

	public int getID() {
		return this.ID;
	}

	public String getTitle() {
		return this.title;
	}

	public String getUserName() {
		return this.userName;
	}

	public String getContent() {
		return this.content;
	}

	public int getViews() {
		return this.views;
	}

	public int getNextReplyId() {
		return nextReplyId;
	}

	public List<Reply> getReplyList() {
		return replyList;
	}

	@Override
	public String toString() {
		String output = "";
		output += "게시물 ID: " + this.ID;
		output += "\t게시물 제목: " + this.title;
		output += "\t게시물 조회수: " + this.views;
		output += "\n게시물 작성자: " + this.userName;
		output += "\t게시물 작성 날짜: " + this.date.toString();
		output += "\n게시물 내용: \n" + this.content + "\n\n";
		output += repliesToString();
		return output;
	}

	@Override
	public void updateTitle(String newTitle) {
		this.title = newTitle;
	}

	@Override
	public void updateContent(String newContent) {
		this.content = newContent;
	}

	@Override
	public void addReply(Scanner sc) {
		System.out.print("작성자 이름을 입력하세요. >> ");
		String userName = sc.nextLine();
		userName = userName.strip();
		if (userName.length() == 0) {
			ArticleWriterException awe = new ArticleWriterException("작성자명은 반드시 입력해야합니다.");
			throw awe;
		}
		// ====================================
		Date date = new Date();
		// ====================================
		System.out.print("내용을 입력하세요. >> ");
		String content = sc.nextLine();
		this.replyList.add(new Reply(nextReplyId++, userName, date, content));
	}

	@Override
	public void deleteReply(int replyNumber) {
		if (!isValidReplyNumber(replyNumber)) {
			return;
		}
		this.replyList.remove(replyNumber - 1);
		System.out.println("댓글 삭제가 완료되었습니다.");
	}

	@Override
	public void deleteAllReplies() {
		int replyCount = this.replyList.size();
		if (replyCount == 0) {
			System.out.println("등록된 댓글이 없습니다.");
			return;
		}
		this.replyList.clear();
		System.out.println(replyCount + "개의 댓글을 삭제했습니다.");
	}

	@Override
	public void likeReply(int replyNumber) {
		if (!isValidReplyNumber(replyNumber)) {
			return;
		}
		this.replyList.get(replyNumber - 1).increaseLikes();
	}

	@Override
	public int getReplyCount() {
		return this.replyList.size();
	}

	@Override
	public void increaseViews() {
		this.views++;
	}

	private String repliesToString() {
		if (this.replyList.isEmpty()) {
			return "-".repeat(50) + "\n등록된 댓글이 없습니다.";
		}
		String output = "";
		output += "--------------------- Replies ---------------------\n";
		for (int i = 0; i < this.replyList.size(); ++i) {
			output += "↳\t댓글 번호: " + (i + 1) + this.replyList.get(i);
		}
		output += "--------------------------------------------------";
		return output;
	}

	@Override
	public boolean isValidReplyNumber(int replyNumber) {
		if (replyNumber < 1 || replyNumber > this.replyList.size()) {
			System.out.println("잘못된 댓글 번호입니다.");
			return false;
		}
		return true;
	}

}
