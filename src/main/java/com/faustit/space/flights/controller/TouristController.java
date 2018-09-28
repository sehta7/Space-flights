package com.faustit.space.flights.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.faustit.space.flights.service.TouristService;

@Controller
@RequestMapping("/tourist")
public class TouristController {

	@Autowired
	TouristService touristService;
	
	@RequestMapping("/")
	public String home() {
		return "home";
	}
}
