package com.shubhamtravels.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shubhamTravels.TravellingBackEnd.dao.CategoryDao;
import com.shubhamTravels.TravellingBackEnd.dto.Category;

@Controller
public class PageController {

	@Autowired
	private CategoryDao catDao;

	// This object will contain category list
	private List<Category> catList;

	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView start() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home Page");
		mv.addObject("userClickedHome", true);

		// Fetching category initially only
		catList = new ArrayList<>();
		catList = catDao.getAllActiveCategories();

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

		return mv;
	}

	// Method to load vehicles of one particular category
	@RequestMapping("/show/category/{id}/vehicle")
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

		// Using CategoryDaoImpl to fetch single category
		Category cat = catDao.getCatById(id);
		// Passing this object, to get the name and other properties of particular category
		mv.addObject("cat", cat);
		// Because we are showing about div on same page
		mv.setViewName("page");
		mv.addObject("title", cat.getName());
		mv.addObject("userClickedCatProducts", true);

		return mv;
	}

}
