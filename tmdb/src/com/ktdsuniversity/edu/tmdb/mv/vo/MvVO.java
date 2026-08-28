package com.ktdsuniversity.edu.tmdb.mv.vo;

public class MvVO {

	private String mvId;
	private String ttl;
	private String mvRtng;
	private int rnngTm;
	private String smmr;
	private String rlsDt;
	private String mainPstrUrl;
	private String fbUrl;
	private String xUrl;
	private String instaUrl;
	private String tgln;
	private String orgnlTtl;
	private String plyng;
	private String orgnlLngg;
	private long bdgt;
	private long bxOffcRvn;

	public String getMvId() {
		return this.mvId;
	}
	public void setMvId(String mvId) {
		this.mvId = mvId;
	}
	public String getTtl() {
		return this.ttl;
	}
	public void setTtl(String ttl) {
		this.ttl = ttl;
	}
	public String getMvRtng() {
		return this.mvRtng;
	}
	public void setMvRtng(String mvRtng) {
		this.mvRtng = mvRtng;
	}
	public int getRnngTm() {
		return this.rnngTm;
	}
	public void setRnngTm(int rnngTm) {
		this.rnngTm = rnngTm;
	}
	public String getSmmr() {
		return this.smmr;
	}
	public void setSmmr(String smmr) {
		this.smmr = smmr;
	}
	public String getRlsDt() {
		return this.rlsDt;
	}
	public void setRlsDt(String rlsDt) {
		this.rlsDt = rlsDt;
	}
	public String getMainPstrUrl() {
		return this.mainPstrUrl;
	}
	public void setMainPstrUrl(String mainPstrUrl) {
		this.mainPstrUrl = mainPstrUrl;
	}
	public String getFbUrl() {
		return this.fbUrl;
	}
	public void setFbUrl(String fbUrl) {
		this.fbUrl = fbUrl;
	}
	public String getxUrl() {
		return this.xUrl;
	}
	public void setxUrl(String xUrl) {
		this.xUrl = xUrl;
	}
	public String getInstaUrl() {
		return this.instaUrl;
	}
	public void setInstaUrl(String instaUrl) {
		this.instaUrl = instaUrl;
	}
	public String getTgln() {
		return this.tgln;
	}
	public void setTgln(String tgln) {
		this.tgln = tgln;
	}
	public String getOrgnlTtl() {
		return this.orgnlTtl;
	}
	public void setOrgnlTtl(String orgnlTtl) {
		this.orgnlTtl = orgnlTtl;
	}
	public String getPlyng() {
		return this.plyng;
	}
	public void setPlyng(String plyng) {
		this.plyng = plyng;
	}
	public String getOrgnlLngg() {
		return this.orgnlLngg;
	}
	public void setOrgnlLngg(String orgnlLngg) {
		this.orgnlLngg = orgnlLngg;
	}
	public long getBdgt() {
		return this.bdgt;
	}
	public void setBdgt(long bdgt) {
		this.bdgt = bdgt;
	}
	public long getBxOffcRvn() {
		return this.bxOffcRvn;
	}
	public void setBxOffcRvn(long bxOffcRvn) {
		this.bxOffcRvn = bxOffcRvn;
	}

	@Override
	public String toString() {
		return "MvVO [mvId=" + mvId + ", ttl=" + ttl + ", mvRtng=" + mvRtng + ", rnngTm=" + rnngTm + ", smmr=" + smmr
				+ ", rlsDt=" + rlsDt + ", mainPstrUrl=" + mainPstrUrl + ", fbUrl=" + fbUrl + ", xUrl=" + xUrl
				+ ", instaUrl=" + instaUrl + ", tgln=" + tgln + ", orgnlTtl=" + orgnlTtl + ", plyng=" + plyng
				+ ", orgnlLngg=" + orgnlLngg + ", bdgt=" + bdgt + ", bxOffcRvn=" + bxOffcRvn + "]";
	}

}
