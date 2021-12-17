package com.test.customer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.controller.Controller;

public class CustomerUpdateConroller implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 수정작업 => 결과.jsp
		// 사용자 입력 정보 -> 서비스 -> dao -> 결과리턴. -> customerOutput.jsp
		String cId = req.getParameter("cId"); // 아이디
		String cPw = req.getParameter("cPw"); // 비밀번호
		String cName = req.getParameter("cName"); // 이름
		String adr = req.getParameter("adr"); // 주소
		String phone = req.getParameter("phone"); // 전화번호
		String email = req.getParameter("email"); // 이메일
		String cDate = req.getParameter("cDate");//가입일
		String authority = req.getParameter("authority"); // 권한
		
		CustomerVO vo = new CustomerVO();
		vo.setcId(cId);
		vo.setcPw(cPw);
		vo.setcName(cName);
		vo.setAdr(adr);
		vo.setPhone(phone);
		vo.setEmail(email);
		vo.setcDate(cDate);
		vo.setAuthority(authority);
		
		//수정작업DAO, Service
		CustomerService service = new CustomerService();

		service.update(vo);

		req.setAttribute("customer", vo);
		
		req.getRequestDispatcher("customer/customerSearchOutPut.jsp").forward(req, res);

	}

}
