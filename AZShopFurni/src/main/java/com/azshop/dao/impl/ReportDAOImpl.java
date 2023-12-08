package com.azshop.dao.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
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
	public List<List<Object>> reportTotalMoneyInMonth() {
		String sql = "SELECT  " 
				+ "   OrderDate AS Ngay, " 
				+ "    SUM(TotalMoney) AS Tong, "
				+ "    COUNT(OrderID) AS SL " 
				+ "FROM AZShop.`ORDER` WHERE MONTH(OrderDate) = MONTH(CURDATE()) AND YEAR(OrderDate) = YEAR(CURDATE()) " + "GROUP BY Ngay " 
				+ "ORDER BY Ngay ";

		List<List<Object>> list = new ArrayList<List<Object>>();
		try {
			new DBConnection();
			Connection conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				List<Object> row = new ArrayList<Object>();
				row.add(rs.getDate("Ngay"));
				row.add(rs.getInt("Tong"));
				row.add(rs.getInt("SL"));
				list.add(row);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

//	public static void main(String[] args) {
//		IReportDAO idao = new ReportDAOImpl();
//		List<List<Object>> list = idao.reportTotalMoneyInMonth();
//		for (List<Object> list2 : list) {
//			System.out.println(list2.get(0));
//		}
//	}

}
