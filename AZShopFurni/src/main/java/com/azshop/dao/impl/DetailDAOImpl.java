package com.azshop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.azshop.dao.IDetailDAO;
import com.azshop.models.DetailModel;

import com.azshop.connection.DBConnection;

public class DetailDAOImpl implements IDetailDAO {

	@Override
	public List<DetailModel> findDetailByProductID(int productID) {
		String sql = "SELECT\r\n" + "    d.ItemID,\r\n" + "    d.Content,\r\n" + "    d.Rating,\r\n"
				+ "    d.EvaluationDate,\r\n" + "    u.Avatar,\r\n"
				+ "    CONCAT(u.FirstName, ' ', u.LastName) AS Name\r\n" + "FROM\r\n" + "    DETAIL d\r\n" + "JOIN\r\n"
				+ "    AZShop.ORDER o ON d.OrderID = o.OrderID\r\n" + "JOIN\r\n"
				+ "    USER u ON u.UserID = o.CustomerID\r\n" + "JOIN ITEM i ON i.ItemID = d.ItemID\r\n"
				+ "WHERE i.ProductID=?;";
		List<DetailModel> listDetail = new ArrayList<>();
		try {
			new DBConnection();
			Connection conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, productID);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				DetailModel Detail = new DetailModel();
				Detail.setAvatar(rs.getString("Avatar"));
				Detail.setContent(rs.getString("Content"));
				Detail.setEvaluationDate(rs.getDate("EvaluationDate"));
				Detail.setItemID(rs.getInt("ItemID"));
				Detail.setRating(rs.getInt("Rating"));
				Detail.setName(rs.getString("Name"));
				listDetail.add(Detail);
			}
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return listDetail;
	}

	@Override
	public void updateDetail(DetailModel detail) {
		String sql = "UPDATE `DETAIL` SET Rating = ?, Content = ?, EvaluationDate = ? WHERE ItemID = ? AND OrderID = ?";
		try {
			new DBConnection();
			Connection conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, detail.getRating());
			ps.setString(2, detail.getContent());
			ps.setDate(3, new java.sql.Date(detail.getEvaluationDate().getTime()));
			ps.setInt(4, detail.getItemID());
			ps.setInt(5, detail.getOrderID());

			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
