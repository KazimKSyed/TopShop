package com.kazim.shopBackend.dao;

import java.util.List;

import com.kazim.shopBackend.dto.Category;

public interface CategoryDAO {
	List<Category> list();

	Category get(int id);

}
