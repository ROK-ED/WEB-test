package com.test.board;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.comm.CommService;
import com.test.comm.CommVO;
import com.test.controller.Controller;

public class BoardSearchConroller implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		//게시글
		String job = req.getParameter("job");		
		String bId = req.getParameter("bId");
		String bPw = req.getParameter("bPw");
		String bTitle = req.getParameter("bTitle");
		String bContent = req.getParameter("bContent");
		//게시판
		BoardService service = new BoardService();
		BoardVO vo = service.search(Integer.parseInt(bId)); 
		
		req.setAttribute("board", vo); 

		//댓글
		String tId = bId;
		String cmId = req.getParameter("cmId");
		String cmContent = req.getParameter("cmContent");
		String cId = req.getParameter("cId");
		String cPw = req.getParameter("cPw");
		String cmDate = req.getParameter("cmDate");
		
		
		CommVO cmvo = new CommVO();
		CommService cmService = new CommService();
		List<CommVO> cmList = cmService.searchAll(Integer.parseInt(tId));
		
		
		if (job.equals("search")) {
			System.out.println("search");
			req.setAttribute("commList", cmList);
			System.out.println(cmList);
			req.getRequestDispatcher("board/boardSearch.jsp").forward(req, res);

			
		} else if (job.equals("update")) {
			System.out.println("update");
			req.setAttribute("comm", cmList);
			req.getRequestDispatcher("board/boardUpdate.jsp").forward(req, res);

		} else if (job.equals("delete")) {
			
			System.out.println("delete");
			
			req.setAttribute("board", service.delete(Integer.parseInt(bId)));
			
			List<BoardVO> list = service.searchAll();
			
			req.setAttribute("boardList", list);
			req.getRequestDispatcher("board/boardList.jsp").forward(req, res);
		}
		
	}
}
