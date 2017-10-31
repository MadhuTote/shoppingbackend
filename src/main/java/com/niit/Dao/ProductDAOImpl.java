package com.niit.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.niit.model.Product;

@Repository("productDAO")
public class ProductDAOImpl implements ProductDAO {
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	CategoryDAO categoryDAO;
	@Autowired
	SupplierDAO supplierDAO;

	@Transactional
	public boolean addProduct(Product product) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.save(product);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public List<Product> retrieveProduct() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Product");
		List<Product> listProduct = query.list();
		session.close();
		return listProduct;
	}

	public boolean deleteProduct(Product product) {

		try {
			Session session = sessionFactory.getCurrentSession();
			session.delete(product);
			return true;
		} catch (Exception e) {
			System.out.println("Exception Arised:" + e);
			return false;
		}
	}

	public Product getProduct(int productId) {
		Session session = sessionFactory.openSession();
		Product product = (Product) session.get(Product.class, productId);
		session.close();
		return product;
	}

	public boolean updateProduct(Product product) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(product);
			return true;
		} catch (Exception e) {
			System.out.println("Exception Arised:" + e);
			return false;
		}

	}
}
