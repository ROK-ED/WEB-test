package com.test.product;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.test.dao.DAO;

public class ProductDAO extends DAO {
	// 상품 등록
	public ProductVO productInsert(ProductVO vo) {
		String sql = "insert into product values(?,?,?,?,?,?,?)";
		connect();

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getpId());
			psmt.setString(2, vo.getpName());
			psmt.setInt(3, vo.getOriginPrice());
			psmt.setInt(4, vo.getSalePrice());
			psmt.setString(5, vo.getpContent());
			psmt.setString(6, vo.getpImage());
			psmt.setDouble(7, vo.getReview());

			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력");
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			disconnect();
		}
		return vo;

	}

	// 전체 상품 리스트
	public List<ProductVO> productList() {
		List<ProductVO> list = new ArrayList<>();
		String sql = "select * from product order by 1 desc";
		connect();

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				ProductVO vo = new ProductVO();
				vo.setpId(rs.getString("pId"));
				vo.setpName(rs.getString("pName"));
				vo.setOriginPrice(rs.getInt("originPrice"));
				vo.setSalePrice(rs.getInt("salePrice"));
				vo.setpContent(rs.getString("pContent"));
				vo.setpImage(rs.getString("pImage"));
				vo.setReview(rs.getDouble("review"));

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
