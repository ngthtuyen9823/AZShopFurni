package com.azshop.service;

import java.util.List;

import com.azshop.models.VoucherModel;

public interface IVoucherService {
	List<VoucherModel> findAllVoucher();
	void insertVoucher(VoucherModel model);
	void updateVoucher(VoucherModel model);
	VoucherModel findOne(int id);
}
