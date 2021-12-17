package com.test.customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.controller.Controller;
import com.test.product.ProductService;
import com.test.product.ProductVO;

public class CustomerInsertContoller implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 사용자 입력 정보 -> 서비스 -> dao -> 결과리턴. -> customerOutput.jsp
		String cId = req.getParameter("cId"); // 아이디
		String cPw = req.getParameter("cPw"); // 비밀번호
		String cName = req.getParameter("cName"); // 이름
		String adr = req.getParameter("adr"); // 주소
		String phone = req.getParameter("phone"); // 전화번호
		String email = req.getParameter("email"); // 이메일
		String authority = req.getParameter("authority"); // 권한

		CustomerVO vo = new CustomerVO();
		vo.setcId(cId);
		vo.setcPw(cPw);
		vo.setcName(cName);
		vo.setAdr(adr);
		vo.setPhone(phone);
		vo.setEmail(email);
		vo.setAuthority(authority);

		// 입력처리
		CustomerService service = new CustomerService();

		service.insert(vo);

		req.setAttribute("customer", vo);

		// 가입 후 전체 리스트로
		ProductService serviceProduct = new ProductService();
		List<ProductVO> list = serviceProduct.searchAll();

		req.setAttribute("productList", list);
		
		req.getRequestDispatcher("product/productList.jsp").forward(req, res);

	}

}