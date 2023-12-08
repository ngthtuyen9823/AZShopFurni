package com.azshop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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
	public DetailModel getOneDetail(int id) {
		return null;
	}

	@Override
	public boolean insertDetail(DetailModel detail) {
//		String sql = "INSERT INTO `AZShop`.`Detail` (`UserID`, `UserName`, `Password`) VALUES (?, ?,?);";
//		try {
//			new DBConnection();
//			Connection conn = DBConnection.getConnection();
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.setInt(1, Detail.getUserID());
//			ps.setString(2, Detail.getUserName());
//			ps.setString(3, Detail.getPassword());
//			ps.executeUpdate();
//			conn.close();
//		} catch (Exception e) {
//			System.out.println(e);
//			return false;
//		}
//		return true;
		return false;
	}

	public static void main(String[] args) {
		// Test the DetailDAOImpl methods
		DetailDAOImpl DetailDAO = new DetailDAOImpl();

		// Delete
//		DetailDAO.delete(100001, 10100101);

		// Insert
//		DetailModel newDetail = new DetailModel();
//		newDetail.setCustomerID(100001);
//		newDetail.setItemID(10100101);
//		newDetail.setQuantity(3);
//		DetailDAO.insert(newDetail);

		// Update
//		DetailModel existingDetail = DetailDAO.findOne(100001, 10100101);
//		if (existingDetail != null) {
//			existingDetail.setQuantity(existingDetail.getQuantity() + 1);
//			DetailDAO.update(existingDetail);
//		}
//
//		// FindOne
//		DetailModel foundDetail = DetailDAO.findOne(100001, 10100101);
//		if (foundDetail != null) {
//			System.out.println("Found Detail: " + foundDetail.getCustomerID() + ", " + foundDetail.getItemID() + ", "
//					+ foundDetail.getQuantity());
//		} else {
//			System.out.println("Detail not found.");
//		}

//		// FindAll
		/*
		 * System.out.println("All Details:"); for (DetailModel Detail :
		 * DetailDAO.getAllDetail()) { System.out.println(Detail); }
		 */
	}
}
