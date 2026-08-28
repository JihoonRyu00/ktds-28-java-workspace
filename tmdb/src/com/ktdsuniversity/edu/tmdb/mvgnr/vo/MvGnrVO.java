package com.ktdsuniversity.edu.tmdb.mvgnr.vo;

public class MvGnrVO {

	private String mvGnrId;
	private String gnrId;
	private String mvId;

	public String getMvGnrId() {
		return this.mvGnrId;
	}
	public void setMvGnrId(String mvGnrId) {
		this.mvGnrId = mvGnrId;
	}
	public String getGnrId() {
		return this.gnrId;
	}
	public void setGnrId(String gnrId) {
		this.gnrId = gnrId;
	}
	public String getMvId() {
		return this.mvId;
	}
	public void setMvId(String mvId) {
		this.mvId = mvId;
	}

	@Override
	public String toString() {
		return "MvGnrVO [mvGnrId=" + mvGnrId + ", gnrId=" + gnrId + ", mvId=" + mvId + "]";
	}

}
