package com.ktdsuniversity.edu.oop.dashboard.interfaces;

public interface DashboardInterface {

	void writeArticle();

	void printAllArticles();

	void printArticle(int articleNumber);

	void updateArticle(int articleNumber);

	void deleteArticle(int articleNumber);

	void printArticleCount();

	void addReplyOnArticle(int articleNumber);

	void deleteReplyOnArticle(int articleNumber, int replyNumber);

	void likeReplyOnArticle(int articleNumber, int replyNumber);

	void searchArticleByName(String query);

	void deleteAllArticles();

	void deleteAllRepliesOnArticle(int articleNumber);

	boolean isValidAlticleNumber(int articleNumber);
}
