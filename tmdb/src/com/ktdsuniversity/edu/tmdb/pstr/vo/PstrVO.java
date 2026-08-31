package com.ktdsuniversity.edu.tmdb.pstr.vo;

import com.ktdsuniversity.edu.tmdb.mv.vo.MvVO;

public class PstrVO {

	private String pstrId;
	private String url;
	private String mvId;

	// 하나의 포스터는 하나의 영화를 위한 것이다.
	private MvVO mvVO;

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

	public MvVO getMvVO() {
		return this.mvVO;
	}
	public void setMvVO(MvVO mvVO) {
		this.mvVO = mvVO;
	}

	@Override
	public String toString() {
		return "PstrVO [pstrId=" + pstrId + ", url=" + url + ", mvId=" + mvId + "]";
	}

}
