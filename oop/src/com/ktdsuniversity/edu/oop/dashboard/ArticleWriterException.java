package com.ktdsuniversity.edu.oop.dashboard;

public class ArticleWriterException extends RuntimeException {

	private static final long serialVersionUID = 6280985688950435441L;

	public ArticleWriterException(String message) {
		super(message);
	}

	public ArticleWriterException(String message, Throwable cause) {
		super(message, cause);
	}
}
