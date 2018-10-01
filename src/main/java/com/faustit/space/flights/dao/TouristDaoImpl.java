package com.faustit.space.flights.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.faustit.space.flights.model.Flight;
import com.faustit.space.flights.model.Tourist;

@Repository
public class TouristDaoImpl implements TouristDao {

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
			public Tourist mapRow(ResultSet rs, int rowNumber) throws SQLException {
				Tourist tourist = new Tourist();
				tourist.setId(rs.getString("id"));
				tourist.setFirstName(rs.getString("firstName"));
				tourist.setLastName(rs.getString("lastName"));
				tourist.setGender(rs.getInt("gender"));
				tourist.setCountry(rs.getString("country"));
				tourist.setNotes(rs.getString("notes"));
				tourist.setBirth(rs.getDate("birth"));
				// System.out.println("TOURIST: " + tourist.toString());
				return tourist;
			}
		});
		return touristsList;
	}

	public List<Flight> flightsList(Tourist tourist) {
		String sql = "select f.id, f.departure, f.arrival, f.seatsNumber, f.price"
				+ " from flights as f, tourists_flights as tf" + " where f.id=tf.flightId" + " and tf.touristId='"
				+ tourist.getId() + "'";
		List<Flight> flightsList = jdbcTemplate.query(sql, new RowMapper<Flight>() {
			public Flight mapRow(ResultSet rs, int rowNumber) throws SQLException {
				Flight flight = new Flight();
				flight.setId(rs.getString("id"));
				flight.setDeparture(rs.getTimestamp("departure"));
				flight.setArrival(rs.getTimestamp("arrival"));
				flight.setSeatsNumber(rs.getInt("seatsNumber"));
				flight.setPrice(rs.getFloat("price"));
				// System.out.println("FLIGHT: " + flight.toString());
				return flight;
			}
		});
		return flightsList;

	}

	public List<Flight> flightsList() {
		String sql = "select * from flights";
		List<Flight> flightsList = jdbcTemplate.query(sql, new RowMapper<Flight>() {
			public Flight mapRow(ResultSet rs, int rowNumber) throws SQLException {
				Flight flight = new Flight();
				flight.setId(rs.getString("id"));
				flight.setDeparture(rs.getTimestamp("departure"));
				flight.setArrival(rs.getTimestamp("arrival"));
				flight.setSeatsNumber(rs.getInt("seatsNumber"));
				flight.setPrice(rs.getFloat("price"));
				return flight;
			}
		});
		return flightsList;
	}

	public void addTourist(Tourist tourist) {
		String sql = "insert into tourists (firstName, lastName, gender, country, notes, birth) values (?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, new Object[] { tourist.getFirstName(), tourist.getLastName(), tourist.getGender(),
				tourist.getCountry(), tourist.getNotes(), tourist.getBirth() });

	}

	public void deleteTourist(String id) {
		String sql = "delete from tourists where id='" + id + "'";
		jdbcTemplate.update(sql);

	}

	public void updateTourist(Tourist tourist) {
		System.out.println("Looking for: " + tourist.toString());
		String sql = "update tourists set" + " firstName='" + tourist.getFirstName() + "',lastName='"
				+ tourist.getLastName() + "',gender='" + tourist.getGender() + "',country='" + tourist.getCountry()
				+ "',notes='" + tourist.getNotes() + "',birth='" + tourist.getBirth() + "'" + " where id='"
				+ tourist.getId() + "'";
		jdbcTemplate.update(sql);

	}

	public Tourist findById(String id) {
		String sql = "select * from tourists where id=?";
		Tourist tourist = jdbcTemplate.queryForObject(sql, new Object[] { id },
				new BeanPropertyRowMapper<Tourist>(Tourist.class));
		return tourist;
	}

	public void addFlight(String idF, String idT) {
		String sql = "insert into tourists_flights (touristId, flightId) values (?, ?)";
		jdbcTemplate.update(sql, new Object[] { idT, idF });

	}

	public void deleteFlight(String touristId, String flightId) {
		String sql = "delete from tourists_flights where touristId='" + touristId + "' and " + "flightId='" + flightId
				+ "'";
		jdbcTemplate.update(sql);
	}

}
