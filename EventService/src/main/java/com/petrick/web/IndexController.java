package com.petrick.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.petrick.service.IEventService;

@Controller
@RequestMapping(value = "/events")
public class IndexController{

	@Autowired
	 private IEventService service;
	 
	 @RequestMapping(method = RequestMethod.GET)
	 public String getAllEvents(ModelMap model) {	 
			model.addAttribute("events", service.findAll());
			return "events"; // The string specifies the jsp file to route that to!	 
	}
}
