package com.ktdsuniversity.edu.oop.dashboard;

public interface ArticleInterface {

	int TITLE_LIMIT = 30;
	int CONTENT_LIMIT = 300;
	int REPLY_LIMIT = 10;

	public abstract void print();

	public abstract void updateContent();

	public abstract void addReply();

	public abstract void likeReply();

	public abstract int getReplyCount();

	public abstract void increaseViews();
}
