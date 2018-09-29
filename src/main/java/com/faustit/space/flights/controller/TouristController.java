package com.faustit.space.flights.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
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
		ModelAndView model = new ModelAndView("tourist/home");
		return model;
	}
	
	@RequestMapping("/list")
	public ModelAndView list() {
		List<Tourist> touristsList = touristService.touristsList();
		System.out.println("Controller --> " + touristsList.toString());
		List<Flight> flightsList = null;
		ModelAndView modelAndView = new ModelAndView("tourist/list", "touristsList", touristsList);
		for (Tourist tourist : touristsList) {
			flightsList = touristService.flightsList(tourist);
			modelAndView.addObject("flightsList", flightsList);
		}
		return modelAndView;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String add() {
		return "tourist/add";
	}
	
}
