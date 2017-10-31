package com.niit.test;


import static org.junit.Assert.*;




import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Dao.CategoryDAO;
import com.niit.model.Category;

public class CategoryTest {
	static CategoryDAO categoryDAO;

	@BeforeClass
	public static void initialize() {
		AnnotationConfigApplicationContext configApplnContext = new AnnotationConfigApplicationContext();
		configApplnContext.scan("com.niit");
		configApplnContext.refresh();

		// SessionFactory
		// sessionFactory=(SessionFactory)configApplnContext.getBean("DBConfig.class");

		 categoryDAO = (CategoryDAO)configApplnContext.getBean("categoryDAO");
	}
	
	@Test
	public void addCategoryTest()
	{
		Category category=new Category();
		category.setCatId(102);
		category.setCatName("woodland shoes");
		category.setCatDesc("woodland shoes with best quaility");
		
		assertTrue(categoryDAO.addCategory(category));
	}
	

	@Test
	public void updateCategoryTest()
	{
		Category category=new Category();
		category.setCatId(102);
		category.setCatName("JMShirt");
		category.setCatDesc("John Miller Shirt with Best Price");
		
		assertTrue(categoryDAO.updateCategory(category));
	}

	@Test
	public void deleteCategoryTest()
	{
		Category category=new Category();
		category.setCatId(1002);
		assertTrue(categoryDAO.deleteCategory(category));
	}
	
	@Test
	public void retrieveCategoryTest()
	{
		List<Category> listCategory=categoryDAO.retrieveCategory();
		assertNotNull("Problem in Retriving ",listCategory);
		this.show(listCategory);
	}
	
	public void show(List<Category> listCategory)
	{
		for(Category category:listCategory)
		{
			System.out.println("Category ID:"+category.getCatId());
			System.out.println("Category Name:"+category.getCatName());
		}
	}
	
	
	@Test
	public void getCategoryTest()
	{
		Category category=categoryDAO.getCategory(101);
		assertNotNull("Problem in Getting:",category);
		System.out.println("Category ID:"+category.getCatId());
		System.out.println("Category Name:"+category.getCatName());
		System.out.println("Category Description  = "+category.getCatDesc());
	}

}






