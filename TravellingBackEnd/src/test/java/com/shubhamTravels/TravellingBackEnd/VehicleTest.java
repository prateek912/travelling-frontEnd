package com.shubhamTravels.TravellingBackEnd;

import static org.junit.Assert.assertEquals;


import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.shubhamTravels.TravellingBackEnd.dao.CategoryDao;
import com.shubhamTravels.TravellingBackEnd.dao.VehicleDao;
import com.shubhamTravels.TravellingBackEnd.dto.Category;
import com.shubhamTravels.TravellingBackEnd.dto.Vehicle;


public class VehicleTest {
	private static AnnotationConfigApplicationContext context;
	private static VehicleDao vehicleDao;
	private static Vehicle vehicle;
	private static CategoryDao catDao;

	
	@BeforeClass
	public static void inti() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.shubhamTravels.TravellingBackEnd");
		context.refresh();
		
		vehicleDao = context.getBean(VehicleDao.class);
	}
	
	// Test the add vehicle method
	@Test
	public void testAddVehicle() {
		
		Vehicle vehicle1 = new Vehicle();
		vehicle1.setName("Skoda Octavia");
		vehicle1.setBrand("SKODA");
		vehicle1.setCategory_id(1);
		vehicle1.setDescription("Sedan with Turbocharged Petrol Engine, Direct Injection System");
		vehicle1.setRentCharge(16.00);
		vehicle1.setFuelType("Diesel");
		vehicle1.setMileage(10);
		vehicle1.setNumberOfSeater("6");
		vehicle1.setRegisteredDate(new java.util.Date());
	

		Vehicle vehicle2 = new Vehicle();
		vehicle2.setName("Maruti Suzuki Ciaz");
		vehicle2.setBrand("Maruti Suzuki");
		vehicle2.setCategory_id(2);
		vehicle2.setDescription("Sedan with K15 Petrol Engine");
		vehicle2.setRentCharge(15.00);
		vehicle2.setFuelType("Petrol");
		vehicle2.setMileage(9);
		vehicle2.setNumberOfSeater("4");
		vehicle2.setRegisteredDate(new java.util.Date());
		
		Vehicle vehicle3 = new Vehicle();
		vehicle3.setName("Renault Duster");
		vehicle3.setBrand("Renault");
		vehicle3.setCategory_id(2);
		vehicle3.setDescription("SUV with 4 Cylinder In-line");
		vehicle3.setFuelType("Diesel");
		vehicle3.setRentCharge(17.00);
		vehicle3.setMileage(8);
		vehicle3.setNumberOfSeater("6");
		vehicle3.setRegisteredDate(new java.util.Date());
		
		Vehicle vehicle4 = new Vehicle();
		vehicle4.setName("Maruti Suzuki Omni");
		vehicle4.setBrand("Maruti Suzuki");
		vehicle4.setCategory_id(3);
		vehicle4.setDescription("he Omni is an affordable and frugal urban van for large families and taxi operators");
		vehicle4.setFuelType("CNG");
		vehicle4.setRentCharge(11.00);
		vehicle4.setMileage(17);
		vehicle4.setNumberOfSeater("2");
		vehicle4.setRegisteredDate(new java.util.Date());
		
		
		Vehicle vehicle5 = new Vehicle();
		vehicle5.setName("Nano");
		vehicle5.setBrand("TATA");
		vehicle5.setCategory_id(5);
		vehicle5.setDescription("Budget range 4 people car");
		vehicle5.setFuelType("CNG");
		vehicle5.setRentCharge(9.00);
		vehicle5.setMileage(13);
		vehicle5.setNumberOfSeater("4");
		vehicle5.setRegisteredDate(new java.util.Date());
		
		Vehicle vehicle6 = new Vehicle();
		vehicle6.setName("PickUp");
		vehicle6.setBrand("TATA");
		vehicle6.setCategory_id(4);
		vehicle6.setDescription("Pickup Van");
		vehicle6.setFuelType("Petrol");
		vehicle6.setRentCharge(9.00);
		vehicle6.setMileage(13);
		vehicle6.setNumberOfSeater("4");
		vehicle6.setRegisteredDate(new java.util.Date());
		
		
		assertEquals("Failed while adding vehicle!!",true,vehicleDao.addVehicle(vehicle1));
		assertEquals("Failed while adding vehicle!!",true,vehicleDao.addVehicle(vehicle2));
		assertEquals("Failed while adding vehicle!!",true,vehicleDao.addVehicle(vehicle3));
		assertEquals("Failed while adding vehicle!!",true,vehicleDao.addVehicle(vehicle4));
		assertEquals("Failed while adding vehicle!!",true,vehicleDao.addVehicle(vehicle5));
		assertEquals("Failed while adding vehicle!!",true,vehicleDao.addVehicle(vehicle6));
		
	}
	
	// Test get vehicle method
	@Test
	@Ignore
	public void testGetVehicleById() {
		assertEquals("Failed while fetching vehicle by ID ","Renault Duster",vehicleDao.getVehicleById(3).getName());
	}
	
	// Testing update vehicle method
	@Test
	@Ignore
	public void testVechileupdate() {
		vehicle = vehicleDao.getVehicleById(6);
		vehicle.setBooked(true);
		
		vehicleDao.updateVehicle(vehicle);
		
		assertEquals("Failed while updating vehicle!!",true,vehicleDao.getVehicleById(6).isBooked());
	}
	
	// Testing delete method
	@Test
	@Ignore
	public void testDeleteVehicle() {
		vehicle = vehicleDao.getVehicleById(6);
		vehicleDao.deleteVehicle(vehicle);
		
		assertEquals("Failed while de-activating vehicle!!",false,vehicleDao.getVehicleById(6).isActive());
	}
	
	// Testing get all active vehicles
	@Test
	@Ignore
	public void testGetAllVehicles() {
		assertEquals("Failed while fetching all active vehicles!!",6, vehicleDao.getAllVehicles().size());
	}
	
}
