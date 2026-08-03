package com.ktdsuniversity.edu.oop.dashboard.interfaces;

import java.util.Scanner;

public interface ArticleInterface {

	int TITLE_LIMIT = 30;
//	int CONTENT_LIMIT = 300;
	int REPLY_LIMIT = 10;

	void updateTitle(String newTitle);

	void updateContent(String newContent);

	void addReply(Scanner sc);

	void deleteReply(int replyNumber);

	void deleteAllReplies();

	void likeReply(int replyNumber);

	int getReplyCount();

	void increaseViews();

	boolean isValidReplyNumber(int replyNumber);

}
