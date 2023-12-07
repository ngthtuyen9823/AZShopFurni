package com.azshop.service.impl;

import java.util.List;

import com.azshop.dao.IDetailDAO;
import com.azshop.dao.impl.DetailDAOImpl;
import com.azshop.models.DetailModel;
import com.azshop.service.IDetailService;

public class DetailServiceImpl implements IDetailService {
	IDetailDAO detailDAO = new DetailDAOImpl();

	@Override
	public List<DetailModel> getAllDetail() {
		return detailDAO.getAllDetail();
	}

	@Override
	public DetailModel getOneDetail(int id) {
		return detailDAO.getOneDetail(id);
	}

	@Override
	public boolean insertDetail(DetailModel detail) {
		return detailDAO.insertDetail(detail);
	}

}
