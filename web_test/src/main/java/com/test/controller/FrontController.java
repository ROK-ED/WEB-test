package com.test.controller;


import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.board.BoardDeleteConroller;
import com.test.board.BoardInsertContoller;
import com.test.board.BoardListConroller;
import com.test.board.BoardSearchConroller;
//import com.test.product.ProductDeleteConroller;
import com.test.product.ProductInsertContoller;
import com.test.product.ProductListConroller;
import com.test.product.ProductSearchConroller;
import com.test.product.ProductUpdateConroller;

public class FrontController extends HttpServlet {
	
	HashMap<String, Controller> list = null;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("controller init()");
		list = new HashMap<String, Controller>();
		
		//product
		list.put("/productInsert.do", new ProductInsertContoller());
		list.put("/productList.do", new ProductListConroller());
		list.put("/productSearch.do", new ProductSearchConroller());
		list.put("/productUpdate.do", new ProductUpdateConroller());
		//list.put("/productDelete.do", new ProductDeleteConroller());
		
		//board
		list.put("/boardInsert.do", new BoardInsertContoller());
		list.put("/boardList.do", new BoardListConroller());
		list.put("/boardSearch.do", new BoardSearchConroller());
		list.put("/boardUpdate.do", new BoardUpdateConroller());
		list.put("/boardDelete.do", new BoardDeleteConroller());
		
		//로그인
		list.put("/login.do", new LoginController());

		//로그아웃
		list.put("/logout.do", new LogoutController());
		
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI();
		String context = req.getContextPath();
		String path = url.substring(context.length());
		System.out.println(path);
		
		Controller subCon = list.get(path);
		subCon.execute(req, resp);
	}

}
