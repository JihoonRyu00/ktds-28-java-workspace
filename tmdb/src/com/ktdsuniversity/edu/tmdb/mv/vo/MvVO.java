package com.ktdsuniversity.edu.tmdb.mv.vo;

import java.util.List;

import com.ktdsuniversity.edu.tmdb.bckgrnd.vo.BckgrndVO;
import com.ktdsuniversity.edu.tmdb.flmmkr.vo.FlmmkrVO;
import com.ktdsuniversity.edu.tmdb.gnr.vo.GnrVO;
import com.ktdsuniversity.edu.tmdb.kywrd.vo.KywrdVO;
import com.ktdsuniversity.edu.tmdb.pstr.vo.PstrVO;
import com.ktdsuniversity.edu.tmdb.str.vo.StrVO;
import com.ktdsuniversity.edu.tmdb.vd.vo.VdVO;

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

	// 하나의 영화는 여러 개의 동영상을 가지고 있다.
	private List<VdVO> vdList;
	// 하나의 영화는 여러 개의 배경을 가지고 있다.
	private List<BckgrndVO> bckgrndList;
	// 하나의 영화는 여러 개의 포스터를 가지고 있다.
	private List<PstrVO> pstrList;
	// 하나의 영화는 여러 명이 제작했다.
	private List<FlmmkrVO> flmmkrList;
	// 하나의 영화는 여러 명이 출연했다.
	private List<StrVO> strList;
	// 하나의 영화는 여러 개의 키워드가 있다.
	private List<KywrdVO> kywrdList;
	// 하나의 영화는 여러 개의 장르가 있다.
	private List<GnrVO> gnrList;

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
	public String getXUrl() {
		return this.xUrl;
	}
	public void setXUrl(String xUrl) {
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

	public List<VdVO> getVdList() {
		return this.vdList;
	}
	public void setVdList(List<VdVO> vdList) {
		this.vdList = vdList;
	}
	public List<BckgrndVO> getBckgrndList() {
		return this.bckgrndList;
	}
	public void setBckgrndList(List<BckgrndVO> bckgrndList) {
		this.bckgrndList = bckgrndList;
	}
	public List<PstrVO> getPstrList() {
		return this.pstrList;
	}
	public void setPstrList(List<PstrVO> pstrList) {
		this.pstrList = pstrList;
	}

	public List<FlmmkrVO> getFlmmkrList() {
		return this.flmmkrList;
	}
	public void setFlmmkrList(List<FlmmkrVO> flmmkrList) {
		this.flmmkrList = flmmkrList;
	}
	public List<StrVO> getStrList() {
		return this.strList;
	}
	public void setStrList(List<StrVO> strList) {
		this.strList = strList;
	}
	public List<KywrdVO> getKywrdList() {
		return this.kywrdList;
	}
	public void setKywrdList(List<KywrdVO> kywrdList) {
		this.kywrdList = kywrdList;
	}
	public List<GnrVO> getGnrList() {
		return this.gnrList;
	}
	public void setGnrList(List<GnrVO> gnrList) {
		this.gnrList = gnrList;
	}

	@Override
	public String toString() {
		return "MvVO [mvId=" + mvId + ", ttl=" + ttl + ", mvRtng=" + mvRtng + ", rnngTm=" + rnngTm + ", smmr=" + smmr
				+ ", rlsDt=" + rlsDt + ", mainPstrUrl=" + mainPstrUrl + ", fbUrl=" + fbUrl + ", xUrl=" + xUrl
				+ ", instaUrl=" + instaUrl + ", tgln=" + tgln + ", orgnlTtl=" + orgnlTtl + ", plyng=" + plyng
				+ ", orgnlLngg=" + orgnlLngg + ", bdgt=" + bdgt + ", bxOffcRvn=" + bxOffcRvn + "]";
	}

}
