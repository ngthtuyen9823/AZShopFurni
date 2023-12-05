package com.azshop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.azshop.connection.DBConnection;
import com.azshop.dao.IItemImageDAO;
import com.azshop.models.ItemImageModel;

public class ItemImageDAOImpl implements IItemImageDAO{
	Connection conn = null;
	@Override
	public void insertItemImage(ItemImageModel model) {
		String sql = "Insert into ITEMIMAGE (ItemID, Image) values (?,?)";
		try {
			new DBConnection();
			conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, model.getItemID());
			ps.setString(2, model.getImage());
			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteItemImage(int IteamId) {
		String sql = "Delete from ITEMIMAGE where ItemID = ?";
		try {
			new DBConnection();
			conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, IteamId);
			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateItemImage(ItemImageModel model, String newImage) {
		String sql = "Update ITEMIMAGE Set Image = ? where ItemID = ? and Image = ?";
		try {
			new DBConnection();
			conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, newImage);
			ps.setInt(2, model.getItemID());
			ps.setString(3, model.getImage());
			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
