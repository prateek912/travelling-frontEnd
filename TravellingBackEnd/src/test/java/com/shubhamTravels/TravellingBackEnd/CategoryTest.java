package com.shubhamTravels.TravellingBackEnd;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.shubhamTravels.TravellingBackEnd.dao.CategoryDao;
import com.shubhamTravels.TravellingBackEnd.dto.Category;

public class CategoryTest {

	private static AnnotationConfigApplicationContext context;
	private static CategoryDao catDao;
	private static Category cat;

	// To initialize all the above declared variable before test cases run
	@BeforeClass
	public static void inti() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.shubhamTravels.TravellingBackEnd");
		context.refresh();

		catDao = (CategoryDao) context.getBean(CategoryDao.class);
	}

	// Testing Category add method
	@Test
	@Ignore
	public void testAddCategory() {

		// Creating dummy object
		Category cat1 = new Category();
		cat1.setName("Sedan");
		cat1.setDescription("It is a traditionally defined as a car with four doors and a typical boot/ trunk");

		Category cat2 = new Category();
		cat2.setName("SUV");
		cat2.setDescription("It is a big car built on a body-on-frame chassis, sports increased ground clearance ");

		Category cat3 = new Category();
		cat3.setName("MiniVan");
		cat3.setDescription("Minivans are bigger sized hatchbacks that often come with third row seats (6–8 seats)");

		Category cat4 = new Category();
		cat4.setName("PickUp");
		cat4.setDescription("Pickup is a type of car in which the cargo is separated from the passenger cabin and has an open cargo bed, which can be closed with mat");

		Category cat5 = new Category();
		cat5.setName("Mini");
		cat5.setDescription("Smaller Car having capicity 0f 4-5 people");

		
		assertEquals("Failed while adding Category!!", true, catDao.addCategory(cat1));
		assertEquals("Failed while adding Category!!", true, catDao.addCategory(cat2));
		assertEquals("Failed while adding Category!!", true, catDao.addCategory(cat3));
		assertEquals("Failed while adding Category!!", true, catDao.addCategory(cat4));
		assertEquals("Failed while adding Category!!", true, catDao.addCategory(cat5));

	}

	// Testing Category get By id method
	@Test
	@Ignore
	public void testGetCatById() {
		Category cat = catDao.getCatById(1);
		assertEquals("Failed while fetching  category by id!!", "Leemo", cat.getName());
	}

	// Testing Update category
	@Test
	@Ignore
	public void testUpdateCat() {
		Category cat = catDao.getCatById(1);
		cat.setName("Seedan");
		catDao.updateCategory(cat);

		assertEquals("Failed while updating catrgory!!", "Seedan", cat.getName());
	}

	// Testing delete category
	@Test
	@Ignore
	public void testDeleteCat() {
		Category cat = catDao.getCatById(1);
		cat.setActive(false);
		catDao.deleteCategory(cat);

		assertEquals("Failed while updating catrgory!!", false, cat.isActive());
	}

	// Testing get all active category list method
	@Test
	@Ignore
	public void testGetAllActiveCat() {
		cat = new Category();
		cat.setName("Toofan");
		cat.setDescription("Description");

		catDao.addCategory(cat);
		assertEquals("Failed while fetching all active categories!!", 1, catDao.getAllActiveCategories().size());

	}

	// Testing get all category list method
	@Test
	@Ignore
	public void testGetAllCat() {
		assertEquals("Failed while fetching all active categories!!", 2, catDao.getAllCategories().size());
	}
}
