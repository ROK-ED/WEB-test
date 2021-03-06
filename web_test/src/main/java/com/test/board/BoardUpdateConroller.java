package com.test.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.controller.Controller;

public class BoardUpdateConroller implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String bId = req.getParameter("bId");
		String cId = req.getParameter("cId");
		String bDate = req.getParameter("bDate");
		String bPW = req.getParameter("bPw");
		String bTitle = req.getParameter("bTitle");
		String bContent = req.getParameter("bContent");
		
		BoardVO vo = new BoardVO();
		vo.setbContent(bContent);
		vo.setbDate(bDate);
		vo.setbId(Integer.parseInt(bId));
		vo.setbPw(bPW);
		vo.setbTitle(bTitle);
		vo.setcId(cId);
		
		BoardService service = new BoardService();
		service.update(vo);
		
		req.setAttribute("board", vo);
		req.getRequestDispatcher("board/boardSearch.jsp").forward(req, res);
		
	}

}
