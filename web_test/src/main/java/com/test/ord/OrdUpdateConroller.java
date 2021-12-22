package com.test.ord;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.controller.Controller;



public class OrdUpdateConroller implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 사용자 입력 정보 -> 서비스 -> dao -> 결과리턴.
		String oId = req.getParameter("oId");//장바구니 번호
		String pId = req.getParameter("pId");//상품번호
		String oCount = req.getParameter("oCount");//구매수량
		
		
		OrdVO vo = new OrdVO();
		vo.setoId(Integer.parseInt(oId)); 
		vo.setpId(pId);
		vo.setoCount(Integer.parseInt(oCount));
		
		//수정처리
		OrdService service = new OrdService();
		service.update(vo);
		System.out.println("update");
		req.setAttribute("ord", vo);
		
		//수정후 회원 장바구니로
		HttpSession seCid = req.getSession();
		System.out.println(seCid.getAttribute("cId"));
		String cId =(String)seCid.getAttribute("cId");
		
		System.out.println(cId);
		OrdService serviceCusList = new OrdService();
		List<OrdVO> list = serviceCusList.searchCusAll(cId);
		
		req.setAttribute("ordCusList", list);
		
		res.sendRedirect("ordCustomerList.do");

	}

}
