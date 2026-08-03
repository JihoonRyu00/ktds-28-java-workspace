package com.ktdsuniversity.edu.oop.dashboard;

import java.util.Scanner;

public interface ArticleInterface {

	int TITLE_LIMIT = 30;
//	int CONTENT_LIMIT = 300;
	int REPLY_LIMIT = 10;

	public abstract void updateTitle(String newTitle);

	public abstract void updateContent(String newContent);

	public abstract void addReply(Scanner sc);

	public void deleteReply(int replyNumber);

	void deleteAllReplies();

	void likeReply(int replyNumber);

	public abstract int getReplyCount();

	public abstract void increaseViews();

	public abstract boolean isValidReplyNumber(int replyNumber);

}
