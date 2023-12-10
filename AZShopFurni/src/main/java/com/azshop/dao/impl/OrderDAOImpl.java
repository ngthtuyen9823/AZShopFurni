package com.azshop.dao.impl;

import java.sql.Connection;
import java.sql.Date;
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
	Connection conn = null;

	@Override
	public List<OrderModel> listOrderByCustomerID(int customerID) {
		List<OrderModel> listOrder = new ArrayList<OrderModel>();
		String sql = "SELECT O.OrderID, O.CustomerID, O.OrderDate, O.`Status`, O.CustomerConfirmation, O.Discount, O.TotalMoney, O.SellerID, O.ShipperID, O.TransportFee "
				+ "FROM `ORDER` O " + "WHERE O.CustomerID = ?";
		try {
			new DBConnection();
			conn = DBConnection.getConnection();
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
			conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, status);
			ps.setInt(2, orderID);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void confirmOrder(int orderID, int confirm) {
		String sql = "UPDATE `ORDER` SET CustomerConfirmation = ? WHERE OrderID = ?";
		try {
			new DBConnection();
			conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, confirm);
			ps.setInt(2, orderID);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public OrderModel getOrderByOrderID(int orderID) {
		OrderModel order = new OrderModel();
		String sql = "SELECT O.OrderID, O.CustomerID, O.OrderDate, O.`Status`, O.CustomerConfirmation, O.Discount, O.TotalMoney, O.SellerID, O.ShipperID, O.TransportFee "
				+ "FROM `ORDER` O " + "WHERE O.OrderID = ?";
		try {
			new DBConnection();
			conn = DBConnection.getConnection();
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

	@Override
	public OrderModel insertOrder(OrderModel order) {
		String sql = "INSERT INTO AZShop.ORDER " + "(OrderDate, Address, City, Status, TransportFee, "
				+ "Discount, TotalMoney, Note, DeliveryTime, CustomerConfirmation, CustomerID) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

		System.out.println(sql);

		try {
			new DBConnection();
			conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDate(1, new java.sql.Date(order.getOrderDate().getTime()));
			ps.setString(2, order.getAddress());
			ps.setString(3, order.getCity());
			ps.setInt(4, order.getStatus());
			ps.setInt(5, order.getTransportFee());
			ps.setInt(6, order.getDiscount());
			ps.setInt(7, order.getTotalMoney());
			ps.setString(8, order.getNote());
			ps.setDate(9, (Date) order.getDeliveryTime());
			ps.setInt(10, order.getCustomerConfirmation());
			ps.setInt(11, order.getCustomerID());
			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return this.getLastOrderOfCustomer(order.getCustomerID());
	}

	private OrderModel getLastOrderOfCustomer(int customerId) {
		OrderModel order = new OrderModel();
		String sql = "SELECT O.OrderID, O.CustomerID, O.OrderDate, O.`Status`, O.CustomerConfirmation, O.Discount, O.TotalMoney, O.SellerID, O.ShipperID, O.TransportFee "
				+ "FROM `ORDER` O " + "WHERE O.CustomerID = ? ORDER BY OrderID DESC LIMIT 1";
		try {
			new DBConnection();
			conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, customerId);
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
