package com.ktdsuniversity.edu.tmdb.pstr.vo;

public class PstrVO {

	private String pstrId;
	private String url;
	private String mvId;

	public String getPstrId() {
		return this.pstrId;
	}
	public void setPstrId(String pstrId) {
		this.pstrId = pstrId;
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
		return "PstrVO [pstrId=" + pstrId + ", url=" + url + ", mvId=" + mvId + "]";
	}

}
