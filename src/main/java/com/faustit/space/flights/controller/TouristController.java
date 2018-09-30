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
import com.faustit.space.flights.service.TouristService;

@Controller
@RequestMapping("/tourist")
public class TouristController {

	@Autowired
	TouristService touristService;
	
	@RequestMapping("/")
	public ModelAndView home() {
		return new ModelAndView("tourist/home", "lastName", new String());
	}
	
	@RequestMapping("/tourists")
	public ModelAndView tourists() {
		List<Tourist> touristsList = touristService.touristsList();
		ModelAndView modelAndView = new ModelAndView("tourist/tourists", "touristsList", touristsList);
		return modelAndView;
	}
	
	@RequestMapping("/list")
	public ModelAndView list() {
		List<Tourist> touristsList = touristService.touristsList();
		System.out.println("Controller --> " + touristsList.toString());
		List<Flight> flightsList = null;
		for (Tourist tourist : touristsList) {
			flightsList = touristService.flightsList(tourist);
			tourist.setFlights(flightsList);
			System.out.println("next flight of " + tourist.toString() + " = " + flightsList.toString());
		}
		ModelAndView modelAndView = new ModelAndView("tourist/list", "touristsList", touristsList);
		return modelAndView;
	}
	
	@RequestMapping("/add")
	public ModelAndView add() {
		ModelAndView model = new ModelAndView("tourist/add", "command", new Tourist());
		Map<String, String> gender = new HashMap<String, String>();
		gender.put("0", "not know");
		gender.put("1", "male");
		gender.put("2", "female");
		gender.put("9", "not applicable");
		model.addObject("gender", gender);
		return model;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("tourist") Tourist tourist) {
		touristService.addTourist(tourist);
		return new ModelAndView("redirect:/tourist/tourists");
	}
	
	@RequestMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") String id) {
		touristService.deleteTourist(id);
		return new ModelAndView("redirect:/tourist/tourists");
	}
	
}
