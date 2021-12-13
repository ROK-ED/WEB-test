package com.test.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.controller.Controller;

public class ProductInsertContoller implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//사용자 입력 정보 -> 서비스 -> dao -> 결과리턴. -> memverOutput.jsp
		
		String pId = req.getParameter("pId");
		String pName = req.getParameter("pName");
		String originPrice = req.getParameter("originPrice");
		String salePrice = req.getParameter("salePrice");
		String pContent = req.getParameter("pContent");
		String pImage = req.getParameter("pImage");
		String review = req.getParameter("review");

		ProductVO vo = new ProductVO();
		vo.setpId(pId);
		vo.setpName(pName);
		vo.setOriginPrice(Integer.parseInt(originPrice));
		vo.setSalePrice(Integer.parseInt(salePrice));
		vo.setpContent(pContent);
		vo.setpImage(pImage);
		vo.setReview(Double.parseDouble(review));
		
		//입력처리
		ProductService service = new ProductService();
		
		service.insert(vo);
		
		req.setAttribute("product", vo);
		
		req.getRequestDispatcher("product/productInput.jsp").forward(req, res);
		
	}

}
