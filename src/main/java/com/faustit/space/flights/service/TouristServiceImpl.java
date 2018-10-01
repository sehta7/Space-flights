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
	
	public List<Flight> flightsList(Tourist tourist) {
		return touristDao.flightsList(tourist);
	}
	
	public List<Flight> flightsList() {
		return touristDao.flightsList();
	}

	public void addTourist(Tourist tourist) {
		touristDao.addTourist(tourist);
		
	}

	public void deleteTourist(String id) {
		touristDao.deleteTourist(id);
		
	}

	public void updateTourist(Tourist tourist) {
		touristDao.updateTourist(tourist);
		
	}
	
	public Tourist findById(String id) {
		return touristDao.findById(id);
	}

	public void addFlight(String idF, String idT) {
		touristDao.addFlight(idF, idT);
		
	}

	public void deleteFlight(String touristId, String flightId) {
		touristDao.deleteFlight(touristId, flightId);
		
	}

}
