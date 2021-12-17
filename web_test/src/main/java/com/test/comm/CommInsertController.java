package com.test.comm;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.controller.Controller;

public class CommInsertController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String cmId = req.getParameter("cmId");
		String tId = req.getParameter("tId");
		String cmContent = req.getParameter("cmContent");
		String cId = req.getParameter("cId");
		String cPw = req.getParameter("cPw");
		String cmDate = req.getParameter("cmDate");
		
		CommVO cmvo = new CommVO();
		cmvo.setcId(cId);
		cmvo.setCmContent(cmContent);
		cmvo.setCmDate(cmDate);
		cmvo.setCmId(Integer.parseInt(cmId));
		cmvo.setcPw(cPw);
		cmvo.settId(Integer.parseInt(tId));
		
		CommService cmService = new CommService();
		cmService.insert(cmvo);
		
		System.out.println(cmvo);
		req.setAttribute("comm", cmvo);
		req.getRequestDispatcher("board/boardSearch.jsp").forward(req, res);

	}

}
