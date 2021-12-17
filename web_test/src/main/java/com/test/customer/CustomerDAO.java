package com.test.customer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.test.dao.DAO;

public class CustomerDAO extends DAO {
	// 회원 탈퇴
	public CustomerVO customerDelete(String cId) {
		CustomerVO vo = customerSearch(cId);

		String sql = "delete from customer where cId = ?";
		connect();

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, cId);

			int r = psmt.executeUpdate();
			System.out.println(r + "건 삭제.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return vo;

	}

	// 회원 정보수정
	public CustomerVO customerUpdate(CustomerVO vo) {
		String sql = "update customer "//
				+ "set cPw = ?,"//
				+ "adr = ?,"//
				+ "phone = ?,"//
				+ "email = ?"//
				+ "where cId = ?";
		connect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getcPw());
			psmt.setString(2, vo.getAdr());
			psmt.setString(3, vo.getPhone());
			psmt.setString(4, vo.getEmail());
			psmt.setString(5, vo.getcId());

			int r = psmt.executeUpdate();
			System.out.println(r + "건 변경");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return vo;
	}

	// 회원 상세정보
	public CustomerVO customerSearch(String cId) {
		String sql = "select * from customer where cId = ?";
		connect();

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, cId);
			rs = psmt.executeQuery();
			if (rs.next()) {
				CustomerVO vo = new CustomerVO();
				vo.setcId(rs.getString("cId"));
				vo.setcPw(rs.getString("cPw"));
				vo.setcName(rs.getString("cName"));
				vo.setAdr(rs.getString("adr"));
				vo.setPhone(rs.getString("phone"));
				vo.setEmail(rs.getString("email"));
				vo.setcDate(rs.getString("cDate"));
				vo.setAuthority(rs.getString("authority"));
				System.out.println(vo.getAuthority());
				return vo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}

	// 회원 가입
	public CustomerVO customerInsert(CustomerVO vo) {
		String sql = "insert into customer(cId, cPw, cName, adr, phone, email, authority) values(?,?,?,?,?,?,?)";
		connect();

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getcId());
			psmt.setString(2, vo.getcPw());
			psmt.setString(3, vo.getcName());
			psmt.setString(4, vo.getAdr());
			psmt.setString(5, vo.getPhone());
			psmt.setString(6, vo.getEmail());
			psmt.setString(7, vo.getAuthority());

			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return vo;
	}

	// 전체 회원
	public List<CustomerVO> customerList() {
		List<CustomerVO> list = new ArrayList<>();
		String sql = "select * from customer order by 1 desc";
		connect();

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				CustomerVO vo = new CustomerVO();
				vo.setcId(rs.getString("cId"));
				vo.setcPw(rs.getString("cPw"));
				vo.setcName(rs.getString("cName"));
				vo.setAdr(rs.getString("adr"));
				vo.setPhone(rs.getString("phone"));
				vo.setEmail(rs.getString("email"));
				vo.setcDate(rs.getString("cDate"));
				vo.setAuthority(rs.getString("authority"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	// 로그인 체크
	public CustomerVO loginCheck(String cId, String cPw) {
		String sql = "select * from customer where cId=? and cPw=?";
		connect();

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, cId);
			psmt.setString(2, cPw);
			rs = psmt.executeQuery();
			if (rs.next()) {
				CustomerVO vo = new CustomerVO();
				vo.setcId(rs.getString("cId"));
				vo.setcPw(rs.getString("cPw"));
				vo.setcName(rs.getString("cName"));
				vo.setAdr(rs.getString("adr"));
				vo.setPhone(rs.getString("phone"));
				vo.setEmail(rs.getString("email"));
				vo.setcDate(rs.getString("cDate"));
				vo.setAuthority(rs.getString("authority"));
				System.out.println(vo.getAuthority());
				return vo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}


}

