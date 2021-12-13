package com.test.board;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.test.dao.DAO;

public class BoardDAO extends DAO{
 
	//삭제  고객ID , 게시글 비밀번호 같아야 삭제가능.
//	public   
	
	//전체 조회
	public List<BoardVO> boardList(){
	
		
		List<BoardVO> list = new ArrayList<>();
		String sql ="select * from board order by 1";
		connect();
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setbId(rs.getInt("bId"));
				vo.setcId(rs.getString("cId"));
				vo.setbDate(rs.getString("bDate"));
				vo.setbPw(rs.getString("bPw"));
				vo.setbTitle(rs.getString("bTitle"));
				vo.setbContent(rs.getString("bContent"));
				
				list.add(vo);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
	
}
