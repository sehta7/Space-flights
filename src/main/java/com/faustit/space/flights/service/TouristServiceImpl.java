package com.faustit.space.flights.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faustit.space.flights.dao.TouristDao;
import com.faustit.space.flights.model.Flight;
import com.faustit.space.flights.model.Tourist;

@Service
public class TouristServiceImpl implements TouristService{

	@Autowired
	TouristDao touristDao;
	
	public List<Tourist> touristsList() {
		return touristDao.touristsList();
	}

	public void addTourist(Tourist tourist) {
		touristDao.addTourist(tourist);
		
	}

	public void deleteTourist(Tourist tourist) {
		touristDao.deleteTourist(tourist);
		
	}

	public void updateTourist(Tourist tourist) {
		touristDao.updateTourist(tourist);
		
	}

	public void addFlight(Flight flight, Tourist tourist) {
		touristDao.addFlight(flight, tourist);
		
	}

	public void deleteFlight(Flight flight, Tourist tourist) {
		touristDao.deleteFlight(flight, tourist);
		
	}

}
