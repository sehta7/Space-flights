package com.faustit.space.flights.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faustit.space.flights.dao.FlightDao;
import com.faustit.space.flights.model.Flight;
import com.faustit.space.flights.model.Tourist;

@Service
public class FlightServiceImpl implements FlightService{

	@Autowired
	FlightDao flightDao;
	
	public List<Flight> flightsList() {
		return flightDao.flightsList();
	}

	public List<Flight> flightsList(Flight flight) {
		return flightDao.flightsList(flight);
	}

	public List<Tourist> touristsList() {
		return flightDao.touristsList();
	}

	public void addFlight(Flight flight) {
		flightDao.addFlight(flight);
		
	}

	public void deleteFlight(String id) {
		flightDao.deleteFlight(id);
		
	}

	public void updateFlight(Flight flight) {
		flightDao.updateFlight(flight);
		
	}

	public Flight findById(String id) {
		return flightDao.findById(id);
	}

	public void addTourist(String touristId, String flightId) {
		flightDao.addTourist(touristId, flightId);
		
	}

	public void deleteTourist(String touristId, String flightId) {
		flightDao.deleteTourist(touristId, flightId);
		
	}

}
