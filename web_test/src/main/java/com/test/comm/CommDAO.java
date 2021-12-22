package com.test.comm;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.test.dao.DAO;

public class CommDAO extends DAO{
	
	/*
	 * //1건조회 public CommVO commSearch(int cmId, int tId) { String sql =
	 * " select * from comm where cmId = ? and tId = ?"; connect();
	 * 
	 * try { psmt=conn.prepareStatement(sql); psmt.setInt(1, cmId); psmt.setInt(2,
	 * tId); rs=psmt.executeQuery(); if(rs.next()) { CommVO vo = new CommVO();
	 * vo.setcId(rs.getString("cId")); vo.setCmContent(rs.getString("cmContent"));
	 * vo.setCmDate(rs.getString("cmDate")); vo.setCmId(rs.getInt("cmId"));
	 * vo.setcPw(rs.getString("cPw")); vo.settId(rs.getInt("tId"));
	 * 
	 * return vo; }
	 * 
	 * } catch (SQLException e) {
	 * 
	 * e.printStackTrace(); } finally { disconnect(); }
	 * 
	 * 
	 * return null; }
	 */
	
	//댓글등록
	public CommVO commInsert(CommVO vo) {
		String sql_seq = "select comm_seq.nextval from comm";
		String sql = "insert into comm(cmId, tId, cmContent, cId, cPw) values (?,?,?,?,?)";
		connect();
		
		int seq = -1;
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql_seq);
			if(rs.next()) {
				seq=rs.getInt(1);
			}
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, seq);
			psmt.setInt(2, vo.gettId());
			psmt.setString(3, vo.getCmContent());
			psmt.setString(4, vo.getcId());
			psmt.setString(5, vo.getcPw());
			
			int r = psmt.executeUpdate();
			System.out.println(r+"건 등록");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return vo;
	}
	
	/*
	 * //댓글 수정
	 * 
	 * public CommVO commUpdate(CommVO vo) { String sql = "update comm " +
	 * "set cmContent = ?" + " tId = ?," + " cId = ?," + " cPw = ?," + " cmDate = ?"
	 * + "where cmId = ?"; connect();
	 * 
	 * try { psmt = conn.prepareStatement(sql); psmt.setString(1,
	 * vo.getCmContent()); psmt.setInt(2, vo.gettId()); psmt.setString(3,
	 * vo.getcId()); psmt.setString(4, vo.getcPw()); psmt.setString(5,
	 * vo.getCmDate()); psmt.setInt(6, vo.getCmId());
	 * 
	 * int r = psmt.executeUpdate(); System.out.println(r +"건 삭제");
	 * 
	 * } catch (SQLException e) { e.printStackTrace(); } finally { disconnect(); }
	 * 
	 * return vo; }
	 */
	
	
	//댓글 삭제
	public CommVO commDelete(int cmId, String cPw) {
		CommVO vo = new CommVO();
		String sql = "delete from comm where cmId = ? and cPw = ?";
		connect();
		
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, cmId);
			psmt.setString(2, cPw);
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
	public List<CommVO> commList(int tId) {
		List<CommVO> list = new ArrayList<>();
		String sql = "select * from comm where tId = ? order by 1";
		connect();
		
		try {
			psmt = conn.prepareStatement(sql);
			CommVO cmvo = new CommVO();
			psmt.setInt(1, tId);
			rs = psmt.executeQuery();
			while(rs.next()) {

				cmvo.setCmId(rs.getInt("cmId"));
				cmvo.settId(rs.getInt("tId"));
				cmvo.setCmContent(rs.getString("cmContent"));
				cmvo.setcId(rs.getString("cId"));
				cmvo.setcPw(rs.getString("cPw"));
				cmvo.setCmDate(rs.getString("cmDate"));
		
				list.add(cmvo);
			System.out.println(cmvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return list;
	}
}
