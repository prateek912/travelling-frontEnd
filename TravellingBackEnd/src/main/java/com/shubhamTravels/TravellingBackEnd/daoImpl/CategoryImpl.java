package com.shubhamTravels.TravellingBackEnd.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shubhamTravels.TravellingBackEnd.dao.CategoryDao;
import com.shubhamTravels.TravellingBackEnd.dto.Category;

@Repository("catDao")
//As we have @EnableTransactionalManager in Hibernate Configuration
@Transactional
public class CategoryImpl implements CategoryDao {

	@Autowired
	private SessionFactory factory;

	@Override
	public List<Category> getAllActiveCategories() {
		// Query for fetching all active categories only
		String selectActiveCategories = "FROM Category where active =:active";

		return factory.getCurrentSession().createQuery(selectActiveCategories, Category.class)
				.setParameter("active", true).getResultList();
	}

	@Override
	public boolean addCategory(Category cat) {
		try {
			// Adding Category
			Session session = factory.getCurrentSession();
			session.persist(cat);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Category getCatById(int id) {
		// For getting single Category based on Id
		return factory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}

	@Override
	public boolean updateCategory(Category cat) {
		try {
			factory.getCurrentSession().update(cat);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteCategory(Category cat) {
		// We are not deleting the Category, we are just setting active status as false
		cat.setActive(false);
		try {
			factory.getCurrentSession().update(cat);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Category> getAllCategories() {
		// Query for fetching all active categories only
		String selectCategories = "FROM Category";

		return factory.getCurrentSession()
					.createQuery(selectCategories, Category.class)
					  .getResultList();
	}

}
