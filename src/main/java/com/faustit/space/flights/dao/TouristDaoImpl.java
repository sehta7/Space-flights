package com.faustit.space.flights.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.faustit.space.flights.model.Flight;
import com.faustit.space.flights.model.Tourist;

@Repository
public class TouristDaoImpl implements TouristDao{

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public List<Tourist> touristsList() {
		String sql = "select * from tourists";
		List<Tourist> touristsList = jdbcTemplate.query(sql, new RowMapper<Tourist>() {
			public Tourist mapRow(ResultSet rs, int rowNumber) throws SQLException{
				Tourist tourist = new Tourist();
				tourist.setId(rs.getString("id"));
				tourist.setFirstName(rs.getString("firstName"));
				tourist.setLastName(rs.getString("lastName"));
				tourist.setGender(rs.getInt("gender"));
				tourist.setCountry(rs.getString("country"));
				tourist.setNotes(rs.getString("notes"));
				tourist.setBirth(rs.getDate("birth"));
				System.out.println("TOURIST: " + tourist.toString());
				return tourist;
			}
		});
		return touristsList;
	}
	
	public List<Flight> flightsList(Tourist tourist){
		String sql = "select f.id, f.departure, f.arrival, f.seatsNumber, f.price" + 
				" from flights as f, tourists_flights as tf" + 
				" where f.id=tf.flightId" + 
				" and tf.touristId='"+tourist.getId()+"'";
		List<Flight> flightsList = jdbcTemplate.query(sql, new RowMapper<Flight>() {
			public Flight mapRow(ResultSet rs, int rowNumber) throws SQLException{
				Flight flight = new Flight();
				flight.setId(rs.getString("id"));
				flight.setDeparture(rs.getTimestamp("departure"));
				flight.setArrival(rs.getTimestamp("arrival"));
				flight.setSeatsNumber(rs.getInt("seatsNumber"));
				flight.setPrice(rs.getFloat("price"));
				System.out.println("FLIGHT: " + flight.toString());
				return flight;
			}
		});
		return flightsList;
		
	}

	public void addTourist(Tourist tourist) {
		String sql = "insert into tourists (firstName, lastName, gender, country, notes, birth) values (?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, new Object[] {tourist.getFirstName(), tourist.getLastName(), tourist.getGender(), tourist.getCountry(), tourist.getNotes(), tourist.getBirth()});
		
	}

	public void deleteTourist(Tourist tourist) {
		String sql = "delete from tourists where id='"+tourist.getId()+"'";
		jdbcTemplate.update(sql);
		
	}

	public void updateTourist(Tourist tourist) {
		String sql = "update tourists set firstName='"+tourist.getFirstName()+"',lastName='"+tourist.getLastName()+"',gender='"+tourist.getGender()+"',country='"+tourist.getCountry()+"',notes='"+tourist.getNotes()+"',birth='"+tourist.getBirth()+"',flights='"+tourist.getFlights()+"'";
		jdbcTemplate.update(sql);
		
	}

	public void addFlight(Flight flight, Tourist tourist) {
		if(flight.getTourists().size() < flight.getSeatsNumber()) {
			String sql = "update tourists set flights='"+tourist.getFlights()+"'";
			
			/*List<Flight> flightsList = jdbcTemplate.query(sql, new RowMapper<Flight>() {
				public Flight mapRow(ResultSet rs) throws SQLException{
					
				}
			});*/
		}
		
	}

	public void deleteFlight(Flight flight, Tourist tourist) {
		// TODO Auto-generated method stub
		
	}

}
