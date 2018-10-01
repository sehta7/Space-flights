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
		// TODO Auto-generated method stub
		return null;
	}

	public List<Flight> flightsList(Flight flight) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Tourist> touristsList() {
		// TODO Auto-generated method stub
		return null;
	}

	public void addFlight(Flight flight) {
		// TODO Auto-generated method stub
		
	}

	public void deleteFlight(String id) {
		// TODO Auto-generated method stub
		
	}

	public void updateFlight(Flight flight) {
		// TODO Auto-generated method stub
		
	}

	public Flight findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void addTourist(String itouristI, String flightId) {
		// TODO Auto-generated method stub
		
	}

	public void deleteTourist(String touristId, String flightId) {
		// TODO Auto-generated method stub
		
	}

}
