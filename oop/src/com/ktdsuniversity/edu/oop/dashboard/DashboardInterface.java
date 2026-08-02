package com.ktdsuniversity.edu.oop.dashboard;

public interface DashboardInterface {
	public abstract void writeArticle();

	public abstract void printAllArticles();

	public abstract void printArticle(int articleNumber);

	public abstract void updateArticle(int articleNumber);

	public abstract void deleteArticle(int articleNumber);

	public abstract void printArticleCount();

	public abstract void addReplyOnArticle(int articleNumber);

	public abstract void deleteReplyOnArticle(int articleNumber, int replyNumber);

	public abstract void likeReplyOnArticle(int articleNumber, int replyNumber);

	void searchArticleByName(String query);

	public abstract void deleteAllArticles();

	public abstract void deleteAllRepliesOnArticle(int articleNumber);

	public boolean isValidAlticleNumber(int articleNumber);
}
