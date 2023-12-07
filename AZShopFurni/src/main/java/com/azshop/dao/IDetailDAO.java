package com.azshop.dao;

import java.util.List;

import com.azshop.models.DetailModel;

public interface IDetailDAO {
	List<DetailModel> getAllDetail();

	DetailModel getOneDetail(int id);

	boolean insertDetail(DetailModel detail);

}
