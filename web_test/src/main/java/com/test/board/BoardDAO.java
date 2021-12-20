package com.test.board;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.test.dao.DAO;

public class BoardDAO extends DAO{
	//게시글 수정
	public BoardVO boardUpdate(BoardVO vo) {
		String sql = "update board "
				+ " set bTitle = ?,"
				+ " bContent = ?"
				+ " where bId = ?";
		
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, vo.getbTitle());
			psmt.setString(2, vo.getbContent());
			psmt.setInt(3, vo.getbId());
			
			int r = psmt.executeUpdate();
			System.out.println(r+"건 변경");
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			disconnect();
		}
		
		
		return vo;
	}
	
	
	
	//게시글 상세
	public BoardVO boardSearch(int bId) {
		String sql = "select * from board where bId = ?";
		connect();
		
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, bId);
			rs=psmt.executeQuery();
			if(rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setbContent(rs.getString("bContent"));
				vo.setbDate(rs.getString("bDate"));
				vo.setbId(rs.getInt("bId"));
				vo.setbPw(rs.getString("bPw"));
				vo.setbTitle(rs.getString("bTitle"));
				vo.setcId(rs.getString("cId"));
				
				return vo;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
		return null;
	}
	
	
	//게시글 삭제
	public BoardVO boardDelete(int bId) {
		BoardVO vo = new BoardVO();
		String sql = "delete from board where bId = ?";
		connect();
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, bId);
			int r = psmt.executeUpdate();
			System.out.println(r+"건 삭제");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
		
		return vo;
	}
	
	
	//게시판 등록
   public BoardVO boardInsert(BoardVO vo) {
	   String sql_seq = "select board_seq.nextval from board";
	   String sql = "insert into board(bId, cId, bPw, bTitle, bContent) values(?,?,?,?,?)";
	   connect();
	   
	   int seq = -1;
	   try {
		   stmt=conn.createStatement();
		   rs= stmt.executeQuery(sql_seq);
		   if(rs.next()) {
			   seq= rs.getInt(1);
		   }

		psmt = conn.prepareStatement(sql);
		psmt.setInt(1, seq);
		psmt.setString(2, vo.getcId());
		psmt.setString(3, vo.getbPw());
		psmt.setString(4, vo.getbTitle());
		psmt.setString(5, vo.getbContent());
		
		int r = psmt.executeUpdate();
		System.out.println(r+"건입력");
		
	} catch (SQLException e) {
		e.printStackTrace();
	}	finally {
		disconnect();
	}
	   
	   
	   return vo;
   }
	
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
