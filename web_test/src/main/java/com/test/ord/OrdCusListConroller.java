package com.test.ord;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.controller.Controller;

public class OrdCusListConroller implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 값을 읽고 조회가능.
		String  cId = req.getParameter("cId");
		System.out.println(cId);
		OrdService service = new OrdService();
		List<OrdVO> list = service.searchCusAll(cId);
		
		req.setAttribute("ordCusList", list);
		
		req.getRequestDispatcher("ord/ordCusList.jsp").forward(req, res);
		
	}

}
