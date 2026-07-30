package com.ktdsuniversity.edu.oop.dashboard;

import java.util.ArrayList;
import java.util.List;

public class Article implements ArticleInterface {
	private final int ID;
	private String title;
	private String userName;
	private String date;
	private String content;
	private int views;
	private int nextReplyId;

	private List<Reply> replyList;

	public Article(int nextArticleId, String title, String userName, String date, String content) {
		this.ID = nextArticleId;
		this.title = title;
		this.userName = userName;
		this.date = date;
		this.content = content;
		this.views = 0;
		this.replyList = new ArrayList<>();
		this.nextReplyId = 1;
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
		return this.nextReplyId;
	}

	public List<Reply> getReplyList() {
		return replyList;
	}

	@Override
	public String toString() {
		String output = "";
		output += "게시물 ID: " + this.ID;
		output += "\t게시물 제목: " + this.title;
		output += "\n게시물 작성자: " + this.userName;
		output += "\t게시물 작성 날짜: " + this.date;
		output += "\t게시물 조회수: " + this.views;
		output += "\n게시물 내용: \n" + this.content + "\n";
		output += repliesToString();
		return output;
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateContent() {
		// TODO Auto-generated method stub

	}

	@Override
	public void addReply() {
		// TODO Auto-generated method stub

	}

	@Override
	public void likeReply() {
		// TODO Auto-generated method stub

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
			return "등록된 댓글이 없습니다.\n";
		}
		String output = "";
		output += "---------------------Replies---------------------";
		for (Reply r : replyList) {
			output += "↳\t" + r;
		}
		output += "--------------------------------------------------";
		return output;
	}
}
