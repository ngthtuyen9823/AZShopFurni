package com.azshop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.azshop.connection.DBConnection;
import com.azshop.dao.IItemDAO;
import com.azshop.models.ItemModel;

public class ItemDAOImpl implements IItemDAO {
	Connection conn = null;

	@Override
	public List<ItemModel> findAll() {
		String sql = "Select * from ITEM";
		List<ItemModel> list = new ArrayList<ItemModel>();
		try {
			new DBConnection();
			conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery(sql);
			while (rs.next()) {
				ItemModel model = new ItemModel();

				model.setItemID(rs.getInt("ItemID"));
				model.setProductID(rs.getInt("ProductID"));
				model.setColor(rs.getString("Color"));
				model.setColorCode(rs.getString("ColorCode"));
				model.setSize(rs.getString("Size"));
				model.setStock(rs.getInt("Stock"));
				model.setOriginalPrice(rs.getInt("OriginalPrice"));
				model.setPromotionPrice(rs.getInt("PromotionPrice"));

				list.add(model);
			}
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<ItemModel> findByProductID(int productID) {
		String sql = "Select i.*, SUBSTRING_INDEX(GROUP_CONCAT(ii.Image ORDER BY ii.ItemImageID), ',', 1) AS FirstImage\r\n"
				+ "from ITEM i\r\n" + "JOIN ITEMIMAGE ii\r\n" + "ON i.ItemID = ii.ItemID\r\n" + "where ProductID=?\r\n"
				+ "group by i.ItemID;";
		List<ItemModel> list = new ArrayList<ItemModel>();
		try {
			new DBConnection();
			conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, productID);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ItemModel model = new ItemModel();

				model.setItemID(rs.getInt("ItemID"));
				model.setProductID(rs.getInt("ProductID"));
				model.setColor(rs.getString("Color"));
				model.setColorCode(rs.getString("ColorCode"));
				model.setSize(rs.getString("Size"));
				model.setStock(rs.getInt("Stock"));
				model.setOriginalPrice(rs.getInt("OriginalPrice"));
				model.setPromotionPrice(rs.getInt("PromotionPrice"));
				model.setImage(rs.getString("FirstImage"));
				list.add(model);
			}
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public ItemModel findOne(int id) {
		ItemModel model = new ItemModel();
		String sql = "Select * from ITEM where ItemID=?";
		try {
			new DBConnection();
			conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				model.setItemID(rs.getInt("ItemID"));
				model.setProductID(rs.getInt("ProductID"));
				model.setColor(rs.getString("Color"));
				model.setColorCode(rs.getString("ColorCode"));
				model.setSize(rs.getString("Size"));
				model.setStock(rs.getInt("Stock"));
				model.setOriginalPrice(rs.getInt("OriginalPrice"));
				model.setPromotionPrice(rs.getInt("PromotionPrice"));
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}

	@Override
	public ItemModel findOneByProductID(int productID) {
		ItemModel model = new ItemModel();
		String sql = "Select * from ITEM where ProductID=? order by PromotionPrice asc limit 1;";
		try {
			new DBConnection();
			conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, productID);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				model.setItemID(rs.getInt("ItemID"));
				model.setProductID(rs.getInt("ProductID"));
				model.setColor(rs.getString("Color"));
				model.setColorCode(rs.getString("ColorCode"));
				model.setSize(rs.getString("Size"));
				model.setStock(rs.getInt("Stock"));
				model.setOriginalPrice(rs.getInt("OriginalPrice"));
				model.setPromotionPrice(rs.getInt("PromotionPrice"));
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}

	@Override
	public void insertItem(ItemModel model) {
		String sql = "Insert into ITEM values (?,?,?,?,?,?,?,?)";
		try {
			new DBConnection();
			conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, model.getItemID());
			ps.setInt(2, model.getProductID());
			ps.setString(3, model.getColor());
			ps.setString(4, model.getColorCode());
			ps.setString(5, model.getSize());
			ps.setInt(6, model.getStock());
			ps.setInt(7, model.getOriginalPrice());
			ps.setInt(8, model.getPromotionPrice());
			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteItem(int ItemId) {
		String sql = "Delete from ITEM where ProductID=?";
		try {
			new DBConnection();
			conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, ItemId);
			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateItem(ItemModel model) {
		String sql = "Update ITEM " + "Set ProductID = ?, Color = ?, ColorCode = ?,"
				+ " Size = ?, Stock = ?, OriginalPrice = ?, PromotionPrice = ?" + "where ItemID = ?";
		try {
			new DBConnection();
			conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, model.getProductID());
			ps.setString(2, model.getColor());
			ps.setString(3, model.getColorCode());
			ps.setString(4, model.getSize());
			ps.setInt(5, model.getStock());
			ps.setInt(6, model.getOriginalPrice());
			ps.setInt(7, model.getPromotionPrice());
			ps.setInt(8, model.getItemID());
			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		IItemDAO itemDAO = new ItemDAOImpl();

//		List<ItemModel> list = itemDAO.findAll();
//		System.out.println(list);

//		List<ItemModel> listByPro = itemDAO.findByProductID(101001);
//		System.out.println(listByPro);
//
		List<ItemModel> list = itemDAO.findByProductID(101003);
		System.out.println(list);

	}

	@Override
	public int findDisplayedPromotionPrice(int productID) {
		String sql = "Select min(PromotionPrice) from ITEM where ProductID=?";
		int displayedPromotionPrice = 0;

		try {
			new DBConnection();
			conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, productID);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				displayedPromotionPrice = rs.getInt(1);
			}

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return displayedPromotionPrice;
	}

	@Override
	public int findDisplayedOriginalPrice(int productID) {
		String sql = "Select min(OriginalPrice) from ITEM where ProductID=?";
		int displayedOriginalPrice = 0;

		try {
			new DBConnection();
			conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			ps.setInt(1, productID);

			while (rs.next()) {
				displayedOriginalPrice = rs.getInt(1);

			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return displayedOriginalPrice;
	}
}
