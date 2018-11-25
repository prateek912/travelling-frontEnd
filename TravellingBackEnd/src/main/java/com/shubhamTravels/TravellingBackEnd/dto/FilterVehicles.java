package com.shubhamTravels.TravellingBackEnd.dto;

import java.util.List;

public class FilterVehicles {

	private List<Category> categoryList;
	private List<String> fuelTypeList;
	private List<Integer> numberOfSeaterList;
	
	public List<Category> getCategoryList() {
		return categoryList;
	}
	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}
	public List<String> getFuelTypeList() {
		return fuelTypeList;
	}
	public void setFuelTypeList(List<String> fuelTypeList) {
		this.fuelTypeList = fuelTypeList;
	}
	public List<Integer> getNumberOfSeaterList() {
		return numberOfSeaterList;
	}
	public void setNumberOfSeaterList(List<Integer> numberOfSeaterList) {
		this.numberOfSeaterList = numberOfSeaterList;
	}
	@Override
	public String toString() {
		return "FilterVehicles [categoryList=" + categoryList + ", fuelTypeList=" + fuelTypeList
				+ ", numberOfSeaterList=" + numberOfSeaterList + "]";
	}	
	
}
