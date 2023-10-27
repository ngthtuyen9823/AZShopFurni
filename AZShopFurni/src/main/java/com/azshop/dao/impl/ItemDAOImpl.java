package com.azshop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.azshop.connection.DBConnection;
import com.azshop.dao.IItemDAO;
import com.azshop.dao.IProductDAO;
import com.azshop.models.ItemModel;
import com.azshop.models.ProductModel;

public class ItemDAOImpl implements IItemDAO{
	IProductDAO productDAO = new ProductDAOImpl();
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

				model.setItemID(rs.getInt("ItemID"));;
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
		String sql = "Select * from ITEM where ProductID=?";
		List<ItemModel> list = new ArrayList<ItemModel>();
		try {
			new DBConnection();
			conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, productID);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ProductModel productModel = productDAO.findOne(rs.getInt("ProductID"));
				ItemModel model = new ItemModel();

				model.setItemID(rs.getInt("ItemID"));;
				model.setProductID(productModel.getProductID());
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
				model.setItemID(rs.getInt("ItemID"));;
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
	
	public static void main(String[] args) {
		IItemDAO itemDAO = new ItemDAOImpl();

//		List<ItemModel> list = itemDAO.findAll();
//		System.out.println(list);

//		List<ItemModel> listByPro = itemDAO.findByProductID(101001);
//		System.out.println(listByPro);

		ItemModel model = itemDAO.findOne(10100101);
		System.out.println(model);
	}

}
