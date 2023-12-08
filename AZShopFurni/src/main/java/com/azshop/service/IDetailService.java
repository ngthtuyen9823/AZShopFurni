package com.azshop.service;

import java.util.List;

import com.azshop.models.DetailModel;

public interface IDetailService {
	List<DetailModel> findDetailByProductID(int productID);

	DetailModel getOneDetail(int id);

	boolean insertDetail(DetailModel detail);
}
