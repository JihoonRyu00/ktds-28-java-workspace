package com.ktdsuniversity.edu.oop.dashboard;

public class ArticleException extends RuntimeException {

	private static final long serialVersionUID = 7415636192843436084L;

	public ArticleException(String message) {
		super(message);
	}

	public ArticleException(String message, Throwable cause) {
		super(message, cause);
	}
}
