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

}
