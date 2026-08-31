package com.ktdsuniversity.edu.tmdb.gnr.vo;

import java.util.List;

import com.ktdsuniversity.edu.tmdb.mv.vo.MvVO;

public class GnrVO {

	private String gnrId;
	private String nm;

	private List<MvVO> mvList;

	public String getGnrId() {
		return this.gnrId;
	}
	public void setGnrId(String gnrId) {
		this.gnrId = gnrId;
	}
	public String getNm() {
		return this.nm;
	}
	public void setNm(String nm) {
		this.nm = nm;
	}

	public List<MvVO> getMvList() {
		return this.mvList;
	}
	public void setMvList(List<MvVO> mvList) {
		this.mvList = mvList;
	}

	@Override
	public String toString() {
		return "GnrVO [gnrId=" + gnrId + ", nm=" + nm + "]";
	}

}
