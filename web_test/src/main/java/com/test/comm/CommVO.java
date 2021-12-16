package com.test.comm;

public class CommVO {
	private int cmId;
	private int tId;
	private String cmContent;
	private String cId;
	private String cPw;
	private String cmDate;
	
	public int getCmId() {
		return cmId;
	}
	public void setCmId(int cmId) {
		this.cmId = cmId;
	}
	public int gettId() {
		return tId;
	}
	public void settId(int tId) {
		this.tId = tId;
	}
	public String getCmContent() {
		return cmContent;
	}
	public void setCmContent(String cmContent) {
		this.cmContent = cmContent;
	}
	public String getcId() {
		return cId;
	}
	public void setcId(String cId) {
		this.cId = cId;
	}
	public String getcPw() {
		return cPw;
	}
	public void setcPw(String cPw) {
		this.cPw = cPw;
	}
	public String getCmDate() {
		return cmDate;
	}
	public void setCmDate(String cmDate) {
		this.cmDate = cmDate;
	}
	
	@Override
	public String toString() {
		return "CommVO [cmId=" + cmId + ", tId=" + tId + ", cmContent=" + cmContent + ", cId=" + cId + ", cPw=" + cPw
				+ ", cmDate=" + cmDate + "]";
	}

}
