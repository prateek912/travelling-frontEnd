package com.shubhamtravels.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shubhamTravels.TravellingBackEnd.dao.CityDao;
import com.shubhamTravels.TravellingBackEnd.dao.VehicleDao;
import com.shubhamTravels.TravellingBackEnd.dto.City;
import com.shubhamTravels.TravellingBackEnd.dto.Vehicle;

@RestController
@RequestMapping("/json/data")
public class JSONDataController {

	@Autowired
	private VehicleDao vehicleDao;
	@Autowired
	private CityDao cityDao;
	
	@RequestMapping("/all/vehicles")
	public List<Vehicle> getAllVehicles(){
		return vehicleDao.getAllActiveVehicles();
	}

	// For Admin to see all the products
	@RequestMapping("/admin/all/vehicles")
	public List<Vehicle> getAlAdminlVehicles(){
		return vehicleDao.getAllVehicles();
	}
	
	@RequestMapping("/searchFilters")
	public List<Vehicle> applySearchFilters(@RequestParam(value="catId",required=false) List<Integer> categoriesId, 
								@RequestParam(value="fuelType",required=false) List<String> fuelTypeList,
								@RequestParam(value="mileage",required=false) List<String> mileageRangeList,
								@RequestParam(value="numberOfSeater",required=false) List<String> numberOfSeaterList){
		
		String fuelType= "";
		String mileage = "";
		String seater ="";
	
		// NUll pointer check
		if(fuelTypeList != null && fuelTypeList.size() > 0) {
			 fuelType = fuelTypeList.get(fuelTypeList.size()-1);
			 System.out.println("Selected Fuel Type :"+fuelType);
		} 
		if(mileageRangeList != null && mileageRangeList.size() > 0 ) {
			mileage = mileageRangeList.get(mileageRangeList.size()-1);
			System.out.println("Selected mileage range :"+mileage);
		}
		if(numberOfSeaterList != null && numberOfSeaterList.size() > 0 ) {
			seater = numberOfSeaterList.get(numberOfSeaterList.size()-1);
			System.out.println("Selected seater :"+seater);
		}
	
		return vehicleDao.getAllAppliedFiltersVehiclesFinal(categoriesId, fuelType, mileage,seater);
		
	}
	
	// Fetching All Cities
	@RequestMapping("/getCities")
	public List<City> getAllCitites(){
		return cityDao.getAllCities();
	}
	
}
