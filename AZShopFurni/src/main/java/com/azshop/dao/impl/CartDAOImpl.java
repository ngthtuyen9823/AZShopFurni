package com.azshop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.azshop.connection.DBConnection;
import com.azshop.dao.ICartDAO;
import com.azshop.models.CartModel;

public class CartDAOImpl implements ICartDAO {
	Connection conn = null;

	@Override
	public void insert(CartModel model) {
		String sql = "Insert into CART (CustomerID, ItemID, Quantity) values (?,?,?)";
		try {
			new DBConnection();
			conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, model.getCustomerID());
			ps.setInt(2, model.getItemID());
			ps.setInt(3, model.getQuantity());
			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}