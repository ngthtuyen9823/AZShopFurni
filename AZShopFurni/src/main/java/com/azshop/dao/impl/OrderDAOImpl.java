package com.azshop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.azshop.connection.DBConnection;
import com.azshop.dao.IDetailDAO;
import com.azshop.dao.IOrderDAO;
import com.azshop.models.OrderModel;

public class OrderDAOImpl implements IOrderDAO {

	IDetailDAO detailDAO = new DetailDAOImpl();
	@Override
	public List<OrderModel> listOrderByCustomerID(int customerID) {
		List<OrderModel> listOrder = new ArrayList<OrderModel>();
		String sql =  "SELECT O.OrderID, O.CustomerID, O.OrderDate, O.`Status`, O.CustomerConfirmation, O.Discount, O.TotalMoney, O.SellerID, O.ShipperID, O.TransportFee "
					+ "FROM `ORDER` O "
					+ "WHERE O.CustomerID = ?";
		try {
			new DBConnection();
			Connection conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, customerID);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				OrderModel order = new OrderModel();
				order.setOrderID(rs.getInt(1));
				order.setCustomerID(rs.getInt(2));
				order.setOrderDate(rs.getDate(3));
				order.setStatus(rs.getInt(4));
				order.setCustomerConfirmation(rs.getInt(5));
				order.setDiscount(rs.getInt(6));
				order.setTotalMoney(rs.getInt(7));
				order.setSellerID(rs.getInt(8));
				order.setShipperID(rs.getInt(9));
				order.setTransportFee(rs.getInt(10));
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

	@Override
	public OrderModel getOrderByOrderID(int orderID) {
		OrderModel order = new OrderModel();
		String sql =  "SELECT O.OrderID, O.CustomerID, O.OrderDate, O.`Status`, O.CustomerConfirmation, O.Discount, O.TotalMoney, O.SellerID, O.ShipperID, O.TransportFee "
					+ "FROM `ORDER` O "
					+ "WHERE O.OrderID = ?";
		try {
			new DBConnection();
			Connection conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, orderID);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				order.setOrderID(rs.getInt(1));
				order.setCustomerID(rs.getInt(2));
				order.setOrderDate(rs.getDate(3));
				order.setStatus(rs.getInt(4));
				order.setCustomerConfirmation(rs.getInt(5));
				order.setDiscount(rs.getInt(6));
				order.setTotalMoney(rs.getInt(7));
				order.setSellerID(rs.getInt(8));
				order.setShipperID(rs.getInt(9));
				order.setTransportFee(rs.getInt(10));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return order;
	}
}
