package com.azshop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.azshop.connection.DBConnection;
import com.azshop.dao.ISupplierDAO;
import com.azshop.models.SupplierModel;

public class SupplierDAOImpl implements ISupplierDAO {

	@Override
	public List<SupplierModel> findAll() {
		String sql = "SELECT * FROM SUPPLIER";
		List<SupplierModel> listSupplier = new ArrayList<>();
		try {
			new DBConnection();
			Connection conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				SupplierModel supplier = new SupplierModel();
				supplier.setSupplierID(rs.getInt(1));
				supplier.setSupplierName(rs.getString(2));
				listSupplier.add(supplier);
			}
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return listSupplier;
	}

}
