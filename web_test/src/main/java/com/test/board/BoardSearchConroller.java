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
		System.out.println(vo.getbId()); 

		//댓글
		CommService cmService = new CommService();
		List<CommVO> cmList = cmService.searchAll();
		req.setAttribute("commList", cmList);
		
		
		if (job.equals("search")) {
			System.out.println("search");
			req.setAttribute("commList", cmList);
			req.getRequestDispatcher("board/boardSearch.jsp").forward(req, res);

		} else if (job.equals("update")) {
			System.out.println("update");
			req.getRequestDispatcher("board/boardUpdate.jsp").forward(req, res);


		} else if (job.equals("delete")) {
			System.out.println("delete");
			req.setAttribute("board", service.delete(Integer.parseInt(bId)));
			List<BoardVO> list = service.searchAll();
			req.getRequestDispatcher("board/boardList.jsp").forward(req, res);
		}
		
		
		//댓글
		CommVO cmvo = new CommVO();
		
		
		String job_c = req.getParameter("job_c");
		
		
		String cmId = req.getParameter("cmId");
		String tId = req.getParameter("tId");
		String cmContent = req.getParameter("cmContent");
		String cId = req.getParameter("cId");
		String cPw = req.getParameter("cPw");
		String cmDate = req.getParameter("cmDate");
		
//		if(job_c.equals("insert")) {
//			System.out.println("insert");
//			req.setAttribute("comm", cmService.insert(cmvo));
//			req.getRequestDispatcher("board/boardSearch.jsp").forward(req, res);
//			
//		} else if(job_c.equals("update")) {
//			System.out.println("update");
//			req.setAttribute("comm", cmService.update(cmvo));
//			req.getRequestDispatcher("board/boardSearch.jsp").forward(req, res);
//		} else if(job_c.equals("delete")) {
//			System.out.println("delete");
//			req.setAttribute("comm", cmService.delete(Integer.parseInt(cmId)));
//			req.getRequestDispatcher("board/boardSearch.jsp").forward(req, res);
//		}

		
		
		
	}

}
