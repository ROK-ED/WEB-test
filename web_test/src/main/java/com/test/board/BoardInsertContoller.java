package com.test.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.controller.Controller;

public class BoardInsertContoller implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String bId = req.getParameter("bId");
		String cId = req.getParameter("cId");
		String bDate = req.getParameter("bDate");
		String bPw = req.getParameter("bPw");
		String bTitle = req.getParameter("bTitle");
		String bContent = req.getParameter("bContent");
		
		
		BoardVO vo = new BoardVO();
		vo.setbContent(bContent);
		vo.setbDate(bDate);
		vo.setbId(Integer.parseInt(bId));
		vo.setbPw(bPw);
		vo.setbTitle(bTitle);
		vo.setcId(cId);
		
		
		//입력
		BoardService service = new BoardService();
		service.insert(vo);
		
		req.setAttribute("board", vo);
		//
		List<BoardVO> list = service.searchAll();
		req.setAttribute("boardList", list);
		
		req.getRequestDispatcher("board/boardList.jsp").forward(req, res);
		
	}

}
