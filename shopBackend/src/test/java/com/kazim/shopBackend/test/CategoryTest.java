package com.kazim.shopBackend.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kazim.shopBackend.dao.CategoryDAO;
import com.kazim.shopBackend.dto.Category;

public class CategoryTest {

	private static AnnotationConfigApplicationContext context;

	private static CategoryDAO categoryDao;

	private Category category;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.kazim.shopBackend");
		context.refresh();
		categoryDao = (CategoryDAO) context.getBean("categoryDao");
	}

	@Test
	public void testCrudCategory() {
		//adding a category
		category = new Category();
		category.setName("Television");
		category.setDescription("This is some description for television");
		category.setImageURL("CAT_1.png");

		assertEquals("Successfully added a category inside the table !", true, categoryDao.addCategory(category));
		
		category = new Category();
		category.setName("Mobile");
		category.setDescription("This is some description for Mobile");
		category.setImageURL("CAT_2.png"); 
		
		assertEquals("Successfully added a category inside the table !", true, categoryDao.addCategory(category));
		

		// fetching and updating category
		category = categoryDao.get(1);		
		category.setName("TV");
		assertEquals("Successfully updated a single category in the table !", true,
				categoryDao.updateCategory(category));

		//Deleting a category
		
		assertEquals("Successfully deleted a single category in the table !", true,
				categoryDao.deleteCategory(category));
		
		//Fetching the category list
		assertEquals("Successfully fetched the list of category from the table !", 5, categoryDao.list().size());
	}

	/*
	 * @Test public void testAddCategory() { category = new Category();
	 * category.setName("Television");
	 * category.setDescription("This is some description for television");
	 * category.setImageURL("CAT_1.png");
	 * assertEquals("Successfully added a category inside the table !", true,
	 * categoryDao.addCategory(category));
	 * 
	 * }
	 * 
	 * @Test public void testGetCategory() { category = categoryDao.get(2);
	 * assertEquals("Successfully fetched a single category from the table !",
	 * "Television", category.getName());
	 * 
	 * }
	 * 
	 * @Test public void testUpdateCategory() { category = categoryDao.get(2);
	 * category.setName("TV");
	 * assertEquals("Successfully updated a single category in the table !", true,
	 * categoryDao.updateCategory(category));
	 * 
	 * }
	 * 
	 * @Test public void testDeleteCategory() { category = categoryDao.get(2);
	 * assertEquals("Successfully deleted a single category in the table !", true,
	 * categoryDao.deleteCategory(category));
	 * 
	 * }
	 * 
	 * @Test public void testListCategory() {
	 * 
	 * assertEquals("Successfully fetched the list of category from the table !", 7,
	 * categoryDao.list().size());
	 * 
	 * }
	 */
}
