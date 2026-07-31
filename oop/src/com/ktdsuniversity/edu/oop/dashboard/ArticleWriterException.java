package com.ktdsuniversity.edu.oop.dashboard;

public class ArticleWriterException extends RuntimeException {

	public ArticleWriterException(String message) {
		super(message);
	}

	public ArticleWriterException(String message, Throwable cause) {
		super(message, cause);
	}
}
