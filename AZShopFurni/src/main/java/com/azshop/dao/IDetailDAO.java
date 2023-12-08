package com.azshop.dao;

import java.util.List;

import com.azshop.models.DetailModel;

public interface IDetailDAO {
	public List<DetailModel> listDetail(int orderID);
}
