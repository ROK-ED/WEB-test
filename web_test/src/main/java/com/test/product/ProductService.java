package com.test.product;

import java.util.List;

public class ProductService {
	ProductDAO dao = new ProductDAO();
	
	// 상품 등록
	public ProductVO insert(ProductVO vo) {
		return dao.productInsert(vo);
	}
	
	// 전체 상품 리스트
	public List<ProductVO> searchAll(){
		return dao.productList();
	}

}
