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
public class FlightDaoImpl implements FlightDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
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

	public List<Tourist> touristsList(Flight flight) {
		String sql = "select t.id, t.firstName, t.lastName, t.gender, t.country, t.notes, t.birth"
				+ " from tourists as t, tourists_flights as tf" + " where t.id=tf.touristId and tf.flightId='"
				+ flight.getId() + "'";
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
				return tourist;
			}
		});
		return touristsList;
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
				return tourist;
			}
		});
		return touristsList;
	}

	public void addFlight(Flight flight) {
		String sql = "insert into flights (departure, arrival, seatsNumber, price) values (?, ?, ?, ?)";
		jdbcTemplate.update(sql, new Object[] { flight.getDeparture(), flight.getArrival(), flight.getSeatsNumber(),
				flight.getPrice() });

	}

	public void deleteFlight(String id) {
		String sql = "delete from flights where id='" + id + "'";
		jdbcTemplate.update(sql);
		sql = "delete from tourists_flights where flightId='"+id+"'";
		jdbcTemplate.update(sql);

	}

	public void updateFlight(Flight flight) {
		String sql = "update flights set departure='" + flight.getDeparture() + "',arrival='"
				+ flight.getArrival() + "',seatsNumber='" + flight.getSeatsNumber() + "',price='" + flight.getPrice()
				+ " where id='"+ flight.getId() + "'";
		jdbcTemplate.update(sql);

	}

	public Flight findById(String id) {
		String sql = "select * from flights where id=?";
		Flight flight = jdbcTemplate.queryForObject(sql, new Object[] { id },
				new BeanPropertyRowMapper<Flight>(Flight.class));
		return flight;
	}

	public void addTourist(String touristId, String flightId) {
		String sql = "insert into tourists_flights (touristId, flightId) values (?, ?)";
		jdbcTemplate.update(sql, new Object[] { touristId, flightId });

	}

	public void deleteTourist(String touristId, String flightId) {
		String sql = "delete from tourists_flights where touristId='" + touristId + "' and " + "flightId='" + flightId+ "'";
		jdbcTemplate.update(sql);

	}

}
