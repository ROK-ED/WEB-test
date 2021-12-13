package com.test.product;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.test.dao.DAO;

public class ProductDAO extends DAO {
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
