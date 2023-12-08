package com.azshop.service;

import java.util.List;

import com.azshop.models.DetailModel;

public interface IDetailService {
	public List<DetailModel> listDetail(int orderID);
}
