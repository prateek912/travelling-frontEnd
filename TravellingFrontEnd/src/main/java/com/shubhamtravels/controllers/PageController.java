package com.shubhamtravels.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.shubhamTravels.TravellingBackEnd.dao.CategoryDao;
import com.shubhamTravels.TravellingBackEnd.dao.CityDao;
import com.shubhamTravels.TravellingBackEnd.dao.VehicleDao;
import com.shubhamTravels.TravellingBackEnd.dto.Category;
import com.shubhamTravels.TravellingBackEnd.dto.City;

@Controller
public class PageController {

	@Autowired
	private CategoryDao catDao;
	@Autowired
	private VehicleDao vehicleDao;
	@Autowired
	private CityDao cityDao;

	// This object will contain category list
	private List<Category> catList;
	// This will fetch the number of seater list
	private List<String> numberOfSeaterList;
	// This will contain List of Cities
	//private List<City> citylist;

	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView start() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home Page");
		mv.addObject("userClickedHome", true);

		// Fetching category initially only
		catList = new ArrayList<>();
		numberOfSeaterList = new ArrayList<>();
		catList = catDao.getAllActiveCategories();
		numberOfSeaterList = vehicleDao.getAllSeaterList();

		//Fetching City List initially only
		/*citylist = new ArrayList<>();
		citylist = cityDao.getAllCities();
		mv.addObject("cityList", citylist); */
		
		return mv;
	}

	// Method to load all the products
	@RequestMapping("/show/vehicles")
	public ModelAndView listVehicles() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "All Vehicles");
		mv.addObject("userClickedCarsList", true);

		// If someone directly go to the all vehicle page
		if (catList != null) {
			// Filling up Category block
			mv.addObject("catList", catList);

		} else {
			catList = catDao.getAllActiveCategories();
			mv.addObject("catList", catList);
		}

		// If someone directly go to the all vehicle page
		if (numberOfSeaterList != null) {
			// Filling up Category block
			mv.addObject("numberOfSeaterList", numberOfSeaterList);

		} else {
			numberOfSeaterList = vehicleDao.getAllSeaterList();
			mv.addObject("numberOfSeaterList", numberOfSeaterList);
		}

		return mv;
	}

	// Method to load vehicles of one particular category
	/*@RequestMapping("/show/category/{id}/vehicle")
	public ModelAndView showCatVechicle(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView();

		// If someone directly go to the category vehicle page
		if (catList != null) {
			// Filling up Category block
			mv.addObject("catList", catList);

		} else {
			catList = catDao.getAllActiveCategories();
			mv.addObject("catList", catList);
		}

		// If someone directly go to the all vehicle page
		if (numberOfSeaterList != null) {
			// Filling up Category block
			mv.addObject("numberOfSeaterList", numberOfSeaterList);

		} else {
			numberOfSeaterList = vehicleDao.getAllSeaterList();
			mv.addObject("numberOfSeaterList", numberOfSeaterList);
		}

		// Using CategoryDaoImpl to fetch single category
		Category cat = catDao.getCatById(id);
		// Passing this object, to get the name and other properties of particular
		// category
		mv.addObject("cat", cat);
		// Because we are showing about div on same page
		mv.setViewName("page");
		mv.addObject("title", cat.getName());
		mv.addObject("userClickedCatProducts", true);

		return mv;
	} */

}
