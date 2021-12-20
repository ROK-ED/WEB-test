package com.test.ord;

import java.util.List;

public class OrdService {
	OrdDAO dao = new OrdDAO();
	
	// 장바구니 등록
		public OrdVO insert(OrdVO vo) {
			return dao.insertOrd(vo);
		}
	
	// 회원 장바구니
		public List<OrdVO> searchCusAll(String cId){
			return dao.ordCusList(cId);
		}
	
	// 전체 장바구니
		public List<OrdVO> searchAll(){
			return dao.ordList();
		}

}
