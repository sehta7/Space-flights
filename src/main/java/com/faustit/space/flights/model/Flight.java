package com.faustit.space.flights.model;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Flight {

	@Id
	private String id;
	private Timestamp departure;
	private Timestamp arrival;
	private int seatsNumber;
	private List<Tourist> tourists;
	private float price;
	private List<Flight> flights;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Timestamp getDeparture() {
		return departure;
	}
	public void setDeparture(Timestamp departure) {
		this.departure = departure;
	}
	public Timestamp getArrival() {
		return arrival;
	}
	public void setArrival(Timestamp arrival) {
		this.arrival = arrival;
	}
	public int getSeatsNumber() {
		return seatsNumber;
	}
	public void setSeatsNumber(int seatsNumber) {
		this.seatsNumber = seatsNumber;
	}
	public List<Tourist> getTourists() {
		return tourists;
	}
	public void setTourists(List<Tourist> tourists) {
		this.tourists = tourists;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	public List<Flight> getFlights() {
		return flights;
	}
	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}
	@Override
	public String toString() {
		return "id: " + id + ", departure: " + departure + ", arrival: " + arrival + ", seats: " + seatsNumber
				+ ", price: " + price;
	}
}
