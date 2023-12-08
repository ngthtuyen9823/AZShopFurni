package com.azshop.dao;

import java.util.List;

import com.azshop.models.DetailModel;

public interface IDetailDAO {
	List<DetailModel> findDetailByProductID(int productID);

	DetailModel getOneDetail(int id);

	boolean insertDetail(DetailModel detail);

}
