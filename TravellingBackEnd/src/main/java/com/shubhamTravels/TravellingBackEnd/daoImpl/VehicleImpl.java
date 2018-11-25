package com.shubhamTravels.TravellingBackEnd.daoImpl;

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

	@Override
	public List<String> getAllSeaterList() {
		String selectNumberOfSeater = "select distinct numberOfSeater from Vehicle";
		return factory.getCurrentSession().createQuery(selectNumberOfSeater,String.class)
					.getResultList();
	}
	

	@Override
	public List<Vehicle> getAllActiveVehicles() {
		String selectActiveVehicles = "FROM Vehicle where active =:active and booked =:booked";
		return factory.getCurrentSession().createQuery(selectActiveVehicles, Vehicle.class).setParameter("active", true)
				.setParameter("booked", false).getResultList();
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

	@Override
	public List<Vehicle> getAllAppliedFiltersVehiclesFinal(List<Integer> catIds, String fuelType, String mileage,
			String numberOfSeater) {

		System.out.println("Selected number of seater value :"+numberOfSeater);
		System.out.println("Selected Fuel Type value :"+fuelType);
		System.out.println("Selected Mileage value :"+mileage);
		
		// Setting some defaults value for Mileage if it is not selected by user
		if(!mileage.isEmpty()) {
			setLowAndHigh(mileage);
		}else {
			// To make sure it does not encounter any errors
			lowValue = 0;
			highValue = 100;
		}
	
		// Setting some defaults value for FuelType if it is not selected by user
		if(fuelType.isEmpty() || fuelType == null) {
			fuelType = "%%";
		}
		
		// Setting some defaults value for NumberOfSeater if it is not selected by user
		if(numberOfSeater == null || numberOfSeater.isEmpty()) {
			numberOfSeater = "%%";
		}
		
		String queryToFire = ""; 
		if(catIds == null || catIds.isEmpty() ) {
			queryToFire= "FROM Vehicle where"
					+ "	 (fuelType like :fuelType) and (mileage between :lowValue and :highValue) "
					+ "and (numberOfSeater like :seater) and"
					+ "(active =:active) and (booked =:booked)";
			
			return factory.getCurrentSession().createQuery(queryToFire,Vehicle.class)
						.setParameter("fuelType", fuelType)
							.setInteger("lowValue", lowValue)
								.setInteger("highValue", highValue)
									.setParameter("seater", numberOfSeater)
										.setParameter("active", true)
											.setParameter("booked", false)
												.getResultList();
		}else {
			queryToFire= "FROM Vehicle where (category_id IN (:ids))"
					+ "		and (fuelType like :fuelType) and (mileage between :lowValue and :highValue) "
					+ "and (numberOfSeater like :seater) and"
					+ "(active =:active) and (booked =:booked)";
			
			return factory.getCurrentSession().createQuery(queryToFire,Vehicle.class)
					.setParameterList("ids", catIds)
						.setParameter("fuelType", fuelType)
							.setInteger("lowValue", lowValue)
								.setInteger("highValue", highValue)
									.setParameter("seater", numberOfSeater)
										.setParameter("active", true)
											.setParameter("booked", false)
												.getResultList();
		}
		
	}

}
