package com.test.ord;

public class OrdVO {

	private int oId;// 장바구니 번호
	private String pId;// 상품번호
	private int oCount;// 구매수량
	private String cId;// 고객아이디
	private String oDate;// 장바구니등록일
	private String oState;// 상태

	public OrdVO(int oId, String pId, int oCount, String cId, String oDate, String oState) {
		this.oId = oId;
		this.pId = pId;
		this.oCount = oCount;
		this.cId = cId;
		this.oDate = oDate;
		this.oState = oState;
	}

	public OrdVO() {

	}

	public int getoId() {
		return oId;
	}

	public void setoId(int oId) {
		this.oId = oId;
	}

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public int getoCount() {
		return oCount;
	}

	public void setoCount(int oCount) {
		this.oCount = oCount;
	}

	public String getcId() {
		return cId;
	}

	public void setcId(String cId) {
		this.cId = cId;
	}

	public String getoDate() {
		return oDate;
	}

	public void setoDate(String oDate) {
		this.oDate = oDate;
	}

	public String getoState() {
		return oState;
	}

	public void setoState(String oState) {
		this.oState = oState;
	}

	@Override
	public String toString() {
		return "OrdVO [oId=" + oId + ", pId=" + pId + ", oCount=" + oCount + ", cId=" + cId + ", oDate=" + oDate
				+ ", oState=" + oState + "]";
	}

}
