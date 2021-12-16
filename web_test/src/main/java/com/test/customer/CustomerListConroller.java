package com.test.customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.controller.Controller;

public class CustomerListConroller implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//db조회, 조회결과를 출력페이지 output.jsp
		CustomerService service = new CustomerService();
		List<CustomerVO> list = service.searchAll();
		
		req.setAttribute("customerList", list);
		
		req.getRequestDispatcher("customer/customerList.jsp").forward(req, res);

	}

}