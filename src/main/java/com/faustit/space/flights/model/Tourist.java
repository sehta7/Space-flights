package com.faustit.space.flights.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Tourist {

	@Id
	private String id;
	private String firstName;
	private String lastName;
	private String gender;
	private String country;
	private String notes;
	private Date birth;
	private List<Flight> flights;
	private List<Tourist> tourists;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public List<Flight> getFlights() {
		return flights;
	}
	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}
	
	public List<Tourist> getTourists() {
		return tourists;
	}
	public void setTourists(List<Tourist> tourists) {
		this.tourists = tourists;
	}
	
	@Override
	public String toString() {
		return "Tourist [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender
				+ ", country=" + country + ", notes=" + notes + ", birth=" + birth + ", flights=" + flights + "]";
	}
	
}
