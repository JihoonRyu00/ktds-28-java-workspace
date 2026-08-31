package com.ktdsuniversity.edu.tmdb.kywrd.vo;

import java.util.List;

import com.ktdsuniversity.edu.tmdb.mv.vo.MvVO;

public class KywrdVO {

	private String kywrdId;
	private String kywrd;

	private List<MvVO> mvList;

	public String getKywrdId() {
		return this.kywrdId;
	}
	public void setKywrdId(String kywrdId) {
		this.kywrdId = kywrdId;
	}
	public String getKywrd() {
		return this.kywrd;
	}
	public void setKywrd(String kywrd) {
		this.kywrd = kywrd;
	}

	public List<MvVO> getMvList() {
		return this.mvList;
	}
	public void setMvList(List<MvVO> mvList) {
		this.mvList = mvList;
	}

	@Override
	public String toString() {
		return "KywrdVO [kywrdId=" + kywrdId + ", kywrd=" + kywrd + "]";
	}

}
