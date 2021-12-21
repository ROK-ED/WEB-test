package com.test.ord;

import java.util.List;

public class OrdService {
	OrdDAO dao = new OrdDAO();

	// 발송완료
	public String status(String oId) {
		return dao.stateOrd(oId);
	}

	// 장바구니 삭제
	public OrdVO delete(OrdVO vo) {
		return dao.deleteOrd(vo);
	}

	// 구매 수량 수정
	public OrdVO update(OrdVO vo) {
		return dao.updateOrd(vo);
	}

	// 장바구니 등록
	public OrdVO insert(OrdVO vo) {
		return dao.insertOrd(vo);
	}

	// 회원 장바구니
	public List<OrdVO> searchCusAll(String cId) {
		return dao.ordCusList(cId);
	}

	// 전체 장바구니
	public List<OrdVO> searchAll() {
		return dao.ordList();
	}

}
