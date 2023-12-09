package com.azshop.service.impl;

import java.util.List;

import com.azshop.dao.IDetailDAO;
import com.azshop.dao.impl.DetailDAOImpl;
import com.azshop.models.DetailModel;
import com.azshop.service.IDetailService;

public class DetailServiceImpl implements IDetailService {
	IDetailDAO detailDAO = new DetailDAOImpl();

	@Override
	public List<DetailModel> findDetailByProductID(int productID) {
		return detailDAO.findDetailByProductID(productID);
	}

	@Override
	public void updateDetail(DetailModel detail) {
		detailDAO.updateDetail(detail);
	}

}
