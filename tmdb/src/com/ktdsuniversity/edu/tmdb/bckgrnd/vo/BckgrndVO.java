package com.ktdsuniversity.edu.tmdb.bckgrnd.vo;

import com.ktdsuniversity.edu.tmdb.mv.vo.MvVO;

public class BckgrndVO {

	private String bckgrndId;
	private String url;
	private String mvId;

	// 하나의 배경은 하나의 영화를 위한 것이다.
	private MvVO mvVO;

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

	public MvVO getMvVO() {
		return this.mvVO;
	}
	public void setMvVO(MvVO mvVO) {
		this.mvVO = mvVO;
	}

	@Override
	public String toString() {
		return "BckgrndVO [bckgrndId=" + bckgrndId + ", url=" + url + ", mvId=" + mvId + "]";
	}

}
