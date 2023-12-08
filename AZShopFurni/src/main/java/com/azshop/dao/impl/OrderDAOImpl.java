package com.azshop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.azshop.connection.DBConnection;
import com.azshop.dao.IOrderDAO;
import com.azshop.models.OrderModel;
import com.azshop.models.PaymentModel;
import com.azshop.models.UserModel;

public class OrderDAOImpl implements IOrderDAO {

	@Override
	public void updateOrder(OrderModel order) {
		String sql = "UPDATE `AZShop`.`ORDER` SET `OrderDate` = ? , `Address` = ? , `Status` = ? , `TransportFee` = ? , `Discount` = ? , `TotalMoney` = ? , `Note` = ? , `DeliveryTime` = ? , `CustomerConfirmation` = ? , `CustomerID` = ? , `SellerID` = ? , `ShipperID` = ? WHERE (`OrderID` = ? )";
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
	public List<OrderModel> findAllOrder() {
		List<OrderModel> listOrder = new ArrayList<OrderModel>();
		String sql = "SELECT DISTINCT k.*,p.* " + "FROM PAYMENT AS p " + "INNER JOIN ( "
				+ "    SELECT DISTINCT o.*, c.FirstName AS FirstNameCustomer, c.LastName AS LastNameCustomer, c.Phone AS PhoneCustomer, c.CID AS CIDCustomer, "
				+ "		 c.Email AS EmailCustomer,  c.DoB AS DoBCustomer, c.Address AS AddressCustomer, "
				+ "        se.FirstName AS FirstNameSeller, se.LastName AS LastNameSeller, se.Phone AS PhoneSeller, se.CID AS CIDSeller, "
				+ "		 se.Email AS EmailSeller, "
				+ "        sh.FirstName AS FirstNameShipper, sh.LastName AS LastNameShipper, sh.Phone AS PhoneShipper, sh.CID AS CIDShipper, "
				+ "		 sh.Email AS EmailShipper " + "    FROM AZShop.`ORDER` o " + "    LEFT JOIN ( "
				+ "        SELECT DISTINCT USER.UserID, USER.FirstName, USER.LastName , USER.Phone, USER.CID, USER.Email, USER.DoB, USER.Address "
				+ "        FROM AZShop.`ORDER` " + "        INNER JOIN USER ON `ORDER`.CustomerID = USER.UserID "
				+ "    ) AS c ON o.CustomerID = c.UserID " + "    LEFT JOIN ( "
				+ "        SELECT DISTINCT USER.UserID, USER.FirstName, USER.LastName, USER.Phone, USER.CID, USER.Email "
				+ "        FROM AZShop.`ORDER` " + "        INNER JOIN USER ON `ORDER`.SellerID = USER.UserID "
				+ "    ) AS se ON o.SellerID = se.UserID " + "    LEFT JOIN ( "
				+ "        SELECT DISTINCT USER.UserID, USER.FirstName, USER.LastName, USER.Phone, USER.CID, USER.Email "
				+ "        FROM AZShop.`ORDER` " + "        INNER JOIN USER ON `ORDER`.ShipperID = USER.UserID "
				+ "    ) AS sh ON o.ShipperID = sh.UserID " + ") AS k ON p.OrderID = k.OrderID;";
		try {
			new DBConnection();
			Connection conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				OrderModel order = new OrderModel();
				UserModel customer = new UserModel();
				UserModel seller = new UserModel();
				UserModel shipper = new UserModel();
				PaymentModel pay = new PaymentModel();
				order.setOrderID(rs.getInt("OrderID"));
				order.setOrderDate(rs.getDate("OrderDate"));
				order.setAddress(rs.getString("Address"));
				order.setStatus(rs.getInt(4));
				order.setTransportFee(rs.getInt("TransportFee"));
				order.setDiscount(rs.getInt("Discount"));
				order.setTotalMoney(rs.getInt("TotalMoney"));
				order.setNote(rs.getString("Note"));
				order.setDeliveryTime(rs.getDate("DeliveryTime"));
				order.setCustomerConfirmation(rs.getInt("CustomerConfirmation"));
				order.setCustomerID(rs.getInt("CustomerID"));
				order.setSellerID(rs.getInt("SellerID"));
				order.setShipperID(rs.getInt("ShipperID"));

				customer.setLastName(rs.getString("LastNameCustomer"));
				customer.setFirstName(rs.getString("FirstNameCustomer"));
				customer.setCid(rs.getString("CIDCustomer"));
				customer.setPhone(rs.getString("PhoneCustomer"));
				customer.setEmail(rs.getString("EmailCustomer"));
				customer.setAddress(rs.getString("AddressCustomer"));
				customer.setDob(rs.getDate("DoBCustomer"));

				seller.setLastName(rs.getString("LastNameSeller"));
				seller.setFirstName(rs.getString("FirstNameSeller"));
				seller.setCid(rs.getString("CIDSeller"));
				seller.setPhone(rs.getString("PhoneSeller"));
				seller.setEmail(rs.getString("EmailSeller"));

				shipper.setLastName(rs.getString("LastNameShipper"));
				shipper.setFirstName(rs.getString("FirstNameShipper"));
				shipper.setCid(rs.getString("CIDShipper"));
				shipper.setPhone(rs.getString("PhoneShipper"));
				shipper.setEmail(rs.getString("EmailShipper"));

				pay.setOrderID(rs.getInt("OrderID"));
				pay.setMethod(rs.getInt("Method"));
				pay.setBank(rs.getString("Bank"));
				pay.setTime(rs.getTimestamp("Time"));
				pay.setCardOwner(rs.getString("CardOwner"));
				pay.setAccountNumber(rs.getString("AccountNumber"));
				pay.setStatus(rs.getInt(37));

				order.setCustomer(customer);
				order.setSeller(seller);
				order.setShipper(shipper);
				order.setPayment(pay);
				listOrder.add(order);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listOrder;
	}

	@Override
	public void deleteOrder(int orderID) {
		String sql = "DELETE FROM `AZShop`.`ORDER` WHERE (`OrderID` = ? )";
		try {
			new DBConnection();
			Connection conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, orderID);
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<OrderModel> listOrderByCustomerID(int customerID) {
		List<OrderModel> listOrder = new ArrayList<OrderModel>();
		String sql = "SELECT O.OrderID, O.CustomerID, O.OrderDate, O.`Status`, O.Discount, O.TotalMoney, O.SellerID, O.ShipperID "
				+ "FROM `ORDER` O " + "WHERE O.CustomerID = ?";
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
				order.setDiscount(rs.getInt(5));
				order.setTotalMoney(rs.getInt(6));
				order.setSellerID(rs.getInt(7));
				order.setShipperID(rs.getInt(8));
				listOrder.add(order);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listOrder;
	}

	@Override
	public void confirmOrder(int orderID, int confirm) {
		// TODO Auto-generated method stub

	}

	@Override
	public OrderModel getOrderByOrderID(int orderID) {
		OrderModel order = new OrderModel();
		String sql = "SELECT o.*, FirstName, LastName, Phone,	   p.Method, p.Status as PayStatus    "
				+ " FROM AZShop.ORDER as o   LEFT JOIN PAYMENT as p ON o.OrderID = p.OrderID INNER JOIN USER as c ON  o.CustomerID = c.UserID  "
				+ " WHERE o.OrderID=?";
		try {
			new DBConnection();
			Connection conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, orderID);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				order.setOrderID(rs.getInt("OrderID"));
				order.setOrderDate(rs.getDate("OrderDate"));
				order.setAddress(rs.getString("Address"));
				order.setStatus(rs.getInt("Status"));
				order.setTransportFee(rs.getInt("TransportFee"));
				order.setTotalMoney(rs.getInt("TotalMoney"));
				order.setNote(rs.getString("Note"));
				// order.setDiscount(rs.getInt("Discount"));
				// order.setCustomerID(rs.getInt("CustomerID"));
				order.setSellerID(rs.getInt("SellerID"));
				order.setShipperID(rs.getInt("ShipperID"));
				order.getCustomer().setFirstName(rs.getString("FirstName"));
				order.getCustomer().setLastName(rs.getString("LastName"));
				// order.getCustomer().setPhone(rs.getString("Phone"));
				order.getPayment().setMethod(rs.getInt("Method"));
				order.getPayment().setStatus(rs.getInt("PayStatus"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return order;
	}

	@Override
	public List<OrderModel> findHisOrder(int sellerID) {
		List<OrderModel> listOrder = new ArrayList<OrderModel>();
		String sql = "SELECT o.*, FirstName, LastName, Phone, " + "	   p.Method, p.Status as PayStatus "
				+ "	   FROM AZShop.ORDER as o " + "    LEFT JOIN PAYMENT as p ON o.OrderID = p.OrderID "
				+ "    INNER JOIN USER as c ON  o.CustomerID = c.UserID " + "WHERE o.Status <> 0 AND SellerID=?;";
		try {
			new DBConnection();
			Connection conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, sellerID);
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
				// order.setDiscount(rs.getInt("Discount"));
				// order.setCustomerID(rs.getInt("CustomerID"));
				order.setSellerID(rs.getInt("SellerID"));
				order.setShipperID(rs.getInt("ShipperID"));
				order.getCustomer().setFirstName(rs.getString("FirstName"));
				order.getCustomer().setLastName(rs.getString("LastName"));
				// order.getCustomer().setPhone(rs.getString("Phone"));
				order.getPayment().setMethod(rs.getInt("Method"));
				order.getPayment().setStatus(rs.getInt("PayStatus"));
				listOrder.add(order);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listOrder;
	}

	@Override
	public List<OrderModel> findOrderBySeller() {
		List<OrderModel> listOrder = new ArrayList<OrderModel>();
		String sql = "SELECT o.*, FirstName, LastName, Phone, " + "	   p.Method, p.Status as PayStatus "
				+ "	   FROM AZShop.ORDER as o " + "    LEFT JOIN PAYMENT as p ON o.OrderID = p.OrderID "
				+ "    INNER JOIN USER as c ON  o.CustomerID = c.UserID " + "WHERE o.Status = 0 or o.Status=1;";
		try {
			new DBConnection();
			Connection conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			// ps.setInt(1, customerID);
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
				// order.setDiscount(rs.getInt("Discount"));
				// order.setCustomerID(rs.getInt("CustomerID"));
				order.setSellerID(rs.getInt("SellerID"));
				order.setShipperID(rs.getInt("ShipperID"));
				order.getCustomer().setFirstName(rs.getString("FirstName"));
				order.getCustomer().setLastName(rs.getString("LastName"));
				// order.getCustomer().setPhone(rs.getString("Phone"));
				order.getPayment().setMethod(rs.getInt("Method"));
				order.getPayment().setStatus(rs.getInt("PayStatus"));
				listOrder.add(order);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listOrder;
	}

	@Override
	public void updateStatusOrder(int OrderID, int sellerID, int status) {
		String sql = "update `ORDER` set status=? , SellerID=? where OrderID= ?";
		try {
			new DBConnection();
			Connection conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, status);
			ps.setInt(2, sellerID);
			ps.setInt(3, OrderID);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public OrderModel findByOrderID(int orderID) {
		String sql = "SELECT * FROM AZShop.`ORDER` where orderID = ? ";
		OrderModel order = new OrderModel();
		try {
			new DBConnection();
			Connection conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, orderID);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				order.setOrderID(rs.getInt("OrderID"));
				order.setOrderDate(rs.getDate("OrderDate"));
				order.setAddress(rs.getString("Address"));
				order.setStatus(rs.getInt("Status"));
				order.setTransportFee(rs.getInt("TransportFee"));
				order.setDiscount(rs.getInt("Discount"));
				order.setTotalMoney(rs.getInt("TotalMoney"));
				order.setNote(rs.getString("Note"));
				order.setDeliveryTime(rs.getDate("DeliveryTime"));
				order.setCustomerConfirmation(rs.getInt("CustomerConfirmation"));
				order.setCustomerID(rs.getInt("CustomerID"));
				order.setSellerID(rs.getInt("SellerID"));
				order.setShipperID(rs.getInt("ShipperID"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return order;
	}
}
