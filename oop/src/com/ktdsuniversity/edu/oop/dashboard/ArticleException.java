package com.ktdsuniversity.edu.oop.dashboard;

public class ArticleException extends RuntimeException {

	public ArticleException(String message) {
		super(message);
	}

	public ArticleException(String message, Throwable cause) {
		super(message, cause);
	}
}
