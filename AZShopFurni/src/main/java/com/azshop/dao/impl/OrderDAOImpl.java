package com.azshop.dao.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.azshop.connection.DBConnection;
import com.azshop.dao.IDetailDAO;
import com.azshop.dao.IOrderDAO;
import com.azshop.models.OrderModel;
import com.azshop.service.impl.OrderServiceImpl;

public class OrderDAOImpl implements IOrderDAO {

	@Override
	public List<OrderModel> listOrderByCustomerID(int customerID) {
		List<OrderModel> listOrder = new ArrayList<OrderModel>();
		String sql = "SELECT O.OrderID, O.CustomerID, O.OrderDate, O.`Status`, O.CustomerConfirmation, O.Discount, O.TotalMoney, O.SellerID, O.ShipperID, O.TransportFee "
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
		} catch (Exception e) {
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
		String sql = "SELECT O.OrderID, O.CustomerID, O.OrderDate, O.`Status`, O.CustomerConfirmation, O.Discount, O.TotalMoney, O.SellerID, O.ShipperID, O.TransportFee "
				+ "FROM `ORDER` O " + "WHERE O.OrderID = ?";
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
		String condition = "	WHERE o.Status = 3 AND ShipperID = ?";
		return findDeliveryByCondition(condition, ShipperID);
	}

	@Override
	public List<OrderModel> findHisDeliveryByShipperID(int ShipperID) {
		String condition = "	WHERE (o.Status = 4 OR o.Status = 5) AND ShipperID = ? "
				+ "ORDER BY o.DeliveryTime DESC";
		return findDeliveryByCondition(condition, ShipperID);
	}

	@Override
	public OrderModel findShipByID(int OrderID) {
		String condition = "	WHERE o.OrderID = " + OrderID + " AND ?";
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

	public Object[] findKPIByShipper(int ShipperID) {
		String sql = "SELECT o.DeliveryTime, s.KPI,\r\n"
				+ "Count(*) as Oall, SUM(o.Status = 4) as Complete, SUM(o.Status = 5) as Cancel, SUM(o.Status  < 4) as Doing\r\n"
				+ "	FROM AZShop.ORDER as o\r\n"
				+ "		JOIN (SELECT * FROM AZShop.USER as u WHERE u.userID = ? ) as s\r\n"
				+ "        ON s.UserID = o.ShipperID\r\n" + " WHERE MONTH(o.DeliveryTime) = MONTH(current_date()) \r\n"
				+ "		AND YEAR(o.DeliveryTime) = YEAR(current_date()) " + "	GROUP BY o.DeliveryTime "
				+ " ORDER BY o.DeliveryTime ASC";
		
		Date curday = new Date();
		
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
        	curday = dateFormat.parse(dateFormat.format(curday));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
        
        System.out.println(curday);
		
		List<Integer> listdate = getDatesInNowMonth(new Date());
		List<Integer> listkpi = new ArrayList<>(Collections.nCopies(listdate.size(), 0));
		List<Integer> listall = new ArrayList<>(Collections.nCopies(listdate.size(), 0));
		List<Integer> listcomplete = new ArrayList<>(Collections.nCopies(listdate.size(), 0));
		List<Integer> listcancel = new ArrayList<>(Collections.nCopies(listdate.size(), 0));
		List<Integer> listdoing = new ArrayList<>(Collections.nCopies(listdate.size(), 0));
		int kpi = 0;
				
		

		// list
		try {
			new DBConnection();
			Connection conn;
			conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, ShipperID);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int day = rs.getDate("DeliveryTime").getDate() - 1;
				kpi = rs.getInt("KPI");
				listall.set(day, rs.getInt("Oall"));
				listcomplete.set(day, rs.getInt("Complete"));
				listcancel.set(day, rs.getInt("Cancel"));
				listdoing.set(day, rs.getInt("Doing"));
				//listdate.set(day, rs.getDate("DeliveryTime"));
				System.out.println(rs.getDate("DeliveryTime"));
				
			}
			
		listkpi = new ArrayList<>(Collections.nCopies(listdate.size(), kpi));
		
		
		} catch (Exception e) {
			e.printStackTrace();
		}

