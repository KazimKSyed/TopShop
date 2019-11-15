package com.kazim.shopBackend.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kazim.shopBackend.dao.CategoryDAO;
import com.kazim.shopBackend.dao.ProductDAO;
import com.kazim.shopBackend.dto.Category;
import com.kazim.shopBackend.dto.Product;

public class ProductTest {

	private static AnnotationConfigApplicationContext context;

	private static ProductDAO productDao;

	private Product product;
	
	@Before
	public void setUp() throws Exception {
		context=new AnnotationConfigApplicationContext();
		context.scan("com.kazim.shopBackend");
		context.refresh();
		productDao=(ProductDAO) context.getBean("productDAO");
	}

	/*
	 * @Test public void testCrudProduct() { product =new Product();
	 * product.setName("OPPO A7 Pro");
	 * product.setDescription("this is description for OPPO");
	 * product.setBrand("OPPO"); product.setActive(true);
	 * product.setUnitPrice(17000); product.setCategoryId(2);
	 * product.setSupplierId(2); product.setQuantity(30); product.setPurchases(0);
	 * product.setViews(0);
	 * assertEquals("Something Went Wrong..!",true,productDao.add(product));
	 * product=productDao.get(2); product.setName("Samsang Galaxy");
	 * assertEquals("Something Went Wrong..!",true,productDao.update(product));
	 * assertEquals("Something Went Wrong..!",true,productDao.delete(product));
	 * assertEquals("Something Went Wrong when Fetching the list..!",6,productDao.
	 * list().size());
	 * 
	 * }
	 */
	@Test
	public void testListActiveProducts() {
		assertEquals("Something went wrong while fetching the list of products!",
				5,productDao.listActiveProducts().size());				
	} 
	
	
	@Test
	public void testListActiveProductsByCategory() {
		assertEquals("Something went wrong while fetching the list of products!",
				1,productDao.listActiveProductByCategory(3).size());
		assertEquals("Something went wrong while fetching the list of products!",
				2,productDao.listActiveProductByCategory(1).size());
	} 
	
	@Test
	public void testGetLatestActiveProduct() {
		assertEquals("Something went wrong while fetching the list of products!",
				3,productDao.getLatestActiveProducts(3).size());
		
	} 
	

}
