package com.shubhamTravels.TravellingBackEnd;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.shubhamTravels.TravellingBackEnd.dao.CityDao;
import com.shubhamTravels.TravellingBackEnd.dto.Address;
import com.shubhamTravels.TravellingBackEnd.dto.City;

public class CityTest {

	private static AnnotationConfigApplicationContext context;
	private static CityDao cityDao;
	private static City city;

	@BeforeClass
	public static void inti() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.shubhamTravels.TravellingBackEnd");
		context.refresh();

		cityDao = context.getBean(CityDao.class);
	}

	@Test
	@Ignore
	public void addCityTest() {

		// Address for City
		Address add1 = new Address();
		add1.setAddresslineOne("Tilak Nager");
		
				
		Address add2 = new Address();
		add2.setAddresslineOne("Saket Nager");
		
		Address add3 = new Address();
		add3.setAddresslineOne("Sector 62");
		
		Address add4 = new Address();
		add4.setAddresslineOne("Sector 23");

		City city1 = new City();
		city1.setCity_name("Indore");
		city1.setState_name("M.P");
		city1.setPincode(101010);
		add1.setCity(city1);
		add2.setCity(city1);
		List<Address> city1PointsList = new ArrayList<>();
		city1PointsList.add(add1);
		city1PointsList.add(add2);
		city1.setOur_Points(city1PointsList);
		
		
		City city2 = new City();
		city2.setCity_name("Noida");
		city2.setState_name("U.P");
		city2.setPincode(109323);
		add3.setCity(city2);
		List<Address> city2PointsList = new ArrayList<>();
		city2PointsList.add(add3);
		city2.setOur_Points(city2PointsList);
		
		City city3 = new City();
		city3.setCity_name("Gurgoan");
		city3.setState_name("Haryana");
		city3.setPincode(313131);
		
		List<Address> city3PointsList = new ArrayList<>();
		city3PointsList.add(add4);
		city3.setOur_Points(city3PointsList);
		add4.setCity(city3);
		
		assertEquals("Failed to add City!!!",true,cityDao.addCity(city1));
		assertEquals("Failed to add City!!!",true,cityDao.addCity(city2));
		assertEquals("Failed to add City!!!",true,cityDao.addCity(city3));
		
	}

}
