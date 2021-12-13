package com.test.product;

import java.util.List;

public class productService {
	ProductDAO dao = new ProductDAO();
	
	// 전체 상품 리스트
	public List<ProductVO> searchAll(){
		return dao.productList();
	}

}
