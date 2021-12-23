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
				  
		CommVO cmvo = new CommVO();
		
		cmvo.setcId(cId);
		cmvo.setCmContent(cmContent);
		// cmvo.setCmDate(cmDate); 
		cmvo.setcPw(cPw);
		 cmvo.settId(Integer.parseInt(tId));
		
		System.out.println(cmvo);
		System.out.println("여기는???");
		
		CommService cmService = new CommService();
		
		//상세 게시글 리스트
		
		BoardService bordService = new BoardService();
		BoardVO bordVo = bordService.search(Integer.parseInt(tId)); 
		
		req.setAttribute("board", bordVo);
		
		
		
		if (job.equals("insert")) {
			//댓글 등록
			cmService.insert(cmvo);
			req.setAttribute("comm", cmvo);
			
			//댓글 등록 후 댓글 리스트 
			List<CommVO> cmList = cmService.searchAll(Integer.parseInt(tId));
			req.setAttribute("commList", cmList);

			System.out.println(cmList);
			
			req.getRequestDispatcher("board/boardSearch.jsp").forward(req, res);

			
		}  else if (job.equals("delete")) {

			System.out.println("delete");
			req.setAttribute("comm", cmService.delete(Integer.parseInt(cmId), cPw));	
								
			//댓글 등록 후 댓글 리스트 
			List<CommVO> cmList = cmService.searchAll(Integer.parseInt(tId));
			req.setAttribute("commList", cmList);

			System.out.println(cmList);
			
			req.getRequestDispatcher("board/boardSearch.jsp").forward(req, res);
		}
		
	}
}
