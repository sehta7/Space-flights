package com.faustit.space.flights.service;

import java.util.List;

import com.faustit.space.flights.model.Flight;
import com.faustit.space.flights.model.Tourist;

public interface TouristService {

	public List<Tourist> touristsList();
	public void addTourist(Tourist tourist);
	public void deleteTourist(Tourist tourist);
	public  void updateTourist(Tourist tourist);
	public void addFlight(Flight flight, Tourist tourist);
	public void deleteFlight(Flight flight, Tourist tourist);
}