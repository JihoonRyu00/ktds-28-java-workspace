package com.ktdsuniversity.edu.oop.dashboard;

import java.util.ArrayList;

public class Reply {

	private final int ID;
	private String userName;
	private String date;
	private String content;
	private int likes;

	public Reply(int nextReplyId, String userName, String date, String content) {
		this.ID = nextReplyId;
		this.userName = userName;
		this.date = date;
		this.content = content;
		this.likes = 0;
	}

	public int getID() {
		return this.ID;
	}

	public String getUserName() {
		return this.userName;
	}

	public String getDate() {
		return this.date;
	}

	public String getContent() {
		return this.content;
	}

	public int getLikes() {
		return this.likes;
	}

	@Override
	public String toString() {
		String output = "";
		output += "댓글 ID: " + this.ID;
		output += "\t댓글 작성자: " + this.userName;
		output += "\t댓글 작성 날짜: " + this.date;
		output += "\n\t댓글 내용: " + this.content;
		output += "\t(♥" + this.likes + ")\n";
		return output;
	}

}
