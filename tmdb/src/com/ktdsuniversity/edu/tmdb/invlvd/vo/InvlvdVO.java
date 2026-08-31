package com.ktdsuniversity.edu.tmdb.invlvd.vo;

import java.util.List;

import com.ktdsuniversity.edu.tmdb.flmmkr.vo.FlmmkrVO;
import com.ktdsuniversity.edu.tmdb.str.vo.StrVO;

public class InvlvdVO {

	private String invlvdId;
	private String prflUrl;
	private String nm;

	// 참여자 한 명이 여러 개의 영화를 제작했다.
	private List<FlmmkrVO> flmmkrList;
	// 참여자 한 명이 여러 개의 영화에 출연했다.
	private List<StrVO> strList;

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

	@Override
	public String toString() {
		return "InvlvdVO [invlvdId=" + invlvdId + ", prflUrl=" + prflUrl + ", nm=" + nm + "]";
	}

}
