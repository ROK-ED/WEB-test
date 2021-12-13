package com.test.board;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


@WebServlet("/BoardServlet")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardServlet() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=UTF-8");
		
		JSONObject obj = new JSONObject();
		BoardDAO dao = new BoardDAO();
		
			List<BoardVO> list = dao.boardList();
			JSONArray ary = new JSONArray();
			for(BoardVO vo : list) {
				JSONObject ino = new JSONObject();
				ino.put("bId", vo.getbId());
				ino.put("cId", vo.getcId());
				ino.put("bDate", vo.getbDate());
				ino.put("bPw", vo.getbPw());
				ino.put("bTitle", vo.getbTitle());
				ino.put("bContent", vo.getbContent());
				
				ary.add(ino);
			}
			
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=UTF-8");
	}

}
