package com.test.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.controller.Controller;

public class ProductSearchConroller implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 값을 읽고 조회가능.
		// search 조회페이지, update 수정페이지, delete 삭제페이지
		String pId = req.getParameter("pId");
		String job = req.getParameter("job");
		System.out.println(pId);
		ProductService service = new ProductService();
		
		ProductVO vo = service.searchOne(pId);
		System.out.println(vo.getpName());
		
		req.setAttribute("product", vo);
		
		if (job.equals("search")) {
			System.out.println("search");
						
			req.getRequestDispatcher("product/productSearchOutPut.jsp").forward(req, res);

		} else if (job.equals("update")) {
			System.out.println("update");

			req.getRequestDispatcher("product/productUpdateForm.jsp").forward(req, res);

		} else if (job.equals("delete")) {
			System.out.println("delete");
			//req.getRequestDispatcher("product/productDeleteForm.jsp").forward(req, res);

		}
		

	}

}
