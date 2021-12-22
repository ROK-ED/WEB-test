package com.test.ord;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.test.dao.DAO;

public class OrdDAO extends DAO {
	// 발송완료
	public String stateOrd(String oId) {
		String sql = "UPDATE ord "
				+ "set oState = '발송완료' "
				+ "where oId = ?";
		connect();
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, oId);

			int r = psmt.executeUpdate();
			System.out.println(r + "건 발송");
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return oId;
	}
	
	// 장바구니 삭제
	public OrdVO deleteOrd(OrdVO vo) {
		String sqlProduct = "UPDATE product "//
				+ "set pCount = pCount + ? "//
				+ "where pId = ?";//
		String sql = "delete from ord where oId = ?";
		connect();
		
		try {			
			// 재고수량 수정
			psmt = conn.prepareStatement(sqlProduct);
			psmt.setInt(1, vo.getoCount());
			psmt.setString(2, vo.getpId());
			int rP = psmt.executeUpdate();
			System.out.println(rP + "건 변경.");

			// 장바구니 변경
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getoId());

			int r = psmt.executeUpdate();
			System.out.println(r + "건 삭제.");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return vo;
	}
	// 구매 수량 수정
	public OrdVO updateOrd(OrdVO vo) {
		String sqlBefore = "SELECT oCount "//
				+ "FROM ord "//
				+ "where oId = ?";
		String sqlCount = "select pCount + ? - ? "//
				+ "from product "//
				+ "where pId = ?";
		String sqlProduct = "UPDATE product "//
				+ "set pCount = pCount + ? - ?"//
				+ "where pId = ?";//
		String sql = "UPDATE ord "//
				+ "set oCount = ? "//
				+ "where oId = ?";
		connect();
		
		try {
			//장바구니 기존 수량 불러오기
			psmt = conn.prepareStatement(sqlBefore);
			psmt.setInt(1, vo.getoId());
			rs = psmt.executeQuery();
			int rBC = 0;
			if (rs.next()) {
				rBC = rs.getInt(1);		
			}
			System.out.println("기존구매 : " + rBC);
			
			//재고파악
			psmt = conn.prepareStatement(sqlCount);
			psmt.setInt(1, rBC);
			psmt.setInt(2, vo.getoCount());
			psmt.setString(3, vo.getpId());
			rs = psmt.executeQuery();
			int rC = 0;
			if (rs.next()) {
				rC = rs.getInt(1);		
			}
			System.out.println(sqlCount);
			System.out.println(vo.getoCount());
			System.out.println(vo.getpId());
			System.out.println("재고수량 : " + rC);

			if (rC > 0) {

				// 재고수량 수정
				psmt = conn.prepareStatement(sqlProduct);
				psmt.setInt(1, rBC);
				psmt.setInt(2, vo.getoCount());
				psmt.setString(3, vo.getpId());
				int rP = psmt.executeUpdate();
				System.out.println(rP + "건 변경.");

				// 장바구니 변경
				psmt = conn.prepareStatement(sql);
				psmt.setInt(1, vo.getoCount());
				psmt.setInt(2, vo.getoId());

				int r = psmt.executeUpdate();
				System.out.println(r + "건 변경.");
			} else {
				JOptionPane.showMessageDialog(null, "재고가 부족합니다.");
				return null;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return vo;
		
		
		
		
	}
	// 장바구니 등록
	public OrdVO insertOrd(OrdVO vo) {
		String sqlCount = "select pCount - ? "//
				+ "from product "//
				+ "where pId = ?";
		String sqlProduct = "UPDATE product "//
				+ "set pCount = pCount - ?"//
				+ "where pId = ?";//
		String sql = "INSERT INTO ord(oId, pId, oCount, cId)"//
				+ "VALUES             (ord_oId_seq.NEXTVAL, ?, ?, ?)";
		connect();

		try {
			//재고파악
			psmt = conn.prepareStatement(sqlCount);
			psmt.setInt(1, vo.getoCount());
			psmt.setString(2, vo.getpId());
			rs = psmt.executeQuery();
			int rC = 0;
			if (rs.next()) {
				rC = rs.getInt(1);		
			}
			System.out.println(sqlCount);
			System.out.println(vo.getoCount());
			System.out.println(vo.getpId());
			System.out.println("재고수량 : " + rC);

			if (rC > 0) {

				// 재고수량 수정
				psmt = conn.prepareStatement(sqlProduct);
				psmt.setInt(1, vo.getoCount());
				psmt.setString(2, vo.getpId());
				int rP = psmt.executeUpdate();
				System.out.println(rP + "건 변경.");

				// 장바구니 등록
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, vo.getpId());
				psmt.setInt(2, vo.getoCount());
				psmt.setString(3, vo.getcId());

				int r = psmt.executeUpdate();
				System.out.println(r + "건 입력.");
			} else {
				JOptionPane.showMessageDialog(null, "재고가 부족합니다.");
				return null;
			}

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
		String sql = "select*from ord where cid = ? order by 6 desc";
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
		String sql = "select * from ord order by 6 desc";
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
