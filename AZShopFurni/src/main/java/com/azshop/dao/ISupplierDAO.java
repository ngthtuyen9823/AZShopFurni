package com.azshop.dao;

import java.util.List;

import com.azshop.models.SupplierModel;

public interface ISupplierDAO {
	List<SupplierModel> findAll();
}
