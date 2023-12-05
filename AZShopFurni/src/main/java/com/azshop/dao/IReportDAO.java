package com.azshop.dao;

import java.util.Date;
import java.util.List;

import com.azshop.bean.MyItem;

public interface IReportDAO {
    public List<MyItem> reportReceipt(Date date, int limit);
}
