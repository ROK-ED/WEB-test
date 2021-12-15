package com.test.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.controller.Controller;

public class BoardSearchConroller implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		
		String job = req.getParameter("job");		
		String bId = req.getParameter("bId");
		System.out.println(bId);
		BoardService service = new BoardService();
		
		
		BoardVO vo = service.search(Integer.parseInt(bId)); 
		req.setAttribute("board", vo);
		System.out.println(vo.getbId()); 

		
		
		if (job.equals("search")) {
			System.out.println("search");
			req.getRequestDispatcher("board/boardSearch.jsp").forward(req, res);

		} else if (job.equals("update")) {
			req.getRequestDispatcher("board/boardDeleteForm.jsp").forward(req, res);


		} else if (job.equals("delete")) {

			req.getRequestDispatcher("board/boardDeleteForm.jsp").forward(req, res);

		}
		
	}

}
