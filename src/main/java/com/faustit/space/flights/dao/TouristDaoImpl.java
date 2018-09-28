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
		String sql = "select t.firstName, t.lasnName, t.gender, t.country, t.notes, t.birth," + 
				"f.departure, f.arrival, f.price from tourists t, flaights f";
		List<Tourist> touristsList = jdbcTemplate.query(sql, new RowMapper<Tourist>() {
			public Tourist mapRow(ResultSet rs, int rowNumber) throws SQLException{
				Tourist tourist = new Tourist();
				tourist.setFirstName(rs.getString("firstName"));
				tourist.setLastName(rs.getString("lastName"));
				tourist.setGender(rs.getInt("gender"));
				tourist.setCountry(rs.getString("country"));
				tourist.setNotes(rs.getString("notes"));
				tourist.setBirth(rs.getDate("birth"));
				String sql = "";
				return tourist;
			}
		});
		return touristsList;
	}

	public void addTourist(Tourist tourist) {
		String sql = "insert into tourists (firstName, lastName, gender, country, notes, birth, flights) values (?, ?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, new Object[] {tourist.getFirstName(), tourist.getLastName(), tourist.getGender(), tourist.getCountry(), tourist.getNotes(), tourist.getBirth(), tourist.getFlights()});
		
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
		if(flight.getTouristsNumber() < flight.getSeatsNumber()) {
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
