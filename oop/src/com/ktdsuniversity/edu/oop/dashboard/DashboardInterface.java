package com.ktdsuniversity.edu.oop.dashboard;

public interface DashboardInterface {
	public abstract void writeArticle();

	public abstract void printAllArticles();

	public abstract void printArticle(int articleIndex);

	public abstract void updateArticle(int articleIndex);

	public abstract void deleteArticle(int articleIndex);

	public abstract void printArticleCount();

	public abstract void addReplyOnArticle(int articleIndex);

	public abstract void deleteReplyOnArticle(int articleIndex, int replyIndex);

	public abstract void likeReplyOnArticle(int articleIndex, int replyIndex);

	public abstract void deleteAllArticles();

	public abstract void deleteAllRepliesOnArticle(int articleIndex);

	public boolean isValidAlticleNumber(int articleIndex);
}
