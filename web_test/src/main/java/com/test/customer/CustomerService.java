package com.test.customer;

import java.util.List;

public class CustomerService {
	CustomerDAO dao = new CustomerDAO();
	
	// 회원 탈퇴
	public CustomerVO delete(String cId) {
		return dao.customerDelete(cId);
	}
	
	// 회원 정보수정
	public CustomerVO update(CustomerVO vo) {
		return dao.customerUpdate(vo);
	}
	
	// 회원 상세정보
	public CustomerVO searchOne(String cId) {
		return dao.customerSearch(cId);
	}
	
	// 회원 가입
	public CustomerVO insert(CustomerVO vo) {
		return dao.customerInsert(vo);
	}
	// 전체 회원
	public List<CustomerVO> searchAll(){
		return dao.customerList();
	}
	
	// 로그인
	public CustomerVO login(String cId, String cPw) {
		return dao.loginCheck(cId, cPw);
	}


}

