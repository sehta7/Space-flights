package com.faustit.space.flights.dao;

import java.util.List;

import com.faustit.space.flights.model.Flight;
import com.faustit.space.flights.model.Tourist;

public interface FlightDao {

	public List<Flight> flightsList();
	public List<Tourist> touristsList(Flight flight);
	public List<Tourist> touristsList();
	public void addFlight(Flight flight);
	public void deleteFlight(String id);
	public  void updateFlight(Flight flight);
	public Flight findById(String id);
	public void addTourist(String touristId, String flightId);
	public void deleteTourist(String touristId, String flightId);
}
