package com.test.customer;

public class CustomerVO {
	private String cId; // 아이디
	private String cPw; // 비밀번호
	private String cName; // 이름
	private String adr; // 주소
	private String phone; // 전화번호
	private String email; // 이메일
	private String cDate; // 가입일
	private String authority; // 권한

	public CustomerVO(String cId, String cPw, String cName, String adr, String phone, String email, String cDate,
			String authority) {
		super();
		this.cId = cId;
		this.cPw = cPw;
		this.cName = cName;
		this.adr = adr;
		this.phone = phone;
		this.email = email;
		this.cDate = cDate;
		this.authority = authority;
	}

	public CustomerVO() {

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

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getAdr() {
		return adr;
	}

	public void setAdr(String adr) {
		this.adr = adr;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getcDate() {
		return cDate;
	}

	public void setcDate(String cDate) {
		this.cDate = cDate;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	@Override
	public String toString() {
		return "CustomerVO [cId=" + cId + ", cPw=" + cPw + ", cName=" + cName + ", adr=" + adr + ", phone=" + phone
				+ ", email=" + email + ", cDate=" + cDate + ", authority=" + authority + "]";
	}

}