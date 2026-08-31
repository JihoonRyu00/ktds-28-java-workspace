package com.ktdsuniversity.edu.tmdb.flmmkr.vo;

import com.ktdsuniversity.edu.tmdb.invlvd.vo.InvlvdVO;
import com.ktdsuniversity.edu.tmdb.mv.vo.MvVO;

public class FlmmkrVO {

	private String flmmkrId;
	private String invlvdId;
	private String mvId;
	private String prt;
	private String rl;

	// 한 명의 참여자가 하나의 영화를 제작했다.
	private MvVO mvVO;
	// 제작자의 정보
	private InvlvdVO invlvdVO;

	public String getFlmmkrId() {
		return this.flmmkrId;
	}
	public void setFlmmkrId(String flmmkrId) {
		this.flmmkrId = flmmkrId;
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
	public String getPrt() {
		return this.prt;
	}
	public void setPrt(String prt) {
		this.prt = prt;
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
		return "FlmmkrVO [flmmkrId=" + flmmkrId + ", invlvdId=" + invlvdId + ", mvId=" + mvId + ", prt=" + prt + ", rl="
				+ rl + "]";
	}

}
