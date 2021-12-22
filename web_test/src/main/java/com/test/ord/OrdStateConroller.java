package com.test.ord;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.controller.Controller;

public class OrdStateConroller implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 사용자 입력 정보 -> 서비스 -> dao -> 결과리턴.
		String oId = req.getParameter("oId");// 장바구니 번호
		
		OrdVO vo = new OrdVO();
		vo.setoId(Integer.parseInt(oId));
		
		// 발송수정
		OrdService service = new OrdService();
		service.status(oId);
		req.setAttribute("ord", vo);
		
		// 발송수정후 전체 리스트로
		OrdService serviceList = new OrdService();
		List<OrdVO> list = serviceList.searchAll();
		
		req.setAttribute("ordList", list);
		
		req.getRequestDispatcher("ord/ordList.jsp").forward(req, res);
		
	}

}
