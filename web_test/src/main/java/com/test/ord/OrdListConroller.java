package com.test.ord;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.controller.Controller;

public class OrdListConroller implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//db조회, 조회결과를 출력페이지 output.jsp
		OrdService service = new OrdService();
		List<OrdVO> list = service.searchAll();
		
		req.setAttribute("ordList", list);
		
		req.getRequestDispatcher("ord/ordList.jsp").forward(req, res);
	}

}
