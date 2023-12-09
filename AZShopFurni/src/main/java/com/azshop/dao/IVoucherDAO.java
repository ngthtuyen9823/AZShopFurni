package com.azshop.dao;

import java.util.List;

import com.azshop.models.VoucherModel;

public interface IVoucherDAO {
	List<VoucherModel> findAllVoucher();
	List<VoucherModel> findAllVoucherOfCustomer(int customerId);
	void insertVoucher(VoucherModel model);
	void updateVoucher(VoucherModel model);
	VoucherModel findOne(int id);
}
