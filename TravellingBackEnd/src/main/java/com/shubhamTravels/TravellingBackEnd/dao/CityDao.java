package com.shubhamTravels.TravellingBackEnd.dao;

import java.util.List;

import com.shubhamTravels.TravellingBackEnd.dto.City;

public interface CityDao {

	// CRUD Method
	public City getCityByName(String name);
	public List<City> getAllCities();
	public boolean addCity(City city);
	public boolean updateCity(City city);
	public boolean deleteCity(City city); 
	
	
}
