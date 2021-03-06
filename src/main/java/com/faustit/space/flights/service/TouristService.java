package com.faustit.space.flights.service;

import java.util.List;

import com.faustit.space.flights.model.Flight;
import com.faustit.space.flights.model.Tourist;

public interface TouristService {

	public List<Tourist> touristsList();
	public List<Flight> flightsList(Tourist tourist);
	public List<Flight> flightsList();
	public void addTourist(Tourist tourist);
	public void deleteTourist(String id);
	public  void updateTourist(Tourist tourist);
	public Tourist findById(String id);
	public void addFlight(String idF, String idT);
	public void deleteFlight(String touristId, String flightId);
}
