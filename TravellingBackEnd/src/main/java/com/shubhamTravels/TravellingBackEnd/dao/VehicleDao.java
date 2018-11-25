package com.shubhamTravels.TravellingBackEnd.dao;

import java.util.List;

import com.shubhamTravels.TravellingBackEnd.dto.Vehicle;

public interface VehicleDao {

	// CRUD Method
	public Vehicle getVehicleById(int id);
	public List<Vehicle> getAllVehicles();
	public boolean addVehicle(Vehicle vehicle);
	public boolean updateVehicle(Vehicle vehicle);
	public boolean deleteVehicle(Vehicle vehicle);
	
	// Other methods
	public List<Vehicle> getAllActiveVehicles();
	public List<String> getAllSeaterList();
	
	// For applying filters
	public List<Vehicle> getAllAppliedFiltersVehiclesFinal(List<Integer> catIds, String fuelType, String mileage,String numberOfSeater);
	
}
