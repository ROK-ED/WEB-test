package com.test.controller;





import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.board.BoardInsertContoller;
import com.test.board.BoardListConroller;
import com.test.board.BoardSearchConroller;

//import com.test.product.ProductDeleteConroller;

import com.test.board.BoardUpdateConroller;
import com.test.comm.CommInsertController;
import com.test.customer.CustomerInsertContoller;
import com.test.customer.CustomerListConroller;
import com.test.customer.CustomerSearchConroller;
import com.test.customer.CustomerUpdateConroller;
import com.test.ord.OrdCusListConroller;
import com.test.ord.OrdDeleteConroller;
import com.test.ord.OrdInsertConroller;
import com.test.ord.OrdListConroller;
import com.test.ord.OrdStateConroller;
import com.test.ord.OrdUpdateConroller;
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
		
		//ord
		list.put("/ordList.do", new OrdListConroller());
		list.put("/ordCustomerList.do", new OrdCusListConroller());
		list.put("/ordInsert.do", new OrdInsertConroller());
		list.put("/ordUpdate.do", new OrdUpdateConroller());
		list.put("/ordDelete.do", new OrdDeleteConroller());
		list.put("/ordState.do", new OrdStateConroller());
		
		//board
		list.put("/boardInsert.do", new BoardInsertContoller());
		list.put("/boardList.do", new BoardListConroller());
		list.put("/boardSearch.do", new BoardSearchConroller());
		list.put("/boardUpdate.do", new BoardUpdateConroller());
//		list.put("/boardDelete.do", new BoardDeleteConroller());
		
		//customer
		list.put("/customerInsert.do", new CustomerInsertContoller());
		list.put("/customerList.do", new CustomerListConroller());
		list.put("/customerSearch.do", new CustomerSearchConroller());
		list.put("/customerUpdate.do", new CustomerUpdateConroller());
		
		//comm
		list.put("/commInsert.do", new CommInsertController());
		
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