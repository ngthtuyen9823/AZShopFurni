package com.azshop.service;

import java.util.Date;
import java.util.List;

import com.azshop.bean.MyItem;
import com.azshop.bean.Top3Customer;

public interface IReportService {
	public List<MyItem> reportReceipt(Date date, int limit);
	public List<MyItem> reportKPISeller(Date date, int id);
	public List<MyItem> reportBestItemSeller(int id);
	 public List<List<Object>> reportTotalMoneyInMonth();
	 public List<Top3Customer> reportTop3Customer();
}
