package com.test.comm;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.test.dao.DAO;

public class CommDAO extends DAO{
	
	public CommVO commInsert(CommVO vo) {
		String sql = "insert into comm(cmId, tId, cmContent, cId, cPw) values (?,?,?,?,?)";
		connect();
		
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, vo.getCmId());
			psmt.setInt(2, vo.gettId());
			psmt.setString(3, vo.getCmContent());
			psmt.setString(4, vo.getcId());
			psmt.setString(6, vo.getcPw());
			
			int r = psmt.executeUpdate();
			System.out.println(r+"건 등록");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		

		return vo;
	}
	
	//댓글 수정

	public CommVO commUpdate(CommVO vo) {
		String sql = "update comm "
				+ "set cmContent = ?"
				+ " tId = ?,"
				+ " cId = ?,"
				+ " cPw = ?,"
				+ " cmDate = ?"
				+ "where cmId = ?";
		connect();
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getCmContent());
			psmt.setInt(2, vo.gettId());
			psmt.setString(3, vo.getcId());
			psmt.setString(4, vo.getcPw());
			psmt.setString(5, vo.getCmDate());
			psmt.setInt(6, vo.getCmId());
			
			int r = psmt.executeUpdate();
			System.out.println(r +"건 삭제");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
		return vo;
	}
	
	
	//댓글 삭제
	public CommVO commDelete(int cmId) {
		CommVO vo = new CommVO();
		String sql = "delete from comm where cmId = ?";
		connect();
		
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, cmId);
			int r = psmt.executeUpdate();
			System.out.println(r+"건 삭제");
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}finally {
			disconnect();
		}
		return vo;
	}
	
	
	
	//댓글 전체조회
	public List<CommVO> commList() {
		List<CommVO> list = new ArrayList<>();
		String sql = "select * from comm order by 1";
		connect();
		
		try {
			stmt = conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			while(rs.next()) {
				CommVO vo = new CommVO();
				vo.setcId(rs.getString("cId"));
				vo.setCmContent(rs.getString("cmContent"));
				vo.setCmDate(rs.getString("cmDate "));
				vo.setCmId(rs.getInt("cmId "));
				vo.setcPw(rs.getString("cPw "));
				vo.settId(rs.getInt("tId"));
		
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return list;
	}
}
