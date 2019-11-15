package com.kazim.shopBackend.dao;

import java.util.List;

import com.kazim.shopBackend.dto.Category;

public interface CategoryDAO {
	boolean addCategory(Category category );
	boolean updateCategory(Category category );
	boolean deleteCategory(Category category );
	List<Category> list();
	Category get(int id);

}
