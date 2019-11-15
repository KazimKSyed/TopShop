package com.kazim.shopBackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kazim.shopBackend.dao.CategoryDAO;
import com.kazim.shopBackend.dto.Category;

@Repository("categoryDao")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	

	@Override
	public List<Category> list() {
		String selectActiveCategory="FROM Category WHERE active=:active";
		
		Query query=sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		query.setParameter("active", true);
		
		return query.getResultList();
	}

	@Override
	public Category get(int id) {
		return sessionFactory.getCurrentSession().get(Category.class, id);
	}

	@Override
	
	public boolean addCategory(Category category) {
		try {

		 sessionFactory.getCurrentSession().persist(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean updateCategory(Category category) {
		try {

			 sessionFactory.getCurrentSession().update(category);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}

	}

	@Override
	public boolean deleteCategory(Category category) {
		category.setActive(false);
		try {
			 sessionFactory.getCurrentSession().update(category);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
	}

}
