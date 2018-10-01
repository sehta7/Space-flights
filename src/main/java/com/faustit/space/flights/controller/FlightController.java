package com.faustit.space.flights.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.faustit.space.flights.model.Flight;
import com.faustit.space.flights.model.Tourist;
import com.faustit.space.flights.service.FlightService;

@Controller
@RequestMapping("/flight")
public class FlightController {

	@Autowired
	FlightService flightService;
	
	@RequestMapping("/")
	public ModelAndView home() {
		return new ModelAndView("flight/home");
	}
	
	@RequestMapping("/flights")
	public ModelAndView flights() {
		List<Flight> flightsList = flightService.flightsList();
		for (Flight flight : flightsList) {
			List<Tourist> touristsList = flightService.touristsList(flight);
			flight.setTourists(touristsList);
		}
		ModelAndView modelAndView = new ModelAndView("flight/flights", "flightsList", flightsList);
		return modelAndView;
	}
	
	@RequestMapping("/list")
	public ModelAndView list() {
		List<Flight> flightsList = flightService.flightsList();
		List<Tourist> touristsList = null;
		for (Flight flight : flightsList) {
			touristsList = flightService.touristsList(flight);
			System.out.println("list: " + touristsList.toString());
			flight.setTourists(touristsList);
		}
		ModelAndView modelAndView = new ModelAndView("flight/list", "flightsList", flightsList);
		return modelAndView;
	}
	
	@RequestMapping("/add")
	public ModelAndView add() {
		ModelAndView model = new ModelAndView("flight/add", "command", new Flight());
		return model;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("flight") Flight flight) {
		System.out.println("In controller");
		flightService.addFlight(flight);
		return new ModelAndView("redirect:/flight/flights");
	}
	
	@RequestMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") String id) {
		flightService.deleteFlight(id);
		return new ModelAndView("redirect:/flight/flights");
	}
}
