package com.shubhamTravels.TravellingBackEnd.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shubhamTravels.TravellingBackEnd.dao.CityDao;
import com.shubhamTravels.TravellingBackEnd.dto.City;


@Repository("cityDao")
@Transactional
public class CityDaoImpl implements CityDao {

	@Autowired
	private SessionFactory factory;

	@Override
	public City getCityByName(String name) {
		String getCityByNameQuery = "FROM City where is_active =:active and city_name =: cityName";
		try {
			return factory.getCurrentSession()
					.createQuery(getCityByNameQuery, City.class)
						.setParameter("active", true)
							.setParameter("city_name", name)
								.getSingleResult();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<City> getAllCities() {
		String allActiveCityQuery = "FROM City where is_active =:active";
		try {
			return factory.getCurrentSession()
					.createQuery(allActiveCityQuery, City.class)
						.setParameter("active", true)
							.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addCity(City city) {
		try {
			factory.getCurrentSession().persist(city);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateCity(City city) {
		try {
			factory.getCurrentSession().update(city);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteCity(City city) {
		// We are not deleting product, we are just making it de-active
		city.setActive(false);
		try {
			// Call Update method of this class
			return this.updateCity(city);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
