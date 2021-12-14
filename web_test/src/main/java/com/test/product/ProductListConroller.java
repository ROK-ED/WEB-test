package com.test.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.controller.Controller;

public class ProductListConroller implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//db조회, 조회결과를 출력페이지 output.jsp
		ProductService service = new ProductService();
		List<ProductVO> list = service.searchAll();
		
		req.setAttribute("productList", list);
		
		
		req.getRequestDispatcher("product/productList.jsp").forward(req, res);
	}

}
