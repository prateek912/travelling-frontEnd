package com.shubhamTravels.TravellingBackEnd.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shubhamTravels.TravellingBackEnd.dao.VehicleDao;
import com.shubhamTravels.TravellingBackEnd.dto.Vehicle;

@Repository("vehicleDao")
@Transactional
public class VehicleImpl implements VehicleDao {

	@Autowired
	private SessionFactory factory;

	private int lowValue = 0;
	private int highValue = 0;
	
	@Override
	public Vehicle getVehicleById(int id) {
		try {
			return (Vehicle) factory.getCurrentSession().get(Vehicle.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Vehicle> getAllVehicles() {
		try {
			return factory.getCurrentSession().createQuery("FROM Vehicle", Vehicle.class).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addVehicle(Vehicle vehicle) {
		try {
			factory.getCurrentSession().persist(vehicle);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateVehicle(Vehicle vehicle) {
		try {
			factory.getCurrentSession().update(vehicle);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteVehicle(Vehicle vehicle) {
		// We are not deleting product, we are just making it de-active
		vehicle.setActive(false);
		try {
			// Call Update method of this class
			return this.updateVehicle(vehicle);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	private List<Vehicle> getActiveVehicleByCatId(List<Integer> catIds) {
		String selectActiveVehiclesByCategory = "FROM Vehicle where active =:active and (categoryid IN (:categoryId)"
				+ " and booked =:booked)";
		return factory.getCurrentSession().createQuery(selectActiveVehiclesByCategory, Vehicle.class)
				.setParameter("active", true).setParameterList("categoryId", catIds).setParameter("booked", false)
				.getResultList();
	}

	@Override
	public List<Vehicle> getAllActiveVehicles() {
		String selectActiveVehicles = "FROM Vehicle where active =:active and booked =:booked";
		return factory.getCurrentSession().createQuery(selectActiveVehicles, Vehicle.class).setParameter("active", true)
				.setParameter("booked", false).getResultList();
	}

	private List<Vehicle> getAllVehicleBasedOnFuelAndCat(List<Integer> catIds, String fuelType) {
		String selectActiveVehiclesByCategoryAndFuel = "FROM Vehicle where (active =:active and booked =:booked) and (categoryid IN (:categoryId)"
				+ " and fuelType =:fuelType)";
		return factory.getCurrentSession().createQuery(selectActiveVehiclesByCategoryAndFuel, Vehicle.class)
				.setParameter("active", true)
						.setParameter("booked", false)
							.setParameterList("categoryId", catIds)
								.setParameter("fuelType", fuelType)
									.getResultList();
	}

	private List<Vehicle> getAllVehicleBasedOnMileageAndCat(List<Integer> catIds, String mileage) {
		
		if(!mileage.isEmpty()) {
			setLowAndHigh(mileage);
		}else {
			// To make sure it does not encounter any errors
			lowValue = 0;
			highValue = 100;
		}
		
		String selectActiveVehiclesByCategoryAndFuel = "FROM Vehicle where (active =:active and booked =:booked) "
				+ "and (categoryid IN (:categoryId)"
				+ " and (mileage between :lowValue and :highValue)";
		
		return factory.getCurrentSession().createQuery(selectActiveVehiclesByCategoryAndFuel, Vehicle.class)
				.setParameter("active", true)
						.setParameter("booked", false)
							.setParameterList("categoryId", catIds)
								.setInteger("lowValue", lowValue)
									.setInteger("highValue", highValue)
										.getResultList();
	}
	
	private List<Vehicle> getAllVehicleBasedOnFuel(String fuelType) {
		String selectActiveVehiclesBasedOnFuel = "FROM Vehicle where (active =:active and booked =:booked) and fuelType =:fuelType";
		return factory.getCurrentSession().createQuery(selectActiveVehiclesBasedOnFuel, Vehicle.class)
				.setParameter("active", true)
					.setParameter("booked", false)
						.setParameter("fuelType",fuelType)
							.getResultList();
	}
	
	private List<Vehicle> getAllVehicleBasedOnFuelAndMileage(String fuelType,String mileage) {
		
		if(!mileage.isEmpty()) {
			setLowAndHigh(mileage);
		}else {
			// To make sure it does not encounter any errors
			lowValue = 0;
			highValue = 100;
		}
		
		String selectActiveVehiclesBasedOnFuel = "FROM Vehicle where (active =:active and booked =:booked) and fuelType =:fuelType"
				+ " and (mileage between :lowValue and :highValue)";
		return factory.getCurrentSession().createQuery(selectActiveVehiclesBasedOnFuel, Vehicle.class)
				.setParameter("active", true)
					.setParameter("booked", false)
						.setParameter("fuelType",fuelType)
							.setInteger("lowValue", lowValue)
								.setInteger("highValue", highValue)
									.getResultList();
	}
	
	private List<Vehicle> getAllVehicleBasedOnMileage(String mileage) {
		
		if(!mileage.isEmpty()) {
			setLowAndHigh(mileage);
		}else {
			// To make sure it does not encounter any errors
			lowValue = 0;
			highValue = 100;
		}
		
		String selectActiveVehiclesBasedOnFuel = "FROM Vehicle where (active =:active and booked =:booked) and"
				+ "(mileage between :lowValue and :highValue)";
		
		return factory.getCurrentSession().createQuery(selectActiveVehiclesBasedOnFuel, Vehicle.class)
				.setParameter("active", true)
					.setParameter("booked", false)
						.setInteger("lowValue", lowValue)
							.setInteger("highValue", highValue)
								.getResultList();
	}

	private List<Vehicle> allAppliedFilters(List<Integer> catIds, String fuelType, String mileage){
		
		if(!mileage.isEmpty()) {
			setLowAndHigh(mileage);
		}else {
			// To make sure it does not encounter any errors
			lowValue = 0;
			highValue = 100;
		}
	
		String appliedFilterSearch = "FROM Vehicle where (categoryid IN (:ids)) and (fuelType =:fuelType)"
				+ "and (mileage between :lowValue and :highValue) and"
				+ "(active =:active) and (booked =:booked)";
		
		
		return factory.getCurrentSession().createQuery(appliedFilterSearch,Vehicle.class)
						.setParameterList("ids", catIds)
							.setParameter("fuelType", fuelType)
								.setInteger("lowValue", lowValue)
									.setInteger("highValue", highValue)
										.setParameter("active", true)
											.setParameter("booked", false)
												.getResultList();
	}
	
	
	@Override
	public List<Vehicle> getAllAppliedFiltersVehicles(List<Integer> catIds, String fuelType, String mileage) {
		
		// Here we have to decide which query to fire according to selected Filters
		String queryToFire=decideWhichQueryToFire(catIds,fuelType,mileage);	
		List<Vehicle> vehicleList = new ArrayList<>();
		
		switch(queryToFire) {
		
			case "mileageOnly":
					System.out.println("Mieage only filter!!");
					vehicleList = getAllVehicleBasedOnMileage(mileage);
					break;
			
			case "fuelTypeOnly":
				System.out.println("Fuel only filter!!");
					vehicleList = getAllVehicleBasedOnFuel(fuelType);
					break;
				
			case "fuenAndMileageOnly":
					System.out.println("Mieage and Fuel only filter!!");
					vehicleList = getAllVehicleBasedOnFuelAndMileage(fuelType,mileage);
					break;
					
			case "categoryOnly":
					System.out.println("Category only filter!!");
					vehicleList = getActiveVehicleByCatId(catIds);
					break;
					
			case "catAndMileageOnly":
					System.out.println("Category and mileage only filter!!");
					vehicleList = getAllVehicleBasedOnMileageAndCat(catIds,mileage);
					break;
			
			case "catAndFuelOnly":
					System.out.println("Category and fuel only filter!!");
					vehicleList = getAllVehicleBasedOnFuelAndCat(catIds,fuelType);
					break;
					
			case "allApplied":
					System.out.println("All applied!!");
					vehicleList = allAppliedFilters(catIds,fuelType,mileage);
					break;
		}
		
		return vehicleList;
	}
	
	
	// Method to decide which query to fire
	private String decideWhichQueryToFire(List<Integer> catIds, String fuelType, String mileage) {
		
		if(catIds == null || catIds.size() == 0) {
			if(fuelType == null || fuelType.isEmpty()) {
				// Fire Query for Mileage only
				return "mileageOnly";
			}else if(mileage == null || mileage.isEmpty()){
				return "fuelTypeOnly";
			}else {
				return "fuenAndMileageOnly";
			}
		}else if(fuelType == null || fuelType.isEmpty()) {
				if(mileage == null || mileage.isEmpty()) {
					return "categoryOnly";
				}else {
					return "catAndMileageOnly";
				}
		}else if(mileage == null || mileage.isEmpty()){
			return "catAndFuelOnly";
		}else {
			return "allApplied";
		}
	}
	
	// To Set low and high value if mileage has been selected
	private void setLowAndHigh(String mileage) {
		if(mileage.equals("<10KM")) {
			lowValue = 0;
			highValue = 10;
		}else if(mileage.equals("10-15KM")) {
			lowValue = 10;
			highValue = 15;
		}else {
			lowValue = 15;
			// Just taking it as hundred
			highValue = 100;
		}
		System.out.println("Low value set to :"+lowValue);
		System.out.println("high value set to :"+highValue);
	}

}
