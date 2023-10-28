package com.azshop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.azshop.connection.DBConnection;
import com.azshop.dao.ICategoryDAO;
import com.azshop.dao.IItemDAO;
import com.azshop.dao.IItemImageDAO;
import com.azshop.dao.IProductDAO;
import com.azshop.models.CategoryModel;
import com.azshop.models.ItemImageModel;
import com.azshop.models.ItemModel;
import com.azshop.models.ProductModel;

public class ProductDAOImpl implements IProductDAO {
	ICategoryDAO cateDAO = new CategoryDAOImpl();
	IItemDAO itemDAO = new ItemDAOImpl();
	IItemImageDAO itemImageDAO = new ItemImageDAOImpl();
	Connection conn = null;

	@Override
	public List<ProductModel> findAll() {
		String sql = "Select * from PRODUCT";
		List<ProductModel> list = new ArrayList<ProductModel>();

		try {
			new DBConnection();
			conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery(sql);
			while (rs.next()) {
				ProductModel model = new ProductModel();

				model.setProductID(rs.getInt("ProductID"));
				model.setProductName(rs.getString("ProductName"));
				model.setDescription(rs.getString("Description"));
				model.setOrigin(rs.getString("Origin"));
				model.setSupplierID(rs.getInt("SupplierID"));
				model.setCategoryID(rs.getInt("CategoryID"));
				model.setMaterial(rs.getString("Material"));

				list.add(model);
			}
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public List<ProductModel> findByCategoryID(int cateId) {
		String sql = "Select * from PRODUCT where CategoryID=?";
		List<ProductModel> list = new ArrayList<ProductModel>();
		
		try {
			new DBConnection();
			conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, cateId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ProductModel model = new ProductModel();
				int productID = rs.getInt("ProductID");
				
				model.setProductID(productID);
				model.setProductName(rs.getString("ProductName"));
				model.setDescription(rs.getString("Description"));
				model.setOrigin(rs.getString("Origin"));
				model.setSupplierID(rs.getInt("SupplierID"));
				model.setCategoryID(rs.getInt("CategoryID"));
				model.setMaterial(rs.getString("Material"));
				model.setDisplayedImage(itemImageDAO.findByProductID(productID).get(0).getImage());
				model.setDisplayedPromotionPrice(itemDAO.findDisplayedPromotionPrice(productID));
				model.setDisplayedOriginalPrice(itemDAO.findDisplayedOriginalPrice(productID));

				list.add(model);
			}
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<ProductModel> findWithCount(int count) {
		String sql = "Select * from PRODUCT limit ?";
		List<ProductModel> list = new ArrayList<ProductModel>();
		
		try {
			new DBConnection();
			conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, count);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ProductModel model = new ProductModel();

				model.setProductID(rs.getInt("ProductID"));
				model.setProductName(rs.getString("ProductName"));
				model.setDescription(rs.getString("Description"));
				model.setOrigin(rs.getString("Origin"));
				model.setSupplierID(rs.getInt("SupplierID"));
				model.setCategoryID(rs.getInt("CategoryID"));
				model.setMaterial(rs.getString("Material"));

				list.add(model);
			}
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public ProductModel findOne(int id) {
		String sql = "Select * from PRODUCT where ProductID=?";
		ProductModel model = new ProductModel();
		
		try {
			new DBConnection();
			conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int productID = rs.getInt("ProductID");
				
				model.setProductID(productID);
				model.setProductName(rs.getString("ProductName"));
				model.setDescription(rs.getString("Description"));
				model.setOrigin(rs.getString("Origin"));
				model.setSupplierID(rs.getInt("SupplierID"));
				model.setCategoryID(rs.getInt("CategoryID"));
				model.setMaterial(rs.getString("Material"));
				model.setAvgRating((float) 4.9); // truy xuat trong bang detail (chưa có)
				model.setNumOfRating(195); // truy xuat trong baang detail (chưa có)
				model.setSoldTotal(980); // truy xuat trong order (chưa có)
				model.setDisplayedPromotionPrice(itemDAO.findDisplayedPromotionPrice(productID));
				model.setDisplayedOriginalPrice(itemDAO.findDisplayedOriginalPrice(productID));
				model.setListItem(itemDAO.findByProductID(productID));
				model.setListItemImage(itemImageDAO.findByProductID(productID));

			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return model;
	}

	public static void main(String[] args) {
		IProductDAO productDAO = new ProductDAOImpl();
		
//		List<ProductModel> list = productDAO.findAll();
//		System.out.println(list);

		List<ProductModel> listByCate = productDAO.findByCategoryID(101);
		System.out.println(listByCate);
//
//		List<ProductModel> listWithCount = productDAO.findWithCount(1);
//		System.out.println(listWithCount);

//		ProductModel model = productDAO.findOne(101004);
//		System.out.println(model);
	}

}
