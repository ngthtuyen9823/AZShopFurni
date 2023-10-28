package com.azshop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.azshop.connection.DBConnection;
import com.azshop.dao.ISupplierDAO;
import com.azshop.models.SupplierModel;

public class SupplierDAOImpl implements ISupplierDAO {
	Connection conn = null;

	@Override
	public SupplierModel findOne(int id) {
		SupplierModel model = new SupplierModel();
		String sql = "Select * from SUPPLIER where SupplierID=?";
		try {
			new DBConnection();
			conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				model.setSupplierID(rs.getInt("SupplierID"));
				model.setSupplierName(rs.getString("SupplierName"));	
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}

	public static void main(String[] args) {
		ISupplierDAO supplierDAO = new SupplierDAOImpl();

		SupplierModel model = supplierDAO.findOne(101);
		System.out.println(model);
	}
}
