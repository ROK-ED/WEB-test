package com.test.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.customer.CustomerService;
import com.test.customer.CustomerVO;

public class LoginController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String cId = req.getParameter("cId");
		String cPw = req.getParameter("cPw");
		
		CustomerService service = new CustomerService();
		CustomerVO vo = service.login(cId, cPw);
		
		HttpSession session = req.getSession();
		
		//if(vo != null) {
			//index.jsp
			session.setAttribute("cId", vo.getcId());
			session.setAttribute("cName", vo.getcName());
			session.setAttribute("authority", vo.getAuthority());
			
			req.getRequestDispatcher("index.jsp").forward(req, res);
		//}

	}

}