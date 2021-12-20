package com.test.ord;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.test.dao.DAO;

public class OrdDAO extends DAO {
	// 장바구니 등록
	public OrdVO insertOrd(OrdVO vo) {
		String sql = "INSERT INTO ord(oId, pId, oCount, cId)"
				+ "VALUES             (ord_oId_seq.NEXTVAL, ?, ?, ?)";
		connect();
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getpId());
			psmt.setInt(2, vo.getoCount());
			psmt.setString(3, vo.getcId());
			
			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return vo;
		
	}

	// 회원 장바구니
	public List<OrdVO> ordCusList(String cId) {
		List<OrdVO> list = new ArrayList<>();
		String sql = "select*from ord where cid = ? order by 1 desc";
		connect();

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, cId);
			rs = psmt.executeQuery();
			while (rs.next()) {
				OrdVO vo = new OrdVO();
				vo.setoId(rs.getInt("oId"));
				vo.setpId(rs.getString("pId"));
				vo.setoCount(rs.getInt("oCount"));
				vo.setcId(rs.getString("cId"));
				vo.setoDate(rs.getString("oDate"));
				vo.setoState(rs.getString("oState"));
				list.add(vo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;

	}

	// 전체 장바구니
	public List<OrdVO> ordList() {
		List<OrdVO> list = new ArrayList<OrdVO>();
		String sql = "select * from ord order by 1 desc";
		connect();

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				OrdVO vo = new OrdVO();
				vo.setoId(rs.getInt("oId"));
				vo.setpId(rs.getString("pId"));
				vo.setoCount(rs.getInt("oCount"));
				vo.setcId(rs.getString("cId"));
				vo.setoDate(rs.getString("oDate"));
				vo.setoState(rs.getString("oState"));
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