		Object[] list = { listdate, listkpi, listall, listcomplete, listcancel, listdoing };
		return list;
	}

//	public Object[] findCateForShipper(int ShipperID) {
//		String sql = "SELECT c.CategoryName, Sum(d.Quantity) as Num\r\n" + "	FROM AZShop.DETAIL as d\r\n"
//				+ "	JOIN AZShop.ORDER as o ON d.OrderID = o.OrderID\r\n"
//				+ "    JOIN AZShop.ITEM as i ON d.ItemID = i.ItemID\r\n"
//				+ "    JOIN AZShop.PRODUCT p ON i.ProductID = p.ProductID\r\n"
//				+ "    JOIN AZShop.CATEGORY as c ON p.CategoryID = c.CategoryID\r\n" + "    WHERE o.ShipperID = ? \r\n"
//				+ "    GROUP BY c.CategoryName";
//		List<String> listCate = new ArrayList<String>();
//		List<Integer> listNumItem = new ArrayList<Integer>();
//		List<String> listColor = new ArrayList<String>();
//
//		Object[] list = { listCate, listNumItem, listColor };
//		try {
//			new DBConnection();
//			Connection conn;
//			conn = DBConnection.getConnection();
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.setInt(1, ShipperID);
//			ResultSet rs = ps.executeQuery();
//			while (rs.next()) {
//				listCate.add("'" + rs.getString("CategoryName") + "'");
//				listNumItem.add(rs.getInt("Num"));
//				listColor.add(rndRGP());
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return list;
//	}

	public List<Date> getDayInNowWeek() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());

		calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);

		List<Date> daysOfWeek = new ArrayList<>();

		// Thêm các ngày trong tuần vào danh sách
		for (int i = 0; i < 7; i++) {
			daysOfWeek.add(calendar.getTime());
			calendar.add(Calendar.DAY_OF_WEEK, 1);
		}
		return daysOfWeek;
	}

	@SuppressWarnings("deprecation")
	public static List<Integer> getDatesInNowMonth(Date date) {

		List<Integer> datesInMonth = new ArrayList<>();
		Calendar calendar = Calendar.getInstance();
		calendar.set(date.getYear(), date.getMonth(), 1); // Tháng trong Java bắt đầu từ 0
		while (calendar.get(Calendar.MONTH) == (date.getMonth())) {	
			datesInMonth.add(calendar.getTime().getDate());
			calendar.add(Calendar.DAY_OF_MONTH, 1);
		}

		return datesInMonth;
	}

	public List<Object[]> findCateForShipper(int ShipperID) {
		String sql = "SELECT c.CategoryName, Sum(d.Quantity) as Num\r\n" + "	FROM AZShop.DETAIL as d\r\n"
				+ "	JOIN AZShop.ORDER as o ON d.OrderID = o.OrderID\r\n"
				+ "    JOIN AZShop.ITEM as i ON d.ItemID = i.ItemID\r\n"
				+ "    JOIN AZShop.PRODUCT p ON i.ProductID = p.ProductID\r\n"
				+ "    JOIN AZShop.CATEGORY as c ON p.CategoryID = c.CategoryID\r\n" + "    WHERE o.ShipperID = ? \r\n"
				+ "    GROUP BY c.CategoryName";
		List<Object[]> list = new ArrayList<Object[]>();
		Object[] row = { "'Loai hang'", "'SL'" };
		list.add(row);

		try {
			new DBConnection();
			Connection conn;
			conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, ShipperID);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String str = "'" + rs.getString("CategoryName") + "'";
				int num = rs.getInt("Num");
				Object[] row1 = { str, num };
				list.add(row1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static void main(String[] args) {

		// new OrderDAOImpl().findCateForShipper2(120001).forEach(cate ->
		// System.out.println(cate[0]));
		//new OrderDAOImpl().getDaysInNowMonth(new Date()).forEach(cate -> System.out.println(cate));
	}
}
