package com.shubhamtravels.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shubhamTravels.TravellingBackEnd.dao.VehicleDao;
import com.shubhamTravels.TravellingBackEnd.dto.Vehicle;

@RestController
@RequestMapping("/json/data")
public class JSONDataController {

	@Autowired
	private VehicleDao vehicleDao;
	
	@RequestMapping("/all/vehicles")
	public List<Vehicle> getAllVehicles(){
		return vehicleDao.getAllActiveVehicles();
	}
	
	/*@RequestMapping("/category/{id}/vehicles")
	public List<Vehicle> getListOfActiveVehicleByCatId(@PathVariable("id") int id){
		return vehicleDao.getActiveVehicleByCatId(id);
	}*/
	
	// For Admin to see all the products
	@RequestMapping("/admin/all/vehicles")
	public List<Vehicle> getAlAdminlVehicles(){
		return vehicleDao.getAllVehicles();
	}
	
	/*// When category and fuel both are selected in filtering of result
	@RequestMapping("/category/{id}")
	public List<Vehicle> getAllVehicleBasedOnFuelAndCat(@PathVariable("id") int categoryId,
																@RequestParam("fuelType") String fuelType){
		return vehicleDao.getAllVehicleBasedOnFuelAndCat(categoryId, fuelType);
	}*/
	
	/*// When filtering done based on Fuel Type only
	@RequestMapping("/all/vehicles/{fuelType}")
	public List<Vehicle> getAllVehicleBasedOnFuel(@PathVariable("fuelType") String fuelType){
		return vehicleDao.getAllVehicleBasedOnFuel(fuelType);
	}*/
	
	
	@RequestMapping("/searchFilters")
	public List<Vehicle> applySearchFilters(@RequestParam(value="catId",required=false) List<Integer> categoriesId, 
								@RequestParam(value="fuelType",required=false) List<String> fuelTypeList,
								@RequestParam(value="mileage",required=false) List<String> mileageRangeList){
		
		String fuelType= "";
		String mileage = "";
		
		// NUll pointer check
		if(fuelTypeList != null && fuelTypeList.size() > 0) {
			 fuelType = fuelTypeList.get(fuelTypeList.size()-1);
			 System.out.println("Selected Fuel Type :"+fuelType);
		} 
		if(mileageRangeList != null && mileageRangeList.size() > 0 ) {
			mileage = mileageRangeList.get(mileageRangeList.size()-1);
			System.out.println("Selected mileage range :"+mileage);
		}
	
		return vehicleDao.getAllAppliedFiltersVehicles(categoriesId, fuelType, mileage);
		
	}
	
}
