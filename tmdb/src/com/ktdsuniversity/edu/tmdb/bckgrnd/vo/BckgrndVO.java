package com.ktdsuniversity.edu.tmdb.bckgrnd.vo;

public class BckgrndVO {

	private String bckgrndId;
	private String url;
	private String mvId;
	public String getBckgrndId() {
		return this.bckgrndId;
	}
	public void setBckgrndId(String bckgrndId) {
		this.bckgrndId = bckgrndId;
	}
	public String getUrl() {
		return this.url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getMvId() {
		return this.mvId;
	}
	public void setMvId(String mvId) {
		this.mvId = mvId;
	}

	@Override
	public String toString() {
		return "BckgrndVO [bckgrndId=" + bckgrndId + ", url=" + url + ", mvId=" + mvId + "]";
	}

}
