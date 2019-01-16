package com.faustit.space.flights.controller;

import java.util.List;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
		flightService.addFlight(flight);
		return new ModelAndView("redirect:/flight/flights");
	}
	
	@RequestMapping(value = "/saveTourist/{idF}", method = RequestMethod.POST)
	public ModelAndView saveTourist(@RequestParam("tourists") String tourist,
			@PathVariable("idF") String idF) {
		if(flightService.isSeat(idF)) {
			String idT = tourist.substring(tourist.indexOf(":") + 1, tourist.indexOf(","));
			flightService.addTourist(idT, idF);
			return new ModelAndView("redirect:/flight/list");
		}
		else {
			JOptionPane.showMessageDialog(null, "No more seats!");
		}
		return new ModelAndView("redirect:/flight/list");
	}
	
	@RequestMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") String id) {
		flightService.deleteFlight(id);
		return new ModelAndView("redirect:/flight/flights");
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") String id) {
		Flight flight = flightService.findById(id);
		ModelAndView model = new ModelAndView("flight/edit", "command", flight);
		return model;
	}
	
	@RequestMapping(value = "/editsave", method = RequestMethod.POST)
	public ModelAndView editsave(@ModelAttribute("Flight") Flight flight) {
		flightService.updateFlight(flight);
		return new ModelAndView("redirect:/flight/flights");
	}
	
	@RequestMapping("/deleteTourist/{idT}/{idF}")
	public ModelAndView deleteTourist(@PathVariable("idT") String idT, @PathVariable("idF") String idF) {
		flightService.deleteTourist(idT, idF);
		return new ModelAndView("redirect:/flight/list");
	}
	
	@RequestMapping("/addTourist/{idF}")
	public ModelAndView addTourist(@PathVariable("idF") String idF) {
		List<Tourist> tourists = flightService.touristsList();
		ModelAndView model = new ModelAndView("flight/addTourist", "command", new Tourist());
		model.addObject("tourists", tourists);
		Flight flight = flightService.findById(idF);
		model.addObject("flight", flight);
		model.addObject("idF", idF);
		return model;
	}
}
