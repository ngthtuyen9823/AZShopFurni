package com.azshop.dao;

import com.azshop.models.SupplierModel;

public interface ISupplierDAO {
	SupplierModel findOne(int id);
    List<SupplierModel> findAll();
}
