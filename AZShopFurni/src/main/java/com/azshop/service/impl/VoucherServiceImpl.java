package com.azshop.service.impl;

import java.util.List;

import com.azshop.dao.IVoucherDAO;
import com.azshop.dao.impl.VoucherDAOImpl;
import com.azshop.models.VoucherModel;
import com.azshop.service.IVoucherService;

public class VoucherServiceImpl implements IVoucherService{
	IVoucherDAO voucherDAO = new VoucherDAOImpl();
	@Override
	public List<VoucherModel> findAllVoucher() {
		return voucherDAO.findAllVoucher();
	}
	@Override
	public void insertVoucher(VoucherModel model) {
		voucherDAO.insertVoucher(model);		
	}
	@Override
	public void updateVoucher(VoucherModel model) {
		voucherDAO.updateVoucher(model);
		
	}
	@Override
	public VoucherModel findOne(int id) {
		return voucherDAO.findOne(id);
	}

}
