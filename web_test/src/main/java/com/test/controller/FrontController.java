package com.test.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.board.boardDeleteConroller;
import com.test.board.boardInsertContoller;
import com.test.board.boardListConroller;
import com.test.board.boardSearchConroller;
import com.test.board.boardUpdateConroller;
import com.test.product.productDeleteConroller;
import com.test.product.productInsertContoller;
import com.test.product.productListConroller;
import com.test.product.productSearchConroller;
import com.test.product.productUpdateConroller;

public class FrontController extends HttpServlet {
	
	HashMap<String, Controller> list = null;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("controller init()");
		list = new HashMap<String, Controller>();
		
		//product
		list.put("/productInsert.do", new productInsertContoller());
		list.put("/productList.do", new productListConroller());
		list.put("/productSearch.do", new productSearchConroller());
		list.put("/productUpdate.do", new productUpdateConroller());
		list.put("/productDelete.do", new productDeleteConroller());
		//board
		list.put("/boardInsert.do", new boardInsertContoller());
		list.put("/boardList.do", new boardListConroller());
		list.put("/boardSearch.do", new boardSearchConroller());
		list.put("/boardUpdate.do", new boardUpdateConroller());
		list.put("/boardDelete.do", new boardDeleteConroller());
		
		//로그인
		list.put("/login.do", new LoginController());
		//로그아웃
		list.put("/logout.do", new LogoutController());
		
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI(); // http://localhost:80/P20211208/memberInsert.do
		String context = req.getContextPath();
		String path = url.substring(context.length());
		System.out.println(path);
		
		Controller subCon = list.get(path);
		subCon.execute(req, resp);
	}

}
