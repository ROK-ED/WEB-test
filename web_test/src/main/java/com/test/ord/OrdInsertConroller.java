package com.test.ord;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.controller.Controller;

public class OrdInsertConroller implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 사용자 입력 정보 -> 서비스 -> dao -> 결과리턴.
		String pId = req.getParameter("pId");//상품번호
		String oCount = req.getParameter("oCount");//구매수량
		String cId = req.getParameter("cId"); // 아이디

		OrdVO vo = new OrdVO();
		vo.setpId(pId);
		vo.setoCount(Integer.parseInt(oCount));
		vo.setcId(cId);
		
		//입력처리
		OrdService service = new OrdService();
		service.insert(vo);
		System.out.println("insert");
		req.setAttribute("ord", vo);
		
		//입력후 회원 장바구니로
		
		System.out.println(cId);
		OrdService serviceCusList = new OrdService();
		List<OrdVO> list = serviceCusList.searchCusAll(cId);
		
		req.setAttribute("ordCusList", list);
		
		res.sendRedirect("ordCustomerList.do");
		//req.getRequestDispatcher("ordCustomerList.do").forward(req, res);
		
	}

}
