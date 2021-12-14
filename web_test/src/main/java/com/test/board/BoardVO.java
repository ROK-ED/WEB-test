package com.test.board;

public class BoardVO { //테이블 VO
	private int bId;
	private String cId;
	private String bDate;
	private String bPw;
	private String bTitle;
	private String bContent;
	
	public int getbId() {
		return bId;
	}
	public void setbId(int bId) {
		this.bId = bId;
	}
	public String getcId() {
		return cId;
	}
	public void setcId(String cId) {
		this.cId = cId;
	}
	public String getbDate() {
		return bDate;
	}
	public void setbDate(String bDate) {
		this.bDate = bDate;
	}
	public String getbPw() {
		return bPw;
	}
	public void setbPw(String bPw) {
		this.bPw = bPw;
	}
	public String getbTitle() {
		return bTitle;
	}
	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}
	public String getbContent() {
		return bContent;
	}
	public void setbContent(String bContent) {
		this.bContent = bContent;
	}
	@Override
	public String toString() {
		return "BoardVO [bId=" + bId + ", cId=" + cId + ", bDate=" + bDate + ", bPw=" + bPw + ", bTitle=" + bTitle
				+ ", bContent=" + bContent + "]";
	}
	


	
}
