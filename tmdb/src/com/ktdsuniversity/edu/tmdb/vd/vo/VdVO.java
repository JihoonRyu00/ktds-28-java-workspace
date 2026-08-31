package com.ktdsuniversity.edu.tmdb.vd.vo;

import com.ktdsuniversity.edu.tmdb.mv.vo.MvVO;

public class VdVO {

	private String vdId;
	private String url;
	private String mvId;

	// 하나의 영상은 하나의 영화를 위한 것이다.
	private MvVO mvVO;

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

	public MvVO getMvVO() {
		return this.mvVO;
	}
	public void setMvVO(MvVO mvVO) {
		this.mvVO = mvVO;
	}

	@Override
	public String toString() {
		return "VdVO [vdId=" + vdId + ", url=" + url + ", mvId=" + mvId + "]";
	}

}
