package com.test.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.controller.Controller;

public class BoardListConroller implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html;charset=utf-8");
		
		BoardService service = new BoardService();
		List<BoardVO> list = service.searchAll();
		
		req.setAttribute("boardList", list);
		
		
		req.getRequestDispatcher("board/boardList.jsp").forward(req, res);
		
		
		
	}

}
