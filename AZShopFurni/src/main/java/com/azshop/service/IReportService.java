package com.azshop.service;

import java.util.Date;
import java.util.List;

import com.azshop.bean.MyItem;

public interface IReportService {
	public List<MyItem> reportReceipt(Date date, int limit);
	public List<MyItem> reportKPISeller(Date date, int id);
	public List<MyItem> reportBestItemSeller(int id);
}
