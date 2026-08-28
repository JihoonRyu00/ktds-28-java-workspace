package com.ktdsuniversity.edu.tmdb.vd.vo;

public class VdVO {

	private String vdId;
	private String url;
	private String mvId;

	public String getVdId() {
		return this.vdId;
	}
	public void setVdId(String vdId) {
		this.vdId = vdId;
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
		return "VdVO [vdId=" + vdId + ", url=" + url + ", mvId=" + mvId + "]";
	}

}
