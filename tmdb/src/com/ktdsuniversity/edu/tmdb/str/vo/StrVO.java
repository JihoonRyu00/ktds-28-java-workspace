package com.ktdsuniversity.edu.tmdb.str.vo;

import com.ktdsuniversity.edu.tmdb.invlvd.vo.InvlvdVO;
import com.ktdsuniversity.edu.tmdb.mv.vo.MvVO;

public class StrVO {

	private String strId;
	private String invlvdId;
	private String mvId;
	private String rl;

	// 한 명의 출연자가 하나의 영화를 제작했다.
	private MvVO mvVO;
	// 출연자의 정보
	private InvlvdVO invlvdVO;

	public String getStrId() {
		return this.strId;
	}
	public void setStrId(String strId) {
		this.strId = strId;
	}
	public String getInvlvdId() {
		return this.invlvdId;
	}
	public void setInvlvdId(String invlvdId) {
		this.invlvdId = invlvdId;
	}
	public String getMvId() {
		return this.mvId;
	}
	public void setMvId(String mvId) {
		this.mvId = mvId;
	}
	public String getRl() {
		return this.rl;
	}
	public void setRl(String rl) {
		this.rl = rl;
	}

	public MvVO getMvVO() {
		return this.mvVO;
	}
	public void setMvVO(MvVO mvVO) {
		this.mvVO = mvVO;
	}
	public InvlvdVO getInvlvdVO() {
		return this.invlvdVO;
	}
	public void setInvlvdVO(InvlvdVO invlvdVO) {
		this.invlvdVO = invlvdVO;
	}

	@Override
	public String toString() {
		return "StrVO [strId=" + strId + ", invlvdId=" + invlvdId + ", mvId=" + mvId + ", rl=" + rl + "]";
	}

}
