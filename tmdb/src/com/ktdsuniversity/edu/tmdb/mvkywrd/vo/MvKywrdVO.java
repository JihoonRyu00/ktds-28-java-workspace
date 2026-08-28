package com.ktdsuniversity.edu.tmdb.mvkywrd.vo;

public class MvKywrdVO {

	private String mvKywrdId;
	private String kywrdId;
	private String mvId;

	public String getMvKywrdId() {
		return this.mvKywrdId;
	}
	public void setMvKywrdId(String mvKywrdId) {
		this.mvKywrdId = mvKywrdId;
	}
	public String getKywrdId() {
		return this.kywrdId;
	}
	public void setKywrdId(String kywrdId) {
		this.kywrdId = kywrdId;
	}
	public String getMvId() {
		return this.mvId;
	}
	public void setMvId(String mvId) {
		this.mvId = mvId;
	}

	@Override
	public String toString() {
		return "MvKywrdVO [mvKywrdId=" + mvKywrdId + ", kywrdId=" + kywrdId + ", mvId=" + mvId + "]";
	}

}
