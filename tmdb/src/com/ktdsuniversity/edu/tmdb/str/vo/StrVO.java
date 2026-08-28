package com.ktdsuniversity.edu.tmdb.str.vo;

public class StrVO {

	private String strId;
	private String invlvdId;
	private String mvId;
	private String rl;

	public String getStrId() {
		return this.strId;
	}
	public void setStrId(String strId) {
		this.strId = strId;
	}
	public String getInvlvdId() {
		return this.invlvdId;
	}
	public void setInvlvdId(String invlvdId) {
		this.invlvdId = invlvdId;
	}
	public String getMvId() {
		return this.mvId;
	}
	public void setMvId(String mvId) {
		this.mvId = mvId;
	}
	public String getRl() {
		return this.rl;
	}
	public void setRl(String rl) {
		this.rl = rl;
	}

	@Override
	public String toString() {
		return "StrVO [strId=" + strId + ", invlvdId=" + invlvdId + ", mvId=" + mvId + ", rl=" + rl + "]";
	}

}
