package com.niit.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Dao.SupplierDAO;
import com.niit.model.Supplier;

public class SupplierTest {

	static SupplierDAO supplierDAO;

	@BeforeClass
	public static void initialize() {
		AnnotationConfigApplicationContext configApplnContext = new AnnotationConfigApplicationContext();
		configApplnContext.scan("com.niit");
		configApplnContext.refresh();

		// SessionFactory
		// sessionFactory=(SessionFactory)configApplnContext.getBean("DBConfig.class");

		supplierDAO = (SupplierDAO) configApplnContext.getBean("supplierDAO");
	}

	@Test
	public void addSupplierTest() {
		Supplier supplier = new Supplier();
		supplier.setSupplierId(101);
		supplier.setSupplierName("samsung cafe");
		supplier.setSupplierAddress(" sionS");

		//assertTrue(supplierDAO.addSupplier(supplier));
	}
@Ignore
	@Test
	public void updateSupplierTest() {
		Supplier supplier = new Supplier();
		supplier.setSupplierId(102);
		supplier.setSupplierName("JMShirt");
		supplier.setSupplierAddress("bandra");

		assertTrue(supplierDAO.updateSupplier(supplier));
	}

	@Test
	public void deleteSupplierTest() {
		Supplier supplier = new Supplier();
		supplier.setSupplierId(1002);
		assertTrue(supplierDAO.deleteSupplier(supplier));
	}

	@Test
	public void retrieveSupplierTest() {
		List<Supplier> listSupplier = supplierDAO.retrieveSupplier();
		assertNotNull("Problem in Retriving ", listSupplier);
		this.show(listSupplier);
	}

	public void show(List<Supplier> listSupplier) {
		for (Supplier supplier : listSupplier) {
			System.out.println("Supplier ID:" + supplier.getSupplierId());
			System.out.println("Supplier Name:" + supplier.getSupplierName());
		}
	}

	@Ignore
	@Test
	public void getSupplierTest() {
		Supplier supplier = supplierDAO.getSupplier(101);
		assertNotNull("Problem in Getting:", supplier);
		System.out.println("Supplier ID:" + supplier.getSupplierId());
		System.out.println("Supplier Name:" + supplier.getSupplierName());
		System.out.println("Supplier Address: " + supplier.getSupplierAddress());
	}

}
