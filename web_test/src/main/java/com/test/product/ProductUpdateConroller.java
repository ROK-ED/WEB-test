package com.test.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.test.controller.Controller;

public class ProductUpdateConroller implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 수정작업 => 결과.jsp
		
		// 이미지 1.request 2.저장위치 3.maxSize 4.UTF-8 5.리네임정책
		String saveUrl = req.getRealPath("/upload");
		int maxSize = 30 * 1024 * 1024;
		String encoding = "UTF-8";
		MultipartRequest mRequset = new MultipartRequest(req, saveUrl, maxSize, encoding,
				new DefaultFileRenamePolicy());

		// 사용자 입력 정보 -> 서비스 -> dao -> 결과리턴. -> memverOutput.jsp
		String pId = mRequset.getParameter("pId");
		String pName = mRequset.getParameter("pName");
		String originPrice = mRequset.getParameter("originPrice");
		String salePrice = mRequset.getParameter("salePrice");
		String pCount = mRequset.getParameter("pCount");
		String pContent = mRequset.getParameter("pContent");
		String pImage = mRequset.getFilesystemName("pImage");
		String review = mRequset.getParameter("review");

		ProductVO vo = new ProductVO();
		vo.setpId(pId);
		vo.setpName(pName);
		vo.setOriginPrice(Integer.parseInt(originPrice));
		vo.setSalePrice(Integer.parseInt(salePrice));
		vo.setpCount(Integer.parseInt(pCount));
		vo.setpContent(pContent);
		vo.setpImage(pImage);
		vo.setReview(Double.parseDouble(review));
		
		//수정작업DAO, Service
		ProductService service = new ProductService();
		service.update(vo);
		
		req.setAttribute("product", vo);
		
//		req.setAttribute("pId", pId);
//		req.setAttribute("pName", pName);
//		req.setAttribute("originPrice", originPrice);
//		req.setAttribute("salePrice", salePrice);
//		req.setAttribute("pCount", pCount);
//		req.setAttribute("pContent", pContent);
//		req.setAttribute("pImage", pImage);
//		req.setAttribute("review", review);
		
		req.getRequestDispatcher("product/productSearchOutPut.jsp").forward(req, res);

	}

}
