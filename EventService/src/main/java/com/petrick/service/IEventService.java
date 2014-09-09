package com.petrick.service;

import java.util.List;

import com.petrick.persistence.Event;

public interface IEventService {
	//public List<Event> getAllEvents();
	public Event findOne(final long id);
	public List<Event> findAll();
}
