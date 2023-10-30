package com.azshop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.azshop.connection.DBConnection;
import com.azshop.dao.ICategoryDAO;
import com.azshop.models.CategoryModel;

public class CategoryDAOImpl implements ICategoryDAO {

	@Override
	public List<CategoryModel> findAll() {
		
		List <CategoryModel> Lcategory = new ArrayList<CategoryModel>();
		String sql = "Select * from CATEGORY ";
		try {
			new DBConnection();
			Connection conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CategoryModel category = new CategoryModel();
				category.setCategoryID(rs.getInt("CategoryID"));
				category.setCategoryName(rs.getString("CategoryName"));
				Object oj = rs.getObject("ParentCategoryID");
				if(oj == null)
					category.setParentCategoryID(0);
				else
					category.setParentCategoryID(rs.getInt("ParentCategoryID"));
				Lcategory.add(category);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Lcategory;
	}

	@Override
	public CategoryModel findOne(int id) {
		CategoryModel category = new CategoryModel();
		String sql = "Select * from CATEGORY where CategoryID=?";
		try {
			new DBConnection();
			Connection conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				category = new CategoryModel();
				category.setCategoryID(rs.getInt("CategoryID"));
				category.setCategoryName(rs.getString("CategoryName"));
				category.setParentCategoryID(rs.getInt("ParentCategoryID"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return category;
	}

	@Override
	public void insert(CategoryModel model) {
		
	}

	@Override
	public void update(CategoryModel model) {
		
	}

	@Override
	public void delete(int id) {


	}

	public static void main(String[] args) {
		ICategoryDAO cateDAO = new CategoryDAOImpl();
		List<CategoryModel> model = cateDAO.findAll();
		for(CategoryModel cate: model)
			System.out.println(cate);
	}
}
