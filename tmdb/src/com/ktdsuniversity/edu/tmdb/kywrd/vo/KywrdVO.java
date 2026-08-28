package com.ktdsuniversity.edu.tmdb.kywrd.vo;

public class KywrdVO {

	private String kywrdId;
	private String kywrd;

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

	@Override
	public String toString() {
		return "KywrdVO [kywrdId=" + kywrdId + ", kywrd=" + kywrd + "]";
	}

}
