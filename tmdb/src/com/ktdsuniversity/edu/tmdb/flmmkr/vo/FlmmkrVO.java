package com.ktdsuniversity.edu.tmdb.flmmkr.vo;

public class FlmmkrVO {

	private String flmmkrId;
	private String invlvdId;
	private String mvId;
	private String prt;
	private String rl;

	public String getFlmmkrId() {
		return this.flmmkrId;
	}
	public void setFlmmkrId(String flmmkrId) {
		this.flmmkrId = flmmkrId;
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
	public String getPrt() {
		return this.prt;
	}
	public void setPrt(String prt) {
		this.prt = prt;
	}
	public String getRl() {
		return this.rl;
	}
	public void setRl(String rl) {
		this.rl = rl;
	}

	@Override
	public String toString() {
		return "FlmmkrVO [flmmkrId=" + flmmkrId + ", invlvdId=" + invlvdId + ", mvId=" + mvId + ", prt=" + prt + ", rl="
				+ rl + "]";
	}

}
