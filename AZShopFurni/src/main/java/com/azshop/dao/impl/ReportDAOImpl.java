package com.azshop.dao.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.azshop.bean.MyItem;
import com.azshop.connection.DBConnection;
import com.azshop.dao.IReportDAO;


public class ReportDAOImpl implements IReportDAO {

	@Override
	public List<MyItem> reportReceipt(Date date, int limit) {
		List<MyItem> list = new ArrayList<>();
		for (int i = limit - 1; i >= 0; i--) {
			Date d = subDays(date, i);
			MyItem myItem = new MyItem();
			myItem.setTime(covertD2S(d));
			myItem.setValue(countItemByDate(d));
			list.add(myItem);
		}
		return list;
	}

	private int countItemByDate(Date d) {
		String sql = "SELECT COUNT(*) FROM AZShop.ORDER WHERE DATE_FORMAT(OrderDate, '%Y-%m-%d') = ?";
		int itemCount = 0;
		try {
			new DBConnection();
			Connection conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDate(1, new java.sql.Date(d.getTime()));
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				itemCount = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return itemCount;
	}

	private String covertD2S(Date d) {
		DateFormat df = new SimpleDateFormat("dd/MM/yyy");
		return df.format(d);
	}

	private Date subDays(Date date, int i) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.add(Calendar.DATE, -i);
		return cal.getTime();
	}

	@Override
	public List<MyItem> reportKPISeller(Date date, int id) {
		List<MyItem> list = new ArrayList<>();
		Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
		for (int i = 1; i <= 12; i++) {					
			MyItem myItem = new MyItem();
			myItem.setTime(covertMY(i,year));
			myItem.setValue(countItemByMonth(year,i,id));
			list.add(myItem);
		}
		return list;
	}
	private String covertMY(int month, int year) {
		 // Adjust the month since Calendar.MONTH is zero-based
	    month--;

	    Calendar calendar = Calendar.getInstance();
	    calendar.set(Calendar.MONTH, month);
	    calendar.set(Calendar.YEAR, year);
	    Date modifiedDate = calendar.getTime();
	    // Use SimpleDateFormat to format the date
	    DateFormat df = new SimpleDateFormat("MM/yyyy");
	    String formattedDate = df.format(modifiedDate);
	    return formattedDate;
	}
	private int countItemByMonth(int year, int month, int id) {
		String sql = "SELECT COUNT(*) FROM AZShop.ORDER WHERE DATE_FORMAT(OrderDate, '%Y-%m') = ? and SellerID=? and Status=4";
		int itemCount = 0;
		try {
			new DBConnection();
			Connection conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, String.format("%d-%02d", year, month));
			ps.setInt(2, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				itemCount = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return itemCount;
	}
	
	@Override
	public List<MyItem> reportBestItemSeller(int id) {
		List<MyItem> list = new ArrayList<>();
		String sql ="SELECT AZShop.PRODUCT.ProductID,AZShop.PRODUCT.ProductName, COUNT(AZShop.ORDER.OrderID) AS OrderCount "
				+ "FROM AZShop.ORDER "
				+ "JOIN AZShop.DETAIL ON AZShop.ORDER.OrderID = AZShop.DETAIL.OrderID "
				+ "join AZShop.ITEM on AZShop.DETAIL.ItemID = AZShop.ITEM.ItemID "
				+ "join AZShop.PRODUCT on AZShop.ITEM.ProductID = AZShop.PRODUCT.ProductID "
				+ "WHERE AZShop.ORDER.SellerID = ? "
				+ "GROUP BY AZShop.PRODUCT.ProductID "
				+ "ORDER BY OrderCount DESC LIMIT 5";
		try {
			new DBConnection();
			Connection conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				MyItem item = new MyItem();	
				item.setItem(rs.getString("ProductName"));
				item.setValue(rs.getInt("OrderCount"));			
				list.add(item);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
