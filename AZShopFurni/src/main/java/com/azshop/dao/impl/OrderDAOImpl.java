package com.azshop.dao.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.azshop.connection.DBConnection;
import com.azshop.dao.IDetailDAO;
import com.azshop.dao.IOrderDAO;
import com.azshop.models.OrderModel;
import com.azshop.service.impl.OrderServiceImpl;

public class OrderDAOImpl implements IOrderDAO {

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
	public void updateOrder(OrderModel order) {
		String sql = "UPDATE `AZShop`.`ORDER` SET `OrderDate` = ? , `Address` = ? , `Status` = ? ,"
				+ " `TransportFee` = ? , `Discount` = ? , `TotalMoney` = ? , `Note` = ? , `DeliveryTime` = ? ,"
				+ " `CustomerConfirmation` = ? , `CustomerID` = ? , `SellerID` = ? , `ShipperID` = ? "
				+ " WHERE (`OrderID` = ? )";
		try {
			new DBConnection();
			Connection conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);

			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			ps.setString(1, formatter.format(order.getOrderDate()));
			ps.setString(2, order.getAddress());
			ps.setInt(3, order.getStatus());
			ps.setInt(4, order.getTransportFee());
			ps.setInt(5, order.getDiscount());
			ps.setInt(6, order.getTotalMoney());
			ps.setString(7, order.getNote());
			ps.setString(8, formatter.format(order.getDeliveryTime()));
			ps.setInt(9, order.getCustomerConfirmation());
			ps.setInt(10, order.getCustomerID());
			ps.setInt(11, order.getSellerID());
			ps.setInt(12, order.getShipperID());
			ps.setInt(13, order.getOrderID());

			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
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
		} catch (Exception e) {
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

	@Override
	public List<OrderModel> findNeedShipByArea(String area) {
		String condition = " WHERE o.Status = 3 AND ShipperID IS NULL AND ?;";
		return findDeliveryByCondition(condition, 1);
	}
	
	@Override
	public List<OrderModel> findShipingByShipperID(int ShipperID) {
		String condition ="	WHERE o.Status = 3 AND ShipperID = ?";
		return findDeliveryByCondition(condition, ShipperID);
	}
	
	@Override
	public List<OrderModel> findHisDeliveryByShipperID(int ShipperID) {
		String condition ="	WHERE (o.Status = 4 OR o.Status = 5) AND ShipperID = ? "
				+ "ORDER BY o.DeliveryTime DESC";
		return findDeliveryByCondition(condition, ShipperID);
	}
	
	@Override
	public OrderModel findShipByID(int OrderID) {
		String condition ="	WHERE o.OrderID = " +OrderID+" AND ?" ;
		return findDeliveryByCondition(condition, 1).get(0);
	}

	
	private final String sqltemp = "SELECT o.*, FirstName, LastName, Phone, \r\n"
			+ "	   p.Method, p.Status as PayStatus\r\n" + "	   FROM AZShop.ORDER as o\r\n"
			+ "    LEFT JOIN AZShop.PAYMENT as p ON o.OrderID = p.OrderID\r\n"
			+ "    INNER JOIN USER as c ON  o.CustomerID = c.UserID\r\n";

	private List<OrderModel> findDeliveryByCondition(String condition, int ShipperID) {
		List<OrderModel> listOrder = new ArrayList<OrderModel>();
		String sql = sqltemp + condition;
		try {
			new DBConnection();
			Connection conn;
			conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, ShipperID);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				OrderModel order = new OrderModel();
				order.setOrderID(rs.getInt("OrderID"));
				order.setOrderDate(rs.getDate("OrderDate"));
				order.setAddress(rs.getString("Address"));
				order.setStatus(rs.getInt("Status"));
				order.setTransportFee(rs.getInt("TransportFee"));
				order.setTotalMoney(rs.getInt("TotalMoney"));
				order.setNote(rs.getString("Note"));
				order.setDeliveryTime(rs.getDate("DeliveryTime"));
				order.setCustomerConfirmation(rs.getInt("CustomerConfirmation"));
				// order.setDiscount(rs.getInt("Discount"));
				order.setCustomerID(rs.getInt("CustomerID"));
				order.setSellerID(rs.getInt("SellerID"));
				order.setShipperID(rs.getInt("ShipperID"));
				order.getCustomer().setFirstName(rs.getString("FirstName"));
				order.getCustomer().setLastName(rs.getString("LastName"));
				order.getCustomer().setPhone(rs.getString("Phone"));
				order.getPayment().setMethod(rs.getInt("Method"));
				order.getPayment().setStatus(rs.getInt("PayStatus"));
				listOrder.add(order);
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return listOrder;
	}

	public static void main(String[] args) {
		//new OrderServiceImpl().findHisDeliveryByShipperID(120001).forEach(order -> System.out.println(order));
		System.out.println(new OrderServiceImpl()
				.findShipByID(1));
	}
}
