package com.test.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
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

//		//이미지 1.request 2.저장위치 3.maxSize 4.UTF-8 5.리네임정책
//		int maxSize = 30 * 1024 * 1024;
//		String encoding = "UTF-8";
//		MultipartRequest mRequset = new MultipartRequest(req, "/upload", maxSize, encoding, new DefaultFileRenamePolicy());
		
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
