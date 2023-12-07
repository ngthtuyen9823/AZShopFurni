package com.azshop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.azshop.connection.DBConnection;
import com.azshop.dao.IOrderDAO;
import com.azshop.models.OrderModel;

public class OrderDAOImpl implements IOrderDAO {

	@Override
	public List<OrderModel> listOrder(int customerID) {
		List<OrderModel> listOrder = new ArrayList<OrderModel>();
		String sql = "SELECT O.CustomerID, P.ProductID, I.ItemID, O.OrderID, P.ProductName, I.Color, I.Size, D.Quantity, I.OriginalPrice, I.PromotionPrice, IM.Image, O.OrderDate, O.`Status`, O.Discount, O.TotalMoney\r\n"
				+ "FROM PRODUCT AS P INNER JOIN ITEM I ON P.ProductID = I.ProductID "
				+ "				  	INNER JOIN DETAIL D on I.ItemID = D.ItemID "
				+ "               	INNER JOIN `ORDER` O on O.OrderID = D.OrderID "
				+ "               	INNER JOIN (SELECT II.Image, IT.ItemID FROM ITEMIMAGE II, ITEM IT "
				+ "							  	WHERE II.ItemID = IT.ItemID LIMIT 1) IM ON IM.ItemID = I.ItemID "
				+ "WHERE O.CustomerID = ? ";
		try {
			new DBConnection();
			Connection conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, customerID);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				OrderModel order = new OrderModel();
				order.setCustomerID(rs.getInt(1));
				order.setProductID(rs.getInt(2));
				order.setItemID(rs.getInt(3));
				order.setOrderID(rs.getInt(4));
				order.setProductName(rs.getString(5));
				order.setColor(rs.getString(6));
				order.setSize(rs.getString(7));
				order.setQuantity(rs.getInt(8));
				order.setOriginalPrice(rs.getInt(9));
				order.setPromotionPrice(rs.getInt(10));
				order.setImage(rs.getString(11));
				order.setOrderDate(rs.getDate(12));
				order.setStatus(rs.getInt(13));
				order.setDiscount(rs.getInt(14));
				order.setTotalMoney(rs.getInt(15));
				
				listOrder.add(order);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listOrder;
	}

	@Override
	public void updateOrder(int orderID, int status) {
		String sql = "UPDATE `ORDER` SET Status = ? WHERE OrderID = ?";
		try {
			new DBConnection();
			Connection conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, status);
			ps.setInt(2, orderID);
			ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	

	@Override
	public void confirmOrder(int orderID, int confirm) {
		String sql = "UPDATE `ORDER` SET CustomerConfirmation = ? WHERE OrderID = ?";
		try {
			new DBConnection();
			Connection conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, confirm);
			ps.setInt(2, orderID);
			ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
