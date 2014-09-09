package com.petrick.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.petrick.persistence.Event;
import com.petrick.persistence.dao.IEventDAO;


@Controller
@RequestMapping(value = "/addevent")
public class AddEventController{
	
	@Autowired
	private IEventDAO eventDao;
	
	@ModelAttribute("event")
	public Event getGreetingObject() {
		return new Event();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String displayInputMask(ModelMap model) {	
		return "addevent"; // The string specifies the jsp file to route that to!	 
	}
	 
	@RequestMapping(method = RequestMethod.POST)
	public String addEventSubmit(@ModelAttribute Event event, 
	Model model) {
		eventDao.saveAndFlush(event);
	    model.addAttribute("event", event);	      
	    return "events"; // where to redirect after form submission
	}
}
