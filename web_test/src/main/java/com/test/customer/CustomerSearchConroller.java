package com.test.customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.controller.Controller;


public class CustomerSearchConroller implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 값을 읽고 조회가능.
		// search 조회페이지, update 수정페이지, delete 삭제페이지
		String cId = req.getParameter("cId");
		String job = req.getParameter("job");
		System.out.println(cId);
		CustomerService service = new CustomerService();
		
		CustomerVO vo = service.searchOne(cId);
		
		req.setAttribute("customer", vo);
		
		if (job.equals("search")) {
			System.out.println("search");
			req.getRequestDispatcher("customer/customerSearchOutPut.jsp").forward(req, res);

		} else if (job.equals("update")) {
			System.out.println("update");


		} else if (job.equals("delete")) {
			System.out.println("delete");
//			// 삭제
//			req.setAttribute("product", service.delete(pId));
//			
//			// 삭제 후 전체 리스트로
//			List<ProductVO> list = service.searchAll();
//			
//			req.setAttribute("productList", list);
//			
//			req.getRequestDispatcher("product/productList.jsp").forward(req, res);

		}
		
		
	}

}