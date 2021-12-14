package com.test.product;

import java.util.List;

public class ProductService {
	ProductDAO dao = new ProductDAO();
	
	// 상품 상세정보
	public ProductVO searchOne(String pId) {
		return dao.productSearch(pId);
	}
	
	// 상품 등록
	public ProductVO insert(ProductVO vo) {
		return dao.productInsert(vo);
	}
	
	// 전체 상품 리스트
	public List<ProductVO> searchAll(){
		return dao.productList();
	}

}
