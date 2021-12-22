package com.test.comm;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.board.BoardService;
import com.test.board.BoardVO;
import com.test.controller.Controller;

public class CommInsertController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		//댓글
		String cmId = req.getParameter("cmId");
		String tId = req.getParameter("tId");
		String cmContent = req.getParameter("cmContent");
		String cId = req.getParameter("cId");
		String cPw = req.getParameter("cPw");
		String cmDate = req.getParameter("cmDate");
		String job = req.getParameter("job");
		
		
		  System.out.println("tid:" + tId);
		  System.out.println("cmcontent:" + cmContent);
		  System.out.println("cmid:" + cmId);
		  System.out.println("cPw:" + cPw);
		  System.out.println("cmDate:" + cmDate);
		  System.out.println("tId:" + tId);
		 
		CommVO cmvo = new CommVO();
		CommService cmService = new CommService();
		List<CommVO> cmList = cmService.searchAll(Integer.parseInt(tId));
		
		
		cmvo.setCmId(Integer.parseInt(cmId));
		cmvo.setcId(cId);
		cmvo.setCmContent(cmContent);
		cmvo.setCmDate(cmDate);
		cmvo.setcPw(cPw);
		cmvo.settId(Integer.parseInt(tId));
		
		
	
		
		if (job.equals("insert")) {
			System.out.println("insert");
			req.setAttribute("commList", cmList);
			System.out.println(cmList);
			req.getRequestDispatcher("board/boardSearch.jsp").forward(req, res);

			
		}  else if (job.equals("delete")) {

			System.out.println("delete");
			req.setAttribute("comm", cmService.delete(Integer.parseInt(cmId), cPw));			
			List<CommVO> list = cmService.searchAll(Integer.parseInt(tId));
			req.setAttribute("commList", list);
			req.getRequestDispatcher("board/boardList.jsp").forward(req, res);
		}
		
	}
}
