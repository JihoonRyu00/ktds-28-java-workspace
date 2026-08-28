package com.ktdsuniversity.edu.tmdb.invlvd.vo;

public class InvlvdVO {

	private String invlvdId;
	private String prflUrl;
	private String nm;

	public String getInvlvdId() {
		return this.invlvdId;
	}
	public void setInvlvdId(String invlvdId) {
		this.invlvdId = invlvdId;
	}
	public String getPrflUrl() {
		return this.prflUrl;
	}
	public void setPrflUrl(String prflUrl) {
		this.prflUrl = prflUrl;
	}
	public String getNm() {
		return this.nm;
	}
	public void setNm(String nm) {
		this.nm = nm;
	}

	@Override
	public String toString() {
		return "InvlvdVO [invlvdId=" + invlvdId + ", prflUrl=" + prflUrl + ", nm=" + nm + "]";
	}

}
