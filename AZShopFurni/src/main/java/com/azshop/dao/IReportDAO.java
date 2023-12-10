package com.azshop.dao;

import java.util.Date;
import java.util.List;

import com.azshop.bean.MyItem;
import com.azshop.bean.Top3Customer;

public interface IReportDAO {
    public List<MyItem> reportReceipt(Date date, int limit);
    public List<List<Object>> reportTotalMoneyInMonth();
    public List<Top3Customer> reportTop3Customer();
}
