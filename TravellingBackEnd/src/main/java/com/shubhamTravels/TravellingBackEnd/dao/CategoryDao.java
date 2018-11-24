package com.shubhamTravels.TravellingBackEnd.dao;

import java.util.List;

import com.shubhamTravels.TravellingBackEnd.dto.Category;

public interface CategoryDao {

	// For fetching all the active categories
	public List<Category> getAllActiveCategories();
	// For fetching all the categories
		public List<Category> getAllCategories();
		
	// Getting category by Id
	public Category getCatById(int id);
	public boolean addCategory(Category cat);
	public boolean updateCategory(Category cat);
	public boolean deleteCategory(Category cat);
}
