package com.azshop.service.impl;

import java.util.Date;
import java.util.List;

import com.azshop.bean.MyItem;
import com.azshop.dao.IReportDAO;
import com.azshop.dao.impl.ReportDAOImpl;
import com.azshop.service.IReportService;

public class ReportServiceImpl implements IReportService{
	
	IReportDAO reportDAO = new ReportDAOImpl();
	@Override
	public List<MyItem> reportReceipt(Date date, int limit) {
		return reportDAO.reportReceipt(date, limit);
	}
	@Override
	public List<List<Object>> reportTotalMoneyInMonth() {
		
		return reportDAO.reportTotalMoneyInMonth();
	}

}
