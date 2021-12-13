package com.test.product;

import java.util.List;

public class ProductService {
	ProductDAO dao = new ProductDAO();
	
	// 전체 상품 리스트
	public List<ProductVO> searchAll(){
		return dao.productList();
	}

}
